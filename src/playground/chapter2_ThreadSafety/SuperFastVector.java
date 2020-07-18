package playground.chapter2_ThreadSafety;

import java.util.Vector;

/**
 * What's wrong ?
 * overridden get method from Vector class but not synchronized
 */
public class SuperFastVector<E> extends Vector<E> {

    public E get(int index){
        // no up-front index checking - this will be much faster
        E result = (E)elementData[index];
        if (result != null) return result;
        if(index < elementCount)
            throw new ArrayIndexOutOfBoundsException(index);
        return null;
    }
}
