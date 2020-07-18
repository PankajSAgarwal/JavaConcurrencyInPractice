package playground.chapter1_Introduction;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Sequence {
    @GuardedBy("this")
    private int value;

    public synchronized int getNext(){
        return value++;
    }
}
