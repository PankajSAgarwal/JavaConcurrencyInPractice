package exercise_3_2;

import java.util.*;

public abstract class MediaCompany {
    protected void printHeadlines(Collection<Collection<String>> headlines) {
        for (Collection<String> headline : headlines) {
            for (String line : headline) {
                System.out.println(line);
            }
        }
    }
}
