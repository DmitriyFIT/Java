package ru.skillbox;

public class Elevator {

    private int maxFloor;
    private int minFloor;
    private int curentFloor = 1;

    public Elevator(int minFloor, int maxFloor){
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurentFloor(){
        return curentFloor;
    }

    public void moveDown(){
        if(curentFloor <= minFloor) {
            System.out.println("Нельзя спуститься ниже нижнего этажа!!!");
        }
        else {
            curentFloor -= 1;
            System.out.println(getCurentFloor());
        }
    }

    public void moveUp(){
        if (curentFloor >= maxFloor) {
            System.out.println("Нельзя подняться выше последнего этажа!!!");
        }
        else {
            curentFloor += 1;
            System.out.println(getCurentFloor());
        }
    }

    public void move(int floor){
        System.out.println("Текущий этаж: " + getCurentFloor());
        if (floor >= minFloor && floor <= maxFloor){
            if (curentFloor < floor){
                for (int i = curentFloor; i < floor; i++){
                    moveUp();
                }
            }
            else if (curentFloor > floor){
                for (int i = curentFloor; i > floor; i--){
                    moveDown();
                }
            }
            else {
                System.out.println("Вы находитесь на этом этаже!");
            }
        }
        else{
            System.out.println("Ошибка! Введен неверный этаж!");
        }
    }
}
