package playground.chapter4_ComposingObjects;

import net.jcip.annotations.NotThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Why not thread safe ?
 * list and addIfAbsent are synchronized on different object
 * list has synchronization via synchronizedList
 * addIfAbsent is synchronized on ListHelper class
 *
 */
@NotThreadSafe
public class ListHelper<E> {
    private final List<E> list =
            Collections.synchronizedList(new ArrayList<>());

    //POST CONDITION : list contains only one x

    public synchronized boolean addIfAbsent(E x){
        if(list.contains(x)) return false;
        return list.add(x);
    }
}
