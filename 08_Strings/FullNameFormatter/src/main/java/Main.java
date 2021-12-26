import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (true) {
      String input = scanner.nextLine();
      if (input.equals("0")) {
        break;
      }
      //TODO:напишите ваш код тут, результат вывести в консоль.
      //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
      int countSpace = 0;
      boolean rightString = true;
      for (int i = 0; i < input.length(); i++) {
        if (Character.isSpaceChar(input.charAt(i))) {
          countSpace++;
        }
        if (Character.UnicodeBlock.
                of(input.charAt(i)).
                equals(Character.UnicodeBlock.CYRILLIC) ||
                input.charAt(i) == ' ' ||
                input.charAt(i) == '-' ||
                !Character.isDigit(input.charAt(i))) {
          continue;
        }
        else {
          rightString =false;
          break;
        }
      }

      if (countSpace != 2 || !rightString) {
        System.out.println("Введенная строка не является ФИО");
      }
      else {
        String surname = input.substring(0, input.indexOf(' '));
        String name = input.substring(input.indexOf(' '), input.lastIndexOf(' '));
        String secondName = input.substring(input.lastIndexOf(' '));
        System.out.println("Фамилия: " + surname);
        System.out.println("Имя:" + name);
        System.out.println("Отчество:" + secondName);
      }
    }
  }
}