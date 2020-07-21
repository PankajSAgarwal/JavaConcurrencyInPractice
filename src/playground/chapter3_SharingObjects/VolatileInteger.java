package playground.chapter3_SharingObjects;

/**
 * 1. This class is thread safe with good performance  as long as we can guarantee
 * increment() is only ever called from a single thread
 * 2. But it is difficult to guarnatee , so AtomicInteger is safer
 */
public class VolatileInteger {
    private volatile int value;
    public int get(){
        return value;
    }
    public void increment(){
        value++;
    }
}
