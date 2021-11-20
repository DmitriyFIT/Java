package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        Dimensions dimensions = new Dimensions(2, 2, 2);
        Dimensions dimensionsCopy = dimensions.setDimensions(3, 3, 3);

        Cargo cargo = new Cargo(dimensions, 20, "Kolasa_street", true,
                "25458AFD25", true);


        Cargo cargoCopy = cargo.setWeight(25);
        Cargo cargoCopy1 = cargo.setDeliveryAddress("Pobedy street");
        Cargo cargoCopy2 = cargo.setDimensions(dimensionsCopy);
        System.out.print("CargoCopy: ");
        cargoCopy.print();
        System.out.print("CargoCopy1: ");
        cargoCopy1.print();
        System.out.print("CargoCopy2: ");
        cargoCopy2.print();
        System.out.print("Cargo: ");
        cargo.print();

        System.out.print("DimensionsCopy: ");
        dimensionsCopy.print();
        System.out.print("Dimensions: ");
        dimensions.print();
    }
}
