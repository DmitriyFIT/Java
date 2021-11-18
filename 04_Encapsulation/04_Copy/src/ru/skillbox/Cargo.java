package ru.skillbox;

public class Cargo {

    private final int resault;
    private final int weight;
    private final String deliveryAddress;
    private final boolean turnOver;
    private final String registrationNumber;
    private final boolean fragile;

    public Cargo(int resault, int weight, String deliveryAddress, boolean turnOver, String registrationNumber, boolean fragile) {
        this.resault = resault;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.turnOver = turnOver;
        this.registrationNumber = registrationNumber;
        this.fragile = fragile;
    }

    public Cargo setWeight(int weight) {
        return new Cargo(resault, weight, deliveryAddress, turnOver, registrationNumber, fragile);
    }

    public Cargo setDeliveryAddress(String deliveryAddress) {
        return new Cargo(resault, weight, deliveryAddress, turnOver, registrationNumber, fragile);
    }

    public Cargo setDimensions(int resault){
        return new Cargo(resault, weight, deliveryAddress, turnOver, registrationNumber, fragile);
    }

    public int getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isTurnOver() {
        return turnOver;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isFragile() {
        return fragile;
    }

    public void print() {
        System.out.println(resault + " " + getWeight() + " " + getDeliveryAddress() + " " +
                            isTurnOver() + " " + getRegistrationNumber() + " " + isFragile());
    }
}
