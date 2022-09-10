package main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ParseHtml {

    public void parseHTML(String path) {
        Map<String, String> linesMap = new TreeMap<>();
        Map<String, String> stationsMap = new TreeMap<>();

        String htmlFile = parseFile(path);

        Document document = Jsoup.parse(htmlFile);
        Elements stations = document.select(".js-metro-stations");
        stations.forEach(station ->
                stationsMap.put(station.attr("data-line"), station.text()));

        Elements lines = document.select(".js-metro-line");
        lines.forEach(line ->
                linesMap.put(line.attr("data-line"), line.text()));

        for (Map.Entry<String,String> item : stationsMap.entrySet()) {
            System.out.println("KEY " + item.getKey() + "- VALUE" + item.getValue() + "END");
        }
        System.out.println("stationMap");
        for (Map.Entry<String,String> item : linesMap.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }

    public String parseFile(String path) {
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
}