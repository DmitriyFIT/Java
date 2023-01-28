import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NumberGeneration implements Runnable {

    private FileChannel fileChannel;
    private RandomAccessFile randomAccessFile;
    private int fromRegion;
    private int toRegion;

    public NumberGeneration(int fileNumber, int fromRegion, int toRegion) throws FileNotFoundException {
        StringBuilder fileName = (new StringBuilder()).append("res/numbers").append(fileNumber).append(".txt");

        this.randomAccessFile = new RandomAccessFile(fileName.toString(), "rw");
        this.fileChannel = randomAccessFile.getChannel();
        this.fromRegion = fromRegion;
        this.toRegion = toRegion;
    }

    public void run() {

        char[] letters = new char[]{'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

        try {

            for (int region = fromRegion; region <= toRegion ; region++) {
                StringBuilder builder = new StringBuilder();
                for (int number = 1; number < 1000; number++) {
                    for (char firstLetter : letters) {
                        for (char secondLetter : letters) {
                            for (char thirdLetter : letters) {
                                builder.append(firstLetter).append(padNumber(number, 3))
                                        .append(secondLetter).append(thirdLetter)
                                        .append(padNumber(region, 2))
                                        .append("\n");
                            }
                        }
                    }
                }
                ByteBuffer buffer = ByteBuffer.wrap(builder.toString().getBytes());
                fileChannel.write(buffer);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String padNumber(int number, int numberLength) {
        StringBuilder builder = new StringBuilder(Integer.toString(number));
        int padSize = numberLength - builder.length();

        for (int i = 0; i < padSize; ++i) {
            builder.insert(0, "0");
        }

        return builder.toString();
    }
}