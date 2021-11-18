package ru.skillbox;

public class Product {

    private final String name;
    private int price;
    private final int barCode;

    public Product(String name, int barCode) {
        this.name = name;
        this.barCode = barCode;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getBarCode() {
        return barCode;
    }

    public void print() {
        System.out.println(getName() + " " + getPrice() + " " + getBarCode());
    }
}
