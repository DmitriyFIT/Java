public class Country {

    private String nameCounrty;
    private int countPeople;
    private int areaCountry;
    private String nameCapital;
    private boolean wayToSea = true;

    public Country(String nameCounrty) {
        this.nameCounrty = nameCounrty;
    }

    public void setNameCounrty(String nameCounrty) {
        this.nameCounrty = nameCounrty;
    }

    public void setCountPeople(int countPeople) {
        this.countPeople = countPeople;
    }

    public void setAreaCountry(int areaCountry) {
        this.areaCountry = areaCountry;
    }

    public void setNameCapital(String nameCapital) {
        this.nameCapital = nameCapital;
    }

    public void setWayToSea(boolean wayToSea) {
        this.wayToSea = wayToSea;
    }

    public String getNameCounrty() {
        return nameCounrty;
    }

    public int getCountPeople() {
        return countPeople;
    }

    public int getAreaCountry() {
        return areaCountry;
    }

    public String getNameCapital() {
        return nameCapital;
    }

    public boolean isWayToSea() {
        return wayToSea;
    }

    public void print() {
        System.out.println(getNameCounrty() + " " +
                getCountPeople() + " " +
                getAreaCountry() + " " +
                getNameCapital() + " " +
                isWayToSea());
    }
}
