package playground.chapter4_ComposingObjects;

import net.jcip.annotations.ThreadSafe;

import java.util.Vector;

@ThreadSafe
public class BetterVector<E> extends Vector<E> {

    public synchronized boolean addIfAbsent(E x){
        if(contains(x)) return false;
        return add(x);
    }
}
