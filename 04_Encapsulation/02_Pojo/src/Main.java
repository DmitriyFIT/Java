public class Main {
    public static void main(String[] args) {

        Country country = new Country("Belarus");
        country.setAreaCountry(10000);
        country.setCountPeople(1000000);
        country.setNameCapital("Minsk");
        country.setWayToSea(false);
        country.print();

        Car car = new Car("Mazda", "SUV");
        car.setTypeOil("Diesel");
        car.setPower(230);
        car.print();
    }
}
