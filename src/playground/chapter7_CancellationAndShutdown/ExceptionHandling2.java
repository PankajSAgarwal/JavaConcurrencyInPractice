package playground.chapter7_CancellationAndShutdown;

/**
 * To set the handler for a single thread we call the setUncaughtExceptionHandler() method
 * Use setDefaultUncaughtExceptionHandler() method to set handler for all threads
 *
 */
public class ExceptionHandling2 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            public void run(){
                throw new RuntimeException();
            }
        };

        t.setUncaughtExceptionHandler(new MyExceptionHandler());
        t.start();
    }
}
