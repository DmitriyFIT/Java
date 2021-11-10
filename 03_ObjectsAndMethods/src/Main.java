public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.add("Bread", 60, 1, 400);
        basket.add("Oil", 150, 2, 600);
        basket.print("Milk");
    }
}