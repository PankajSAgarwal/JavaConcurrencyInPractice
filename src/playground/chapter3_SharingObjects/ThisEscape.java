package playground.chapter3_SharingObjects;
/**
 * Implicit link to outer classes
 * Non-static inner classes have a pointerto the outer class
 * The anonymous inner class EventListener is given a pointer to ThisEscape Object.
 */
/*@NotThreadSafe
public class ThisEscape {
    public ThisEscape(EventSource source) {
        source.registerListener(
                new EventListener(){
                    public void onEvent(Event e){
                        doSomething(e);
                    }
                });
    }
}*/
