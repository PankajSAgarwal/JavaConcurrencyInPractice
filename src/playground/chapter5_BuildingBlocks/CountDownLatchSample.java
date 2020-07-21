package playground.chapter5_BuildingBlocks;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch : Waiting for Threads to start
 *
 */
public class CountDownLatchSample {
    /**
     * 2 problems : a. Keep count of permit
     *              b. No way to run without interrupt without writing own code.
     */
    public static void runTasks(List<Runnable> tasks) throws InterruptedException{
        int size = tasks.size() + 1;
        final CountDownLatch latch = new CountDownLatch(size);
        for(final Runnable task : tasks){
            new Thread(() -> {
                try{
                    latch.countDown();
                    latch.await();
                    System.out.println("Running " + task);

                }catch (InterruptedException e) {
                    /* returning */
                    e.printStackTrace();
                }
            }).start();
            Thread.sleep(1000);
        }
        latch.countDown();
    }

    public static void runTasksSavingInterruptions(List<Runnable> tasks){
        int size = tasks.size() + 1;
        final CountDownLatch latch = new CountDownLatch(size);
        for(final Runnable task : tasks){
            new Thread(() -> {
                latch.countDown();
                boolean wasInterrupted = false;
                while(true){
                    try{
                        latch.await();
                        break;

                    }catch(InterruptedException e){
                        wasInterrupted = true;

                    }
                }
                if(wasInterrupted)
                    Thread.currentThread().interrupt();
                System.out.println("Running " + task);
                task.run();
            }).start();
        }

    }
}
