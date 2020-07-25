package playground.chapter6_TaskExecution;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            private int count;
            @Override
            public void run() {
                if(count++ <10)
                    System.out.println("ping" + count);
                else
                    timer.cancel();
            }
        },1000,1000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("PONG");
                try{
                    Thread.sleep(5000);
                }catch(InterruptedException e){} // bad
            }
        },4000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                throw new NullPointerException();
            }
        },13000);
    }
}
