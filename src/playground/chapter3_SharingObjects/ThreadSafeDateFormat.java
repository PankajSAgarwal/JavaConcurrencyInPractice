package playground.chapter3_SharingObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * ThreadLocal is a utility class that aids in enforcing thread confinement
 * ThreadLocal get and set methods associate values to one particular thread instance
 * For e.g DateFormat is not threadsafe
 *
 */
public class ThreadSafeDateFormat {

    private static final ThreadLocal<DateFormat> format =
            new ThreadLocal<DateFormat>() {
                public DateFormat initialValue() {
                    return new SimpleDateFormat("yyyy-MM-dd");
                }
            };
    public static DateFormat getDate(){
        return format.get();
    }
}
