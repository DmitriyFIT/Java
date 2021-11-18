

public class Car {

    private String brandCar;
    private String bodyType;
    private String typeOil;
    private int power;

    public Car(String brandCar, String bodyType) {
        this.brandCar = brandCar;
        this.bodyType = bodyType;
    }

    public void setBrandCar(String brandCar){
        this.brandCar = brandCar;
    }

    public void setBodyType(String bodyType){
        this.bodyType = bodyType;
    }

    public void setTypeOil(String typeOil){
        this.typeOil = typeOil;
    }

    public void setPower(int power){
        this.power = power;
    }

    public String getBrandCar(){
        return brandCar;
    }

    public String getBodyType(){
        return bodyType;
    }

    public String getTypeOil() {
        return typeOil;
    }

    public int getPower() {
        return power;
    }

    public void print() {
        System.out.println(getBrandCar() + " " + getBodyType() + " " + getTypeOil() + " " + getPower());
    }
}
