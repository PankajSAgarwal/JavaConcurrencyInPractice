package exercise_2_2;

import java.io.*;
import java.util.zip.*;

/**
 * TODO: Fix the concurrency bug
 * Modify this class to allow many threads to call sendMessage() at the same
 * time without any data corruption occuring and for the checksum to still be
 * correct.
 */
public class CheckedSender {
    private final Checksum checksum = new Adler32();

    private final ObjectOutputStream out;
    private static final Object MARKER = new Marker();

    public CheckedSender(OutputStream out) throws IOException {
        this.out = new ObjectOutputStream(
                new CheckedOutputStream(out, checksum));
    }

    // Make the method synchronized to allow only a single thread to enter the method at any one time
    public synchronized void sendMessage(Object msg) throws IOException {
        out.writeObject(MARKER);
        checksum.reset();
        out.writeObject(msg);
        out.writeLong(checksum.getValue());
        out.reset();
        out.flush();
    }
}
