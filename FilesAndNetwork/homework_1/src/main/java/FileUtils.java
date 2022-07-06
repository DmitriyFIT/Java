import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static long calculateFolderSize(String path) throws IOException {
        long size = 0;
        File folder = new File(path);
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                size += file.length();
            }
            else {
                size += calculateFolderSize(file.getPath());
            }
        }
        return size;
    }
}
