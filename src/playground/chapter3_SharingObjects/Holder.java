package playground.chapter3_SharingObjects;

import net.jcip.annotations.NotThreadSafe;

/**
 * Improper Publication : When Good objects go Bad
 * Since " published" was not synchronized , two things can go wrong
 * a. Other threads might see stale value for "holder" itself(null or a previous value)
 * b. Or worse - other threads could see stale values for the state ( fields) in "published"
 */
@NotThreadSafe
public class Holder {
    private int n;

    public Holder(int n) {
        this.n = n;
    }
    public void assertSanity(){
        if(n != n ){
            throw new AssertionError("This statement is false");
        }
    }

}
