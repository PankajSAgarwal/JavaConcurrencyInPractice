package playground.chapter7_CancellationAndShutdown;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * Extending Thread class directly is an anti-pattern .
 * Typically, as task is created
 * We can use the interrupted status to determine when to shut down
 * the prime producer thread
 */
public class PrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;

    public PrimeProducer(BlockingQueue<BigInteger> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        try{
            BigInteger p = BigInteger.ONE;
            while(!Thread.currentThread().isInterrupted())
                queue.put(p.nextProbablePrime());

        } catch (InterruptedException consumed) {
            /* Allow thread to exit */
        }
    }

    public void cancel(){
        interrupt();
    }
}
