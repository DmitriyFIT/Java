public class Arithmetic {

    private int firstNumber = 0;
    private int secondNumber = 0;
    private String title;


    public Arithmetic(int firstNumber, int secondNumber){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        title = "Арифметика: действия с числами " + firstNumber + " и " + secondNumber;
    }

    public int getSumma(){
        return firstNumber + secondNumber;
    }

    public int getmMltiplication(){
        return firstNumber * secondNumber;
    }

    public int findMaxNumber(){
        if (firstNumber > secondNumber){
            return firstNumber;
        }
        else {
            return secondNumber;
        }
    }

    public int findMinNumber(){
        if (firstNumber < secondNumber){
            return firstNumber;
        }
        else {
            return secondNumber;
        }
    }

    public void print(){
        System.out.println("\n" + title + "\nСумма чисел: " + getSumma() + "\nПроизведение числел: " + getmMltiplication() +
                "\nМаксимальное из двух числе: " + findMaxNumber() + "\nМинимальной из двух чисел: " + findMinNumber());
    }
}
