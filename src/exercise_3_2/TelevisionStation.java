package exercise_3_2;

import java.text.*;
import java.util.*;

public class TelevisionStation extends MediaCompany {
    private final static DateFormat dayFormat =
            new SimpleDateFormat("yyyy-MM-dd");

    public Map<String, Collection<String>> headlines =
            new HashMap<>();

    public TelevisionStation() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                if (headlines.size() > 100) {
                    System.out.println("Size of headlines too large: " +
                            headlines.size());
                }
            }
        }, 10_000, 10_000);
    }

    public void showTeleprompter() {
        printHeadlines(headlines.values());
    }

    public void addHeadline(Date date, String line) {
        String day = dayFormat.format(date);
        Collection<String> lines = headlines.get(day);
        if (lines == null) {
            lines = new ArrayList<String>();
        }
        lines.add(line);
    }
}
