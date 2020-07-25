package playground.chapter7_CancellationAndShutdown;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * The cancellation mechanism in Prime generator works only if the thread does not enter in the WAITING state
 * e.g calling put() or await() or take()
 */
public class BrokenPrimeProducer extends Thread{
    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    public BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            BigInteger p = BigInteger.ONE;
            while (!cancelled)
                queue.put(p = p.nextProbablePrime());


        } catch (InterruptedException consumed) {

        }
    }
    public void cancel(){
        cancelled = true;
    }
}
