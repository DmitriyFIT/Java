public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;

    private static int totalPriceAllBaskets = 0;
    private static int totalCount = 0;
    private static int priceBasket = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice, double weight) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 1, 0);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }
        items = items + "\n" + name + " - " +
                count + " шт. - " + price + " - " + weight * count + " гр.";
        totalPrice = totalPrice + count * price;
        totalWeight += count * weight;
        increaseTotalPriceAllBaskets(count, price);
        increaseTotalCount(count);
    }

    public void clear() {
        items = "";
        //totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println("Total Weight: " + getTotalWeight());
        }
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public static void increaseTotalPriceAllBaskets(int price, int count) {
        Basket.totalPriceAllBaskets += price * count;
    }

    public static int getTotalPriceAllBaskets(){
        return Basket.totalPriceAllBaskets;
    }

    public static void increaseTotalCount(int count) {
        Basket.totalCount += count;
    }

    public static int getTotalCount() {
        return Basket.totalCount;
    }

    public static int getAveragePriceAllBaskets() {
        return Basket.getTotalPriceAllBaskets() / Basket.getTotalCount();
    }

    public static int getAveragePriceOneBasket() {
        return Basket.getTotalPriceAllBaskets() / getCount();
    }
}
