package playground.chapter7_CancellationAndShutdown;

import com.sun.jmx.snmp.tasks.Task;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * save the interrupted status in a local variable
 */
public class SavingTheInterruptedStatus {
    private final BlockingQueue<Task> queue;

    public SavingTheInterruptedStatus(BlockingQueue<Task> queue) {
        this.queue = queue;
    }

    public Task getNextTask(){
        boolean interrupted = false;
        try{
            while(true){
                try{
                    return queue.take();
                } catch (InterruptedException e) {
                    interrupted = true;
                }
            }
        }finally {
            if(interrupted)
                Thread.currentThread().interrupt();// re-interrupt
        }
    }
}
