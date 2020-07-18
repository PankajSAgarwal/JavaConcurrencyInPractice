package exercise_2_2;

import java.io.*;
import java.net.*;

import static exercise_2_2.Constants.*;

/**
 * DO NOT CHANGE.
 */
public class ChecksumTest {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException, InterruptedException {
        try (ServerSocket ss = new ServerSocket(PORT);
             Socket senderSocket = new Socket("localhost", PORT);
             Socket receiverSocket = ss.accept();) {
            System.out.println("senderSocket = " + senderSocket);
            System.out.println("receiverSocket = " + receiverSocket);

            OutputStream out = senderSocket.getOutputStream();
            InputStream in = receiverSocket.getInputStream();

            final CheckedSender sender = new CheckedSender(out);
            final CheckedReceiver receiver = new CheckedReceiver(in);

            long time = System.currentTimeMillis();

            for (int i = 0; i < SENDER_THREADS; i++) {
                new Thread() {
                    public void run() {
                        for (int i = 0; i < MESSAGES_PER_THREAD; i++) {
                            try {
                                sender.sendMessage("hello " + i);
                            } catch (EOFException e) {
                                // exiting thread
                                return;
                            } catch (IOException e) {
                                System.err.println("Send Error: " + e);
                            }
                        }
                    }
                }.start();
            }

            for (int i = 0; i < SENDER_THREADS * MESSAGES_PER_THREAD; i++) {
                try {
                    receiver.receiveMessage();
                } catch (IOException e) {
                    System.err.println("Receive error: " + e);
                }
            }

            time = System.currentTimeMillis() - time;
            System.out.println("time = " + time);
        }
    }
}
