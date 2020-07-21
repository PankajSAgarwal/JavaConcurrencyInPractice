package playground.chapter5_BuildingBlocks;

import java.util.Vector;

/**
 * What's wrong?
 * Even though Vector is a synchronized container , compound operations still needs to be locked to guarantee thread safety
 * Possibility if ArrayIndexOutOfBound exception if interleaving happens between thread A(accessing getLast)  and thread B(accessing deleteLast)
 * Synchronized containers lock on the intrinsic lock
 */
public class SynchronizedContainerProblems {
    public static Object getLast(Vector list){
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }
    public static void deleteLast(Vector list){
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }
}
