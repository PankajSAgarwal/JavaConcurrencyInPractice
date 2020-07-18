package exercise_1_1;


import net.jcip.annotations.Immutable;

/**
 * TODO: Annotate this class
 * The class should be annotated with either @ThreadSafe, @NotThreadSafe or
 * the @Immutable tag.
 */
@Immutable
public class Person1 {
    private final String firstName;
    private final String surname;
    private final int age;

    public Person1(String firstName,
                   String surname, int age) {
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
    }
}