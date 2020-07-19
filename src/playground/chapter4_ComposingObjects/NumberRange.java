package playground.chapter4_ComposingObjects;

import net.jcip.annotations.NotThreadSafe;

import java.util.concurrent.atomic.AtomicInteger;

@NotThreadSafe
public class NumberRange {
    //INVARIANT : LOWER<UPPER

    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public void setLower(int i){
        //Warning -- unsafe check-then-act
        if(i>upper.get())
            throw new IllegalArgumentException(
                    "can't set lower to " + i + " > upper"
            );
        lower.set(i);

    }
    public void setUpper(int i){
        //Warning -- unsafe check-then-act
        if(i < lower.get())
            throw new IllegalArgumentException(
                    "Can't set upper to " + i + " < lower"
            );
        upper.set(i);
    }

    public boolean isInRange(int i){
        return i >= lower.get()
                && i <= upper.get();
    }



}
