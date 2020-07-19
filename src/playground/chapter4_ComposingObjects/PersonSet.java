package playground.chapter4_ComposingObjects;


import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Set;

/**
 * Example of Instance confinement Ensuring thread safety
 */
@ThreadSafe
public class PersonSet {
    @GuardedBy("this")
    private final Set<Person> mySet = new HashSet<>();//HashSet is not thread safe

    public synchronized void add(Person p){
        mySet.add(p);
    }
    public synchronized boolean contains(Person p){
        return mySet.contains(p);
    }
}
