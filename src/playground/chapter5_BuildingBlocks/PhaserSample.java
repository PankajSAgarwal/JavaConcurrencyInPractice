package playground.chapter5_BuildingBlocks;

import java.util.List;
import java.util.concurrent.Phaser;

public class PhaserSample {
    public static void runTasks(List<Runnable> tasks) throws InterruptedException {
        final Phaser phaser = new Phaser(1);// we register ourselves
        for(final Runnable task:tasks){
            phaser.register();// and we register all our new threads
            new Thread(){
                public void run(){
                    phaser.arriveAndAwaitAdvance();// saves interrupts for later. countdown latch and await
                    System.out.println("Running " + task);
                    task.run();
                }
            }.start();
            Thread.sleep(1000);
        }
        phaser.arriveAndDeregister();//we let the main thread arrive
    }

}
