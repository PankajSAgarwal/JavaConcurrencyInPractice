package playground.chapter4_ComposingObjects;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Composing objects in thread safe manner
 * 1.Identify the fields that form the object's state
 * 2. Identify the invariants that constrain the state field
 * 3. Establish a policy for managing concurrent access to the state
 * - this includes encapsulation and mutability.
 */

@ThreadSafe
public final class Counter {
    //Invariant : value >= 0
    @GuardedBy("this")
    private long value = 0L;

    public synchronized long getValue() {
        return value;
    }
    // PRE CONDITION : value < LONG.MAX_VALUE
    //POST CONDITION : new.value == old.value + 1
    public synchronized long increment(){
        if(value == Long.MAX_VALUE)
            throw new IllegalStateException("overflow");
        long old_value = value;
        long result = ++value;
        assert value == old_value + 1 :"Post condition fail";
        return result;
    }
}
