package playground.chapter3_SharingObjects;

/**
 * Safe Construction practices
 * 1. Do not allow this reference to escape during construction
 * e.g Executors.newFixedThreadPool() does not actually start the threads immediately,
 * only when the jobs are immediately
 * 2. A simple factory method can prevent this from escaping
 */


/*public class SafeListener implements EventListener {

    private SafeListener() { }

    public void onEvent(Event e) {
        // doSomething(e);
    }

    public static SafeListener make(EventSource source){
        SafeListener safe = new SafeListener();
        source.registerListener(safe);
        return safe;

    }


}*/
