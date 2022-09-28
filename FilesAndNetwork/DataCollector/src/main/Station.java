package main;

public class Station {
    String name;
    String line;

    public Station(String name, String line) {
        this.name = name;
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public String getLine() {
        return line;
    }
}
