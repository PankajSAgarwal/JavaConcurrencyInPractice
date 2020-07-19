package playground.chapter4_ComposingObjects;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Set;

/**
 * State guarded by final private field
 * We can choose any locking strategy to make PersonSet thread-safe
 * In PersonSet class we are locking on "this"
 * But below locking strategy is also perfectly valid
 */
@ThreadSafe
public class PersonSetWithExplicitLock {
    @GuardedBy("mySet")
    private final Set<Person> mySet = new HashSet<>();

    public void add(Person p){
        synchronized (mySet){
            mySet.add(p);
        }
    }
}
