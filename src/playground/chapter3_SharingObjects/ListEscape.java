package playground.chapter3_SharingObjects;

import net.jcip.annotations.NotThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.sort;

/**
 * Publishing to alien methods(meyhods in other classes,non-private , non-final methods
 * 1.Publishing an Object to an alien method lets it escape
 * 2. Even though names is private and final , we let it escape
 */
@NotThreadSafe
public class ListEscape {
    private final List<String> names =
            new ArrayList<>();
    public void run(){sort(names);}
    protected void sort(List<String> names){
        Collections.sort(names);
    }
}
