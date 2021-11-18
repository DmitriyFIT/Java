package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        Dimensions dimensions = new Dimensions(2, 2, 2);
        Dimensions dimensionsCopy = dimensions.setDimensions(3, 3, 3);
        int resault = dimensionsCopy.getDimensions();
        Cargo cargo = new Cargo(dimensions.getDimensions(), 20, "Kolasa_street", true,
                "25458AFD25", true);


        Cargo cargoCopy = cargo.setWeight(25);
        Cargo cargoCopy1 = cargo.setDeliveryAddress("Pobedy street");
        Cargo cargoCopy2 = cargo.setDimensions(resault);
        cargoCopy.print();
        cargoCopy1.print();
        cargoCopy2.print();
        cargo.print();

        dimensionsCopy.print();
        dimensions.print();
    }
}
