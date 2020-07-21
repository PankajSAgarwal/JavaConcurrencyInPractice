package playground.chapter3_SharingObjects;

import net.jcip.annotations.GuardedBy;

/**
 * Here there are no check-then-act or read-modify-write, so it is more about visibility then atomicity
 */
public class SynchronizedInteger {
    @GuardedBy("this")
    private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
}
