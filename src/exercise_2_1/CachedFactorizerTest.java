package exercise_2_1;

import org.junit.*;
import servlet.MyHttpServletRequest;
import servlet.MyHttpServletResponse;
import util.SilentRunnable;

import javax.servlet.*;
import java.io.*;
import java.util.concurrent.*;

import static org.junit.Assert.*;

/**
 * DO NOT CHANGE.
 */
public class CachedFactorizerTest {
    @Test
    public void noCacheHits() throws IOException, ServletException {
        CachedFactorizer cf = new CachedFactorizer();
        for (int i = 0; i < 10_000; i++) {
            MyHttpServletResponse res = new MyHttpServletResponse();
            cf.doGet(new MyHttpServletRequest("number", Integer.toString(i)), res);
        }
        assertEquals(10_000, cf.getHits());
        assertEquals(0, cf.getCacheHitRatio(), 0.001);
    }

    @Test
    public void visibilityTest() throws IOException, ServletException, InterruptedException {
        final CachedFactorizer cf = new CachedFactorizer();
        Thread hitReaderThread = new Thread("HitReaderThread") {
            @Override
            public void run() {
                while (cf.getHits() == 0) ;
                System.out.println("Someone has hit the servlet");
            }
        };
        hitReaderThread.start();
        Thread.sleep(2000);
        for (int i = 0; i < 10_000; i++) {
            MyHttpServletResponse res = new MyHttpServletResponse();
            cf.doGet(new MyHttpServletRequest("number", Integer.toString(i)), res);
        }
        hitReaderThread.join(500);
        assertFalse("getHits() is not returning up-to-date values", hitReaderThread.isAlive());
    }

    @Test
    public void allCacheHits() throws IOException, ServletException {
        CachedFactorizer cf = new CachedFactorizer();
        for (int i = 0; i < 100; i++) {
            MyHttpServletResponse res = new MyHttpServletResponse();
            cf.doGet(new MyHttpServletRequest("number", "127"), res);
        }
        assertEquals(100, cf.getHits());
        assertEquals(0.99, cf.getCacheHitRatio(), 0.00001);
    }

    @Test
    public void correctHitCounterUpdating() throws IOException, ServletException, InterruptedException {
        final CachedFactorizer cf = new CachedFactorizer();
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            pool.execute(new SilentRunnable() {
                public void execute() throws IOException, ServletException {
                    for (int i = 0; i < 1_000_000; i++) {
                        MyHttpServletResponse res = new MyHttpServletResponse();
                        cf.doGet(new MyHttpServletRequest("number", "4"), res);
                    }
                }
            });
        }
        pool.shutdown();
        while (!pool.awaitTermination(1, TimeUnit.SECONDS)) ;
        assertEquals(4_000_000, cf.getHits());
        assertTrue("CacheHitRatio=" + cf.getCacheHitRatio(), cf.getCacheHitRatio() <= 0.99999975);
        assertTrue("CacheHitRatio=" + cf.getCacheHitRatio(), cf.getCacheHitRatio() >= 0.999999);
    }

    @Test
    public void parallelHits() throws IOException, ServletException, InterruptedException {
        int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        assertTrue("Test needs to run on a multi-processor machine", numberOfProcessors > 1);
        timeToFactorize(1);
        timeToFactorize(numberOfProcessors);
        double timeForOne = timeToFactorize(1);
        double timeForMany = timeToFactorize(numberOfProcessors);
        double speedup = timeForOne / timeForMany;
        System.out.println("speedup = " + speedup);
        assertTrue("We expect at least *some* speedup", speedup > 1.2);
    }

    private long timeToFactorize(
            final int concurrency) throws ServletException, IOException, InterruptedException {
        final CachedFactorizer cf = new CachedFactorizer();
        final ExecutorService pool = Executors.newFixedThreadPool(concurrency);
        long time = System.currentTimeMillis();
        for (int i = 0; i < concurrency; i++) {
            final int taskNumber = i;
            pool.execute(new SilentRunnable() {
                public void execute() throws IOException, ServletException {
                    int from = 48_000 * taskNumber / concurrency;
                    int upto = 48_000 * (taskNumber + 1) / concurrency;
                    System.out.println("from " + from + " to " + upto);

                    for (int number = from; number < upto; number++) {
                        MyHttpServletResponse res = new MyHttpServletResponse();
                        cf.doGet(new MyHttpServletRequest("number", Long.toString(number)), res);
                    }
                }
            });
        }
        pool.shutdown();
        while (!pool.awaitTermination(1, TimeUnit.SECONDS)) ;
        time = System.currentTimeMillis() - time;
        System.out.println("time = " + time);
        return time;
    }

    @Test
    public void correctFactorization() throws IOException, ServletException {
        CachedFactorizer cf = new CachedFactorizer();
        checkCorrectFactorization(cf, 173_556_661L, 230_387_617L);
        checkCorrectFactorization(cf, 489_593_567L, 513_730_573L);
    }

    private void checkCorrectFactorization(CachedFactorizer cf, long... factors)
            throws ServletException, IOException {
        MyHttpServletResponse res = new MyHttpServletResponse();
        long number = factors[0];
        StringBuilder expected = new StringBuilder("[").append(factors[0]);
        for (int i = 1; i < factors.length; i++) {
            long factor = factors[i];
            number *= factor;
            expected.append(", ").append(factor);
        }
        expected.append("]");

        cf.doGet(new MyHttpServletRequest("number", Long.toString(number)), res);
        assertEquals(expected.toString(), res.getContent());
    }

    public static void main(String[] args) {
        util.UnitTestRunner.run();
    }
}
