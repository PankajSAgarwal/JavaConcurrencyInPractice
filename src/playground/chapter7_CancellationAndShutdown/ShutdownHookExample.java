package playground.chapter7_CancellationAndShutdown;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ShutdownHookExample {
    private static PrintWriter out1;
    private static PrintWriter out2;

    public static void main(String[] args) throws IOException {
        out1 = new PrintWriter(new FileWriter("test1.txt"),
                false);
        out1.println("This will not be a test1.txt");
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                out2.close();
            }
        });
        out2 = new PrintWriter(
                new FileWriter("test2.txt"),false);
        out2.println("this will be in the test2.txt file");
    }

}
