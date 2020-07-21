package playground.chapter3_SharingObjects;

import java.util.concurrent.atomic.AtomicLong;

/**
 * What output could we see ??
 * possible outputs
 * 42 - most frequent output
 * no output // ReaderThread caches field , "write" to ready field is then not visible to ReaderThread
 * 0 - if the writes to ready and number fields are re-ordered
 */
public class WaitingForMeaningOfLife {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
