package exercise_2_2b;

import java.io.*;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

/**
 * TODO: Fix the concurrency bug
 * Modify this class to allow many threads to call receiveMessage() at the same
 * time without any data corruption occuring.
 */
public class CheckedReceiver {
    private final DataInputStream in;


    public CheckedReceiver(InputStream in) throws IOException {
        this.in = new DataInputStream(in);
    }

    public Object receiveMessage() throws IOException, ClassNotFoundException {
        byte[] data;
        synchronized (this) {
            int length = in.readInt();
            data = new byte[length];
            int readData = 0;
            while (readData != length) {
                int readResult = in.read(data, readData, length - readData);
                if (readResult == -1) throw new EOFException();
                readData += readResult;

            }
        }
        Checksum checkSum = new Adler32();
        try (

                ByteArrayInputStream baos = new ByteArrayInputStream(data);
                ObjectInputStream oin = new ObjectInputStream(
                        new CheckedInputStream(baos, checkSum)
                );

        ) {
            Object msg = oin.readUnshared();
            long streamCheckSum = checkSum.getValue();
            long check = oin.readLong();
            if (check != streamCheckSum)
                throw new StreamCorruptedException("Checksum comparison failed");
            return msg;
        }


    }
}