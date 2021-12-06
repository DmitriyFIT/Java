public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

        System.out.println("Преобразоване чисел в символы");
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if ((char) i >= 'А' && (char) i <= 'Я') {
                System.out.println(i + " - " + (char) i);
            }
            if ((char) i >= 'а' && (char) i <= 'я') {
                System.out.println(i + " - " + (char) i);
            }
            if ((char) i == 'Ё' || (char) i == 'ё') {
                System.out.println(i + " - " + (char) i);
            }
        }
    }
}
