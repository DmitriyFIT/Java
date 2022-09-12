package main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ParseHtml {

    public void parseHTML() throws IOException {
        Map<String, String> linesMap = new TreeMap<>();
        Map<String, String> stationsMap = new TreeMap<>();

        Document document = Jsoup.connect("https://skillbox-java.github.io/").get();
        Elements stations = document.select(".js-metro-stations");
        stations.forEach(station ->
                stationsMap.put(station.attr("data-line"), station.text()));

        Elements lines = document.select(".js-metro-line");
        lines.forEach(line ->
                linesMap.put(line.attr("data-line"), line.text()));

        System.out.println("stationMap:");
        for (Map.Entry<String,String> item : stationsMap.entrySet()) {
            System.out.println(item.getKey() + item.getValue());
        }
        System.out.println("\n linesMap:");
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

    public void findFiles(String path) throws IOException, ParseException {
        List<String> listOfCsvFiles = new ArrayList<>();
        List<String> listOfJsonFiles = new ArrayList<>();
        File file = new File(path);

        for (File f : file.listFiles()) {
            if (f.isFile()) {
                String pathOfFile = f.getAbsolutePath();
                if (pathOfFile.matches(".*.csv")) {
                    listOfCsvFiles.add(pathOfFile);
                    parseCsvFile(pathOfFile);
                }
                if (pathOfFile.matches(".*.json")) {
                    listOfJsonFiles.add(pathOfFile);
                    parseJsonFile(pathOfFile);
                }
            } else {
                findFiles(f.getPath());
            }
        }
    }

    public void parseCsvFile(String pathCsv) {
        StringBuilder builderCsv = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Path.of(pathCsv));
            lines.forEach(line -> builderCsv.append(line));
            System.out.println(builderCsv.toString());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void parseJsonFile(String pathJson) throws IOException, ParseException {
        Map<String, String> map = new HashMap<>();
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(pathJson);
        JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            map.put((String) jsonObject.get("name"), (String) jsonObject.get("date"));
        }

        for (Map.Entry<String, String> m : map.entrySet()) {
            System.out.println("name - " + m.getKey() + " - date - " + m.getValue());
        }
    }
}