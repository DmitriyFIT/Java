package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        Book book = new Book("The_Tale_of_the_Fisherman_and_the_Fish", "Pushkin", 25, 6582);
        book.print();

        Product product = new Product("Milk", 25415874);
        product.setPrice(83);
        product.print();
    }
}
