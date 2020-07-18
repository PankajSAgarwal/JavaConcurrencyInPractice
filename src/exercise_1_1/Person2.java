package exercise_1_1;

import net.jcip.annotations.NotThreadSafe;

/**
 * TODO: Annotate this class
 * The class should be annotated with either @ThreadSafe, @NotThreadSafe or
 * the @Immutable tag.
 */
@NotThreadSafe
public class Person2 {
    private final String firstName;
    private final String surname;
    private int age;

    public Person2(String firstName,
                   String surname, int age) {
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
    }

    public void birthday() {
        age = age + 1;
    }
}
