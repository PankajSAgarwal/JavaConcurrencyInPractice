package playground.chapter7_CancellationAndShutdown;

import net.jcip.annotations.ThreadSafe;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

@ThreadSafe
public class PrimeGenerator implements Runnable {

    private final List<BigInteger> primes = new CopyOnWriteArrayList<>();
    private volatile boolean cancelled = false;// using volatile is important
    public void cancel(){
        cancelled = true;
    }
    @Override
    public void run() {

        BigInteger p = BigInteger.ONE;
        while(!cancelled){
            p = p.nextProbablePrime();// this might take a while
            primes.add(p);
        }
    }
    public List<BigInteger> get(){
        return primes;
    }

    public static void main(String[] args) throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try{
            TimeUnit.SECONDS.sleep(1);
        }finally {
            generator.cancel();
        }
        System.out.println(generator.get());
    }
}
