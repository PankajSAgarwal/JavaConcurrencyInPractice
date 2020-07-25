package playground.chapter6_TaskExecution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int poolSize = Runtime.getRuntime().availableProcessors() * 4 ;
        System.out.println("Pool size -->" + poolSize );
        ExecutorService pool = Executors.newFixedThreadPool(poolSize);
        Collection<Future<Long>> futures = new ArrayList<Future<Long>>();
        for (int i = 0; i < poolSize * 3; i++) {
            final int submitOrder = i;
            futures.add(pool.submit(new Callable<Long>() {
                @Override
                public Long call() throws Exception {
                    Random r = new Random();
                    long total = 0;
                    for (int j = 0; j < 10000000; j++) {
                        total += r.nextInt(5);
                    }
                    return total*10000 + submitOrder;
                }
            }));
            
        }
        for(Future<Long> future:futures){
            // Future results are retrieved in the order the jobs
            // were submitted , not in the order they were completed
            System.out.println(future.get());
        }
        pool.shutdown();
    }
}
