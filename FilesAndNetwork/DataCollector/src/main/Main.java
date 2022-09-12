package main;

import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        ParseHtml parseHtml = new ParseHtml();
        parseHtml.parseHTML();

        String path;
        System.out.println("Enter path:");
        Scanner in = new Scanner(System.in);
        path = in.next();
        parseHtml.findFiles(path);
    }
}
