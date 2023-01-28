import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Loader {
    public static final int COUNT_PROCESSORS = Runtime.getRuntime().availableProcessors();
    public static final int REGIONS = 199;

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();

        int fromRegion = 1;
        int step = REGIONS / COUNT_PROCESSORS;
        int toRegion = step;

        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        Set<Future<?>> poolSet = new HashSet<>();

        for (int i = 1; i <= COUNT_PROCESSORS; i++) {
            if (i == COUNT_PROCESSORS) {
                poolSet.add(pool.submit(new NumberGeneration(i, fromRegion, REGIONS)));
            }
            poolSet.add(pool.submit(new NumberGeneration(i, fromRegion, toRegion)));
            fromRegion = toRegion;
            toRegion += step;
        }

        poolSet.forEach(ps -> {
            try {
                ps.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }
}