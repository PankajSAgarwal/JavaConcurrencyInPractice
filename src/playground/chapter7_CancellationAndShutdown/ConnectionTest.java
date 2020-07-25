package playground.chapter7_CancellationAndShutdown;

/**
 * when USE_FINALIZE=true time(ms) 6252 ms,60% time in GC
 * when USE_FINALIZE=false time(ms) 136 ms,0.34% time in GC
 *
 * Moral : Don't use finalizers
 */
public class ConnectionTest {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10 * 1000 * 1000; i++) {

            Connection con = new Connection();
            if(i % 100000 != 0)
                con.close();
        }
        time = System.currentTimeMillis() - time;
        System.out.println("time = " + time + " ms");
    }
}
