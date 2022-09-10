package main;

public class Main {
    private static final String PATH = "FilesAndNetwork\\DataCollector\\src\\data\\code.html";
    public static void main(String[] args) {

    ParseHtml parseHtml = new ParseHtml();
    parseHtml.parseHTML(PATH);
    }
}
