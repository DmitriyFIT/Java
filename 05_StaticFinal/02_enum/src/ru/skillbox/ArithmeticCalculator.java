package ru.skillbox;

public class ArithmeticCalculator {

    private final int firstNimber;
    private final int secondNumber;

    ArithmeticCalculator(int firstNimber, int secondNumber) {
        this.firstNimber = firstNimber;
        this.secondNumber = secondNumber;
    }

    public void calculate(Operation type) {
        switch (type) {
            case ADD:
                System.out.println("Сумма числел " + firstNimber +
                    " и " + secondNumber + " равна: " +
                    (firstNimber + secondNumber)
                );
            break;
            case SUBTRACT:
                System.out.println("Разность числел " + firstNimber +
                    " и " + secondNumber + " равна: " +
                    (firstNimber - secondNumber)
                );
            break;
            case MULTIPLY:
                System.out.println("Произведение числел " + firstNimber +
                    " и " + secondNumber + " равно: " +
                    (firstNimber * secondNumber)
                );
        }
    }
}
