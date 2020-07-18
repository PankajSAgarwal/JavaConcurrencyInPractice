package playground.chapter1_Introduction;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {

    private int value;

    public int getNext(){
        return value++;// should return unique int
    }
}
