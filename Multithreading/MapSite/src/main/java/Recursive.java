import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RecursiveAction;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public class Recursive  extends RecursiveAction {

    private Node node;

    public Recursive(Node node) {
        this.node = node;
    }

    @Override
    protected void compute() {
        Set<Recursive> recursiveList = new HashSet<>();

        try {
            sleep(150);
            Connection connection = Jsoup.connect(node.getUrl()).timeout(2000);
            Document document = connection.get();
            Elements elements = document.select("body").select("a");
            for (Element element : elements) {
                String childUrl = element.absUrl("href");
                if (isCorrectUrl(childUrl)) {
                    childUrl = changeUrlParams(childUrl);
                    node.addChild(new Node(childUrl));
                }
            }
        } catch (IOException | InterruptedException exception) {
            exception.toString();
        }

        for (Node child : node.getChildren()) {
            Recursive recursive = new Recursive(child);
            recursive.fork();
            recursiveList.add(recursive);
        }

        for (Recursive recursive : recursiveList) {
            recursive.join();
        }
    }

    private boolean isCorrectUrl(String url) {
        Pattern patternRoot = Pattern.compile("^" + node.getUrl());
        Pattern patternNotFile = Pattern.compile("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|pdf))$)");
        Pattern patternNotAnchor = Pattern.compile("#([\\w\\-]+)?$");

        return patternRoot.matcher(url).lookingAt()
                && !patternNotFile.matcher(url).find()
                && !patternNotAnchor.matcher(url).find();
    }

    private String changeUrlParams(String url) {
        return url.replaceAll("\\?.+","");
    }
}