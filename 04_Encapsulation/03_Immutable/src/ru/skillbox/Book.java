package ru.skillbox;

public class Book {

    private final String name;
    private  final String author;
    private  final int countPages;
    private  final int isbn;

    public Book(String name, String author, int countPages, int isbn) {
        this.name = name;
        this.author = author;
        this.countPages = countPages;
        this.isbn = isbn;
    }

    public String getName() { return name; }

    public String  getAuthor() {
        return author;
    }

    public int getCountPages() {
        return countPages;
    }

    public int getIsbn() {
        return isbn;
    }

    public void print() {
        System.out.println(getName() + " " + getAuthor() + " " + getCountPages() + " " + getIsbn());
    }
}
