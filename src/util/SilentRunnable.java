package util;

/**
 * DO NOT CHANGE.
 */
public abstract class SilentRunnable implements Runnable {
    public void run() {
        try {
            execute();
        } catch (Exception e) {
            if (e instanceof RuntimeException) throw (RuntimeException) e;
            throw new IllegalStateException(e); // oh WHY does Java have checked exceptions?
        }
    }

    public abstract void execute() throws Exception;
}
