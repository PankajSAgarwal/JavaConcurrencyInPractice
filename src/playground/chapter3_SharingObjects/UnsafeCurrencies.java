package playground.chapter3_SharingObjects;

import net.jcip.annotations.NotThreadSafe;

/**
 * Publishing an Object via Return from  Method
 * 1. Arrays are always mutable
 * 2. At the very least return currencies.clone()
 * 3. Contents of array can never be made volatile
 */
@NotThreadSafe
public class UnsafeCurrencies {
    private final String[] currencies =
            {"USD","EUR","GBP","CHF"};

    public String[] getCurrencies(){
        return currencies;// return currencies.clone() better but contents may still not be always visible
    }

}
