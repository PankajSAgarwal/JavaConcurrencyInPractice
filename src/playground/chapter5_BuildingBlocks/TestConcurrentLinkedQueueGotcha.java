package playground.chapter5_BuildingBlocks;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TestConcurrentLinkedQueueGotcha {
    public static void main(String[] args) {
        Queue<Integer> q = new ConcurrentLinkedQueue<>();
        Iterator<Integer> it = q.iterator();
        q.add(1);
        q.add(4);

        while (it.hasNext()){
            // We dont get any output here
            //because Iterators pointing to an empty queue will not show new elements
            // that are added after the iterator was constructed .
            System.out.println(it.next());
        }
        System.out.println(q);// this prints [1,4]
    }
}
