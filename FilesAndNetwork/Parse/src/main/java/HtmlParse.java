import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class HtmlParse {

    public static String parseFileMetro(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            lines.forEach(line -> builder.append(line + "\n"));
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return builder.toString();
    }

    public void htmParseLinesMoscowMetro() {
        String htmlMetro = parseFileMetro("data\\code.html");
        Map<String, String> linesMetro = new TreeMap<>();
        List<String> number = new ArrayList<>();
        
        Document metro = Jsoup.parse(htmlMetro);
        Elements stations = metro.select("div.js-toggle-depend");

        stations.forEach(station ->
                linesMetro.put(station.text(), station.attr("data-line")));

        for (Map.Entry<String, String> line : linesMetro.entrySet()) {
            System.out.println("Line - " + line.getKey() + "\tNumber - " + line.getValue());
        }
    }
}