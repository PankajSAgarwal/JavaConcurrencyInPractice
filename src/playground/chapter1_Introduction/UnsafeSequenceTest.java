package playground.chapter1_Introduction;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UnsafeSequenceTest {

    public static void main(String[] args) throws InterruptedException {
       final Map<String, String> uniqueNumbers = new ConcurrentHashMap<>();
       final UnsafeSequence seq = new UnsafeSequence();

       Runnable updater = new Runnable() {
           @Override
           public void run() {
               for (int i = 0; i < 10000; i++) {
                   int next = seq.getNext();// race condition , but program does not show always race condition
                   String str = "value=" + next;
                   uniqueNumbers.put(str,"dummy");
                   System.out.println(str);
               }
           }
       };

       Thread t1 = new Thread(updater,"t1");
       Thread t2 = new Thread(updater,"t2");
       t1.start();
       t2.start();
       t1.join();
       t2.join();
        System.out.println(uniqueNumbers.size());
    }
}
