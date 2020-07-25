package playground.chapter6_TaskExecution;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Always prefer ScheduledExecutorService over TimerTasks
 */
public class ScheduledExecutorTest {
    public static void main(String[] args) {
        final ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
        timer.scheduleAtFixedRate(new Runnable() {
            private int count;
            @Override
            public void run() {

                if(count++ < 10)
                    System.out.println("ping " + count);
                else
                    timer.shutdown();
            }
        },1,1, TimeUnit.SECONDS);

        timer.schedule(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                System.out.println("PONG");
                Thread.sleep(5000);
                return null;
            }
        },4,TimeUnit.SECONDS);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                throw new NullPointerException();
            }
        },6,TimeUnit.SECONDS);
    }
}
