package ru.skillbox;

public class Dimensions {

    private final int width;
    private final int height;
    private final int lengh;

    public Dimensions(int width, int height, int lengh) {
        this.width = width;
        this.height = height;
        this.lengh = lengh;
    }

    public Dimensions setDimensions(int width, int height, int lengh) {
        return new Dimensions(width, height, lengh);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getLengh() {
        return lengh;
    }

    public int getDimensions() {
        return getWidth() * getHeight() * getLengh();
    }

    public void print() {
        System.out.println(getDimensions());
    }
}
