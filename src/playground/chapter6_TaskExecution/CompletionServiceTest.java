package playground.chapter6_TaskExecution;

import java.util.Random;
import java.util.concurrent.*;

public class CompletionServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int poolSize = Runtime.getRuntime().availableProcessors()*4;
        ExecutorService pool = Executors.newFixedThreadPool(poolSize);

        CompletionService<Long> service = new ExecutorCompletionService<Long>(pool);
        for (int i = 0; i < poolSize * 3; i++) {
            final int submitOrder = i;
            service.submit(new Callable<Long>() {
                @Override
                public Long call() throws Exception {
                    Random r = new Random();
                    long total = 0;
                    for (int j = 0; j < 10000000; j++) {
                        total += r.nextInt(5);
                    }
                    return total*10000 + submitOrder;
                }
            });
        }
        for (int i = 0; i < poolSize * 3; i++) {
            // Unlike Future ,completion service return results in the order they were completed and not submitted
            System.out.println(service.take().get());
        }
        pool.shutdown();
    }
}
