package playground.chapter7_CancellationAndShutdown;

public class Connection {
    private volatile boolean opened = true;// whenver using finalize , use volatile for concurrency
    private static final boolean USE_FINALIZE = false;

    public void close(){
        opened = false;
    }
    protected void finalize() throws Throwable{
        if (USE_FINALIZE) {

            if(opened){
                System.err.println("Still open: " + this);
            }
            super.finalize();
        }

    }


}
