import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private final static String SITE_URL = "https://skillbox.ru";

    public static void main(String[] args) throws IOException {
        Node node = new Node(SITE_URL);
        new ForkJoinPool().invoke(new Recursive(node));

        FileOutputStream stream = new FileOutputStream("C:\\Users\\Smart\\IdeaProjects\\java_basics\\Multithreading\\MapSite\\src\\main\\resources\\MapSite.txt");
        String result = createSitemapString(node, 0);
        stream.write(result.getBytes());
        stream.flush();
        stream.close();
    }

    public static String createSitemapString(Node node, int depth) {
        String tabs = String.join("", Collections.nCopies(depth, "\t"));
        StringBuilder result = new StringBuilder(tabs + node.getUrl() + "\n");

        node.getChildren().forEach(child -> result.append(createSitemapString(child, depth + 1)));

        return result.toString();
    }
}