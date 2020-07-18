package util;

import sun.misc.*;

import java.lang.reflect.*;

/**
 * DO NOT CHANGE.  In fact, DO NOT USE.  You never saw this class.  Just move
 * along now please.  Some men in black will now take a group photo.
 */
public class UnsafeProvider {
    public static Unsafe getUnsafe() {
        try {
            for (Field field : Unsafe.class.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers())) {
                    if (field.getType() == Unsafe.class) {
                        field.setAccessible(true);
                        return (Unsafe) field.get(null);
                    }
                }
            }
            throw new IllegalStateException("Unsafe field not found");
        } catch (Exception e) {
            throw new IllegalStateException(
                    "Could not initialize unsafe", e);
        }
    }
}
