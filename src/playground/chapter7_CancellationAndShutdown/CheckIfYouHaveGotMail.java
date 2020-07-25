package playground.chapter7_CancellationAndShutdown;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public class CheckIfYouHaveGotMail {
    public boolean checkMail(Set<String> hosts, long timeout, TimeUnit unit) throws InterruptedException, TimeoutException {
        ExecutorService exec = Executors.newCachedThreadPool();
        final AtomicBoolean hasNewMail = new AtomicBoolean(false);
        try{
            for(final String host: hosts)
                exec.execute(new Runnable() {
                    @Override
                    public void run() {
                            if(checkMail(host))
                                hasNewMail.set(true);

                    }
                });
        }finally {
                exec.shutdownNow();
                if(!exec.awaitTermination(timeout,unit)){
                    exec.shutdownNow();
                    throw new TimeoutException();
                }
        }
        return hasNewMail.get();
    }

    private boolean checkMail(String host) {
        // check if mail received on the host
        return false;
    }
}
