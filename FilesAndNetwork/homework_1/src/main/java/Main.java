import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String path;
        double size;
        FileUtils fu = new FileUtils();

        Scanner in = new Scanner(System.in);
        for (;;) {
            System.out.println("Введите путь до папки:");
            path = in.next();
            size = (double) fu.calculateFolderSize(path);

            int count = 0;
            while (size > 1024) {
                 size /= 1024;
                count++;
            }
            String formattedSize = new DecimalFormat("0.00").format(size);
            String outputConsole = "Размер папки " + path + " составляет: " + formattedSize;
            switch (count) {
                case 0:
                    System.out.println(outputConsole + " байт");
                    break;
                case 1:
                    System.out.println(outputConsole + " Кб");
                    break;
                case 2:
                    System.out.println(outputConsole + " Мб");
                    break;
                case 3:
                    System.out.println(outputConsole + " Гб");
                    break;
                case 4 :
                    System.out.println(outputConsole + " Тб");
                    break;
            }
        }
     }
}
