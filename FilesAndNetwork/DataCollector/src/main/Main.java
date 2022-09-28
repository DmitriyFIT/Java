package main;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        ParseAndJsonCreate parseAndJsonCreate = new ParseAndJsonCreate();
        parseAndJsonCreate.parseHtml();
        parseAndJsonCreate.createJsonMapFile();
        parseAndJsonCreate.parseJsonMapFile();

        String pathFolder;
        System.out.println("Enter path of folder:");
        Scanner in = new Scanner(System.in);
        pathFolder = in.next();
        parseAndJsonCreate.findAllFiles(pathFolder);

        parseAndJsonCreate.createJsonStation();
    }
}
