package playground.chapter5_BuildingBlocks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

/**
 * The add() and remove() methods do not need to be synchronized since we are using Semaphore to control the locking.
 *
 */
public class BoundHashSet<T>  {
    private final Map<T,Object> map = new ConcurrentHashMap<>();
    private final Semaphore semaphore;

    private static final Object PRESENT = new Object();

    public BoundHashSet(int bound) {
        this.semaphore = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException{
        semaphore.acquire();
        boolean wasAdded = map.put(o,PRESENT)== null;
        if(!wasAdded)
            semaphore.release();
        return wasAdded;
    }

    public boolean remove(Object o){
        boolean wasRemoved = map.remove(o) == PRESENT;
        if(wasRemoved)
            semaphore.release();// Releasing the permit again if nothing was added
        return wasRemoved;
    }
}
