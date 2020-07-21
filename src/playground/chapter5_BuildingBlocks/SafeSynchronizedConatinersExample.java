package playground.chapter5_BuildingBlocks;

import java.util.Vector;

/**
 * Methods getLast() and getDelete() are mutually exclusive
 * - Only one thread at a time can call either of them
 * - No more exceptions
 */
public class SafeSynchronizedConatinersExample {

    public static Object getLast(Vector list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            return list.get(lastIndex);
        }
    }

    public static void deleteLast(Vector list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            list.remove(lastIndex);
        }
    }
}
