package playground.chapter4_ComposingObjects;

import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * We lock on correct object
 * A common mistake with client-side locking or external locking is to lock on wrong object!
 * - Client side locking is very fragile
 * The below class is thread safe because locking is done on the same object in addIfAbsent as well as the list
 */
@ThreadSafe
public class ListHelper2<E> {
    private final List<E> list =
            Collections.synchronizedList(new ArrayList<>());

    public boolean addIfAbsent(E x){
        synchronized (list){
            if(list.contains(x)) return false;
            return list.add(x);
        }
    }

}
