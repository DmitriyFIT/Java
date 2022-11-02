import java.io.File;
import java.io.IOException;

public class Main {

    private static int newWidth = 300;
    public static void main(String[] args) throws IOException {
        String srcFolder = "C:\\Users\\Smart\\Desktop\\src";
        String dstFolder = "C:\\Users\\Smart\\Desktop\\dst";

        Runtime runtime = Runtime.getRuntime();
        int numberOfProcessors = runtime.availableProcessors();

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int partOfFiles = files.length / numberOfProcessors;
        Thread[] threads = new Thread[numberOfProcessors];

        int count = partOfFiles;
        for (int i = 0; i < numberOfProcessors; i++) {
            if (count + partOfFiles < files.length) {
                File[] file = new File[partOfFiles];
                System.arraycopy(files, (i * partOfFiles), file, 0, file.length);
                threads[i] = new Thread(new ImageResize(file, newWidth, dstFolder, start), String.format("Thread %d", i));
                count += partOfFiles;
            }
            else {
                int lastPartOfFiles = files.length-(count-partOfFiles);
                File[] file = new File[lastPartOfFiles];
                System.arraycopy(files, (i * partOfFiles), file, 0, lastPartOfFiles);
                threads[i] = new Thread(new ImageResize(file, newWidth, dstFolder, start), String.format("Thread %d", i));
            }
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
