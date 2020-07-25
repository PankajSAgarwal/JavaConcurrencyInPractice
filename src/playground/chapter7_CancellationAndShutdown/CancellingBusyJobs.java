package playground.chapter7_CancellationAndShutdown;

import java.math.BigInteger;
import java.util.concurrent.*;

public class CancellingBusyJobs {
    private static final int NThreads = 1;


    public  static <E> E timedRun(
            Callable<E> r,long timeout, TimeUnit unit)
            throws ExecutionException, InterruptedException {
        ExecutorService taskExec = Executors.newFixedThreadPool(NThreads);
        Future<E> task = taskExec.submit(r);
        try{
            return task.get(timeout,unit);
        } catch (InterruptedException e) {
            task.cancel(true);
            throw e;
        } catch (TimeoutException e) {
            task.cancel(true);
            return null;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        BigInteger prime = timedRun(new Callable<BigInteger>() {
            @Override
            public BigInteger call() throws Exception {
                BigInteger p = BigInteger.ONE;
                while (!Thread.currentThread().isInterrupted()){
                    p = p.nextProbablePrime();
                    if(p.toString().length() > 5) return p;
                }
                return null;
            }
        },3,TimeUnit.SECONDS);
        System.out.println(prime == null ? "not found": prime);
    }
}
