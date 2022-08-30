import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String sourcePath;
        String destinationPath;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter source path folder:");
        sourcePath = in.next();
        System.out.println("Enter destination Path folder");
        destinationPath = in.next();
        FileUtils.copyFolder(sourcePath, destinationPath);
    }
}
