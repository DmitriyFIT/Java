public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    //TODO: напишите ваш код, результат вывести в консоль
    int start;
    int end;
    int count;

    start = text.indexOf('5');
    end = start + 4;
    count = Integer.parseInt(text.substring(start, end));

    start = text.indexOf('7');
    end = text.indexOf('3') + 1;
    count += Integer.parseInt(text.substring(start, end));

    start = text.lastIndexOf('3');
    end = text.lastIndexOf('0') + 1;
    count += Integer.parseInt(text.substring(start, end));

    System.out.println(count);

    /*
    int start;
    int end = 0;
    int count = 0;
    char symbol;
    String textNumber;

    for (int i = end; i < text.length(); i++) {
      symbol = text.charAt(i);
      if (Character.isDigit(symbol)) {
        start = i;
        while (Character.isDigit(symbol)) {
          i++;
          end = i;
          symbol = text.charAt(i);
        }
        textNumber = text.substring(start, end);
        count += Integer.parseInt(textNumber);
      }
    }
    System.out.println(count);
    */
  }

}