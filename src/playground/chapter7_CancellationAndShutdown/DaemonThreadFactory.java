package playground.chapter7_CancellationAndShutdown;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory implements ThreadFactory {

    private final ThreadFactory defaultFactory =
            Executors.defaultThreadFactory();
    public Thread newThread(Runnable r){
        Thread t = defaultFactory.newThread(r);
        t.setName(t.getName() + "-daemon");
        t.setDaemon(true);
        return t;
    }

    public static void main(String[] args) {
        ExecutorService executors =
                Executors.newCachedThreadPool(new DaemonThreadFactory());

    }
}
