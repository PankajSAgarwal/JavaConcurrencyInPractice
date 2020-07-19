package playground.chapter4_ComposingObjects;

import net.jcip.annotations.GuardedBy;
import static apple.laf.JRSUIConstants.*;

/**
 * Lock Confinement
 * Confined locks prevent them from being used incorrectly
 * - Best to make the locks private, unless you wnat client side locking
 * - Lock must always be final - why?
 */
public class PrivateLock {
    private final Object myLock = new Object();
    @GuardedBy("myLock")
    private Widget widget ;

    public void someMethod(){
        synchronized (myLock){
            // Access or modify the state of the widget
        }
    }
}
