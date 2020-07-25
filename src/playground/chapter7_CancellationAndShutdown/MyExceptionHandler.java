package playground.chapter7_CancellationAndShutdown;

public class MyExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        StackTraceElement ste = e.getStackTrace()[0];
        System.err.printf("%s: %s at line %d of %s%n",t.getName(),e,ste.getFileName());

    }
}
