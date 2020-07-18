package exercise_1_1;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * TODO: Annotate this class
 * The class should be annotated with either @ThreadSafe, @NotThreadSafe or
 * the @Immutable tag.
 */
@ThreadSafe
public class Person3 {
    private final String firstName;
    private final String surname;
    @GuardedBy("this")
    private int age;

    public Person3(String firstName,
                   String surname, int age) {
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
    }

    public synchronized void birthday() {
        age = age + 1;
    }
}