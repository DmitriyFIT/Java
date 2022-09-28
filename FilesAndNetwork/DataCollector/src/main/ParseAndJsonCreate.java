package main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.Line;
import main.Station;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ParseAndJsonCreate {
    List<Line> lines = new ArrayList<>();
    List<Station> stations = new ArrayList<>();
    List<String> connectionStations = new ArrayList<>();
    Map<String, String> mapDates = new HashMap<>();
    Map<String, String> mapDepths = new HashMap<>();
    public void parseHtml() throws IOException {
        Document document = Jsoup.connect("https://skillbox-java.github.io/").get();
        Element metroData = document.getElementById("metrodata");

        Elements elementsOfLines = metroData.getElementsByClass("js-metro-line");
        addLines(elementsOfLines);

        Elements elementsOfStation = metroData.getElementsByClass("js-metro-stations");
        addStations(elementsOfStation);

        Elements elementsOfConnection = metroData.getElementsByClass("t-icon-metroln");
        addConnections(elementsOfConnection);
    }

    public void addLines(Elements elements) {
        lines = new ArrayList<>();
        elements.forEach(element -> lines.add(new Line(element.text(), element.attr("data-line"))));
    }

    public void addStations(Elements elements) {
        elements.forEach(st -> stations.add(
                new Station(st.text().replaceAll("[0-9][0-9]?.", ""),
                        st.attr("data-line"))));
    }

    public void addConnections(Elements elements) {
        for (Element element : elements) {
            String connection = element.attr("title");
            if (connection.contains("переход на")) {
                int startIndex = connection.indexOf("«");
                int finishIndex = connection.indexOf("»");
                connectionStations.add(connection.substring(startIndex + 1, finishIndex));
            }
        }
    }

    public void createJsonMapFile() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String path = "FilesAndNetwork\\DataCollector\\src\\resource\\map.json";
        JSONObject jsonObject = new JSONObject();
        String key = "stations";

        JSONObject objectStation = new JSONObject();
        for (Station station : stations) {
            JSONArray array = new JSONArray();
            String elementOfLines = station.getName();
            String[] parts = elementOfLines.split("[\\s][\\s]");
            for (String part : parts) {
                array.add(part.trim());
            }
            objectStation.put(station.getLine(), array);
            jsonObject.put(key, objectStation);
        }

        String key2 = "lines";
        JSONArray array = new JSONArray();
        for (Line line : lines) {
            JSONObject object = new JSONObject();
            object.put("number", line.getNumber());
            object.put("line", line.getName());
            array.add(object);
        }
        jsonObject.put(key2, array);

        PrintWriter writer = new PrintWriter(new FileWriter(path));
        writer.write(gson.toJson(jsonObject));
        writer.flush();
        writer.close();
    }

    public void parseJsonMapFile() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("FilesAndNetwork\\DataCollector\\src\\resource\\map.json");
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        jsonObject = (JSONObject) jsonObject.get("stations");
        Set<String> keys = jsonObject.keySet();
        for (String str : keys) {
            JSONArray jsonArray = (JSONArray) jsonObject.get(str);
            System.out.println("Line Number - " + str + " - Count Of Stations On The Line - " + jsonArray.size());
        }
    }

    public void findAllFiles(String pathFolder) throws IOException, ParseException {
        File file = new File(pathFolder);
        for (File f : file.listFiles()) {
            if (f.isFile()) {
                String pathOfFile = f.getAbsolutePath();
                if (pathOfFile.matches(".*.csv")) {
                    parseCsvFile(pathOfFile);
                }
                if (pathOfFile.matches(".*.json")) {
                    parseJsonFile(pathOfFile);
                }
            }
            else {
                findAllFiles(f.getPath());
            }
        }
    }

    public void parseCsvFile (String path) throws IOException {
        if (path.matches(".*dates-1.csv") || path.matches(".*dates-3.csv")) {
            List<String> linesOfFile = Files.readAllLines(Path.of(path));
            for (String line : linesOfFile) {
                if (!line.matches("Название.*")) {
                    String[] str = line.split(",");
                    mapDates.put(str[0], str[1]);
                }
            }
        }
        if (path.matches(".*depths-2.csv")) {
            List<String> linesOfFile = Files.readAllLines(Path.of(path));
            for (String line : linesOfFile) {
                if (!line.matches("Название.*")) {
                    String[] str = line.split(",");
                    char ch = str[1].charAt(0);
                    if (ch == '"') {
                        mapDepths.put(str[0], str[1].substring(1));
                    }
                    else if (ch != '?'){
                        mapDepths.put(str[0], str[1]);
                    }
                }
            }
        }
    }

    public void parseJsonFile(String path) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader(path);
        JSONArray jsonArray = (JSONArray) jsonParser.parse(fileReader);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);

        if (jsonObject.containsKey("date")) {
            for (int i = 0; i < jsonArray.size(); i++) {
                jsonObject = (JSONObject) jsonArray.get(i);
                mapDates.put((String) jsonObject.get("name"),
                        (String) jsonObject.get("date"));
            }
        }
        if (jsonObject.containsKey("depth")) {
            for (int i = 0; i < jsonArray.size(); i++) {
                jsonObject = (JSONObject) jsonArray.get(i);
                mapDepths.put((String) jsonObject.get("name"),
                        jsonObject.get("depth").toString());
            }
        }
        if (jsonObject.containsKey("depth_meters")) {
            for (int i = 0; i < jsonArray.size(); i++) {
                jsonObject = (JSONObject) jsonArray.get(i);
                mapDepths.put((String) jsonObject.get("station_name"),
                        jsonObject.get("depth_meters").toString());
            }
        }
    }

    public void createJsonStation() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String path = "FilesAndNetwork\\DataCollector\\src\\resource\\station.json";
        JSONObject jsonObject = new JSONObject();
        String key = "stations";
        String name = null;
        String lineName = null;
        String date = null;
        double depth = 0;
        boolean hasConnection = false;
        JSONArray array = new JSONArray();

        for (Station station : stations) {
            String stationNames = station.getName();
            String[] stationName = stationNames.split("[\\s][]\\s]");

            for (int i = 0; i < stationName.length; i++) {
                JSONObject object = new JSONObject();
                name = stationName[i];
                for (Line line : lines) {
                    if (station.getLine().equals(line.getNumber())) {
                        lineName = line.getName();
                        break;
                    }
                }
                for (Map.Entry<String, String> map : mapDates.entrySet()) {
                    if (name.equals(map.getKey())) {
                        date = map.getValue();
                        break;
                    }
                }
                for (Map.Entry<String, String> map : mapDepths.entrySet()) {
                    if (name.equals(map.getKey())) {
                        String str = map.getValue();
                 //       depth = Double.parseDouble(str);
                        break;
                    }
                }
                for (String str : connectionStations) {
                    if (name.equals(str)) {
                        hasConnection = true;
                    }
                    else {
                        hasConnection = false;
                    }
                }
                object.put("name", name);
                object.put("line", lineName);
                object.put("date", date);
                object.put("depth", depth);
                object.put("hasConnection", hasConnection);
                array.add(object);
            }
        }
        jsonObject.put(key, array);
        PrintWriter writer = new PrintWriter(new FileWriter(path));
        writer.write(gson.toJson(jsonObject));
        writer.flush();
        writer.close();
    }
}