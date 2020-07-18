package exercise_1_1;

import net.jcip.annotations.*;
import org.junit.*;

import java.lang.reflect.*;

import static util.TestHelpers.*;
import static org.junit.Assert.*;

/**
 * DO NOT CHANGE.
 */
public class PersonTest {
    @Test
    public void testPerson1() {
        assertTypeIsAnnotated(Immutable.class, Person1.class);
    }

    @Test
    public void testPerson2() {
        assertTypeIsAnnotated(NotThreadSafe.class, Person2.class);
    }

    @Test
    public void testPerson3() throws NoSuchFieldException {
        assertTypeIsAnnotated(ThreadSafe.class, Person3.class);
        Field field = Person3.class.getDeclaredField("age");
        GuardedBy guardedBy = field.getAnnotation(GuardedBy.class);
        assertNotNull(field + " not annotated with @GuardedBy", guardedBy);
        assertEquals(field + " not annotated with @GuardedBy(\"this\")",
                "this", guardedBy.value());
    }

    public static void main(String[] args) {
        util.UnitTestRunner.run();
    }
}
