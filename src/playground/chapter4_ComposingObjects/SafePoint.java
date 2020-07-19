package playground.chapter4_ComposingObjects;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class SafePoint {
    @GuardedBy("this")
    private int x,y;

    public SafePoint(SafePoint p){
        this(p.get());
    }

    private SafePoint(int[] a){
        this(a[0],a[1]);
    }

    public SafePoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public synchronized int[] get() {
        return new int[]{x,y};
    }

    public synchronized void set(int x,int y){
        this.x = x;
        this.y = y;
    }
}
