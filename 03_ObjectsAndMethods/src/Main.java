public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.add("Bread", 60, 1, 400);
        basket.add("Oil", 150, 2, 600);
        basket.print("Milk");

        Arithmetic arithmetic = new Arithmetic(5, 4);
        arithmetic.getSumma();
        arithmetic.getmMltiplication();
        arithmetic.findMaxNumber();
        arithmetic.findMinNumber();
        arithmetic.print();

        Printer printerHP = new Printer();
        printerHP.add("My First Work");
        printerHP.add("Me Second Work", "Test Prinring");
        printerHP.add("I want Study", "Study ", 6);
        printerHP.print();
        printerHP.add("TEST", "Test1", 8);
        printerHP.add("TEST1", "Test1");
        printerHP.add("TEST2");
        printerHP.print();
    }
}