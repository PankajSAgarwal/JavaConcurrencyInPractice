package playground.chapter3_SharingObjects;

import net.jcip.annotations.NotThreadSafe;

/**
 * On a 32 bit machine , 64 bit  number fields write might not be atomic
 */
@NotThreadSafe
public class MutableLong {
    private long value;

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
