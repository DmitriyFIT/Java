public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.add("Bread", 60, 1, 400);
        basket.add("Oil", 150, 2, 600);
        basket.print("Milk");

        Basket basket1 = new Basket();
        basket1.add("Cola", 20, 6, 1000);
        basket1.add("Pepsi", 25);
        basket1.print("Cola");

        System.out.println("Итоговая стоимость всех корзин: " + Basket.getTotalPriceAllBaskets());
        System.out.println("Всего товаров во всех корзинах: " + Basket.getTotalCount());
        System.out.println("Средняя цена товара в корзинах: " + Basket.getAveragePriceAllBaskets());
        System.out.println("Средняя стоимость корзины: " + Basket.getAveragePriceOneBasket());
        System.out.println("Всего корзин: " + Basket.getCount());

     /*   Arithmetic arithmetic = new Arithmetic(5, 4);
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
        printerHP.print();*/
    }
}