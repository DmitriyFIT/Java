package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        ArithmeticCalculator calculator = new ArithmeticCalculator(6, 8);
        ArithmeticCalculator calculator1 = new ArithmeticCalculator(20, 40);

        Operation type = Operation.valueOf("ADD");
        calculator.calculate(type);
        calculator1.calculate(type);

        type = Operation.valueOf("SUBTRACT");
        calculator.calculate(type);
        calculator1.calculate(type);

        type = Operation.valueOf("MULTIPLY");
        calculator.calculate(type);
        calculator1.calculate(type);
    }
}
