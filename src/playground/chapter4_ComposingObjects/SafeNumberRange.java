package playground.chapter4_ComposingObjects;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.NotThreadSafe;
import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
public class SafeNumberRange {
    //INVARIANT : LOWER<UPPER

    @GuardedBy("this")
    private int lower,upper;

    public synchronized void setLower(int i){
        //Warning -- unsafe check-then-act
        if(i > upper)
            throw new IllegalArgumentException(
                    "can't set lower to " + i + " > upper"
            );
        lower = i;

    }
    public void setUpper(int i){
        //Warning -- unsafe check-then-act
        if(i < lower)
            throw new IllegalArgumentException(
                    "Can't set upper to " + i + " < lower"
            );
        upper = i;
    }

    public boolean isInRange(int i){
        return i >= lower
                && i <= upper;
    }



}
