package playground.chapter3_SharingObjects;
import net.jcip.annotations.Immutable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Imuutable class with mutable member
 * 1. This class is immutable even though its Set member is mutable
 * - Its Set member is final
 * - The "this" reference does not escape during construction
 * - It does not provide any means to modify its state after construction
 */
@Immutable
public class ThreeStooges {
    private final Set<String> stooges = new HashSet<>();

    public ThreeStooges() {
        Collections.addAll(stooges,"Moe","Larry","Curly");
    }

    public boolean isStooge(String name){
        return stooges.contains(name);
    }
}
