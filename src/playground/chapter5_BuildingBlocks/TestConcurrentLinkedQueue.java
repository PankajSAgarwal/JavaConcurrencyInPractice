package playground.chapter5_BuildingBlocks;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TestConcurrentLinkedQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new ConcurrentLinkedQueue<>();
        q.add(1);
        q.add(3);

        Iterator<Integer> it = q.iterator();
        q.add(1);
        q.add(4);

        while(it.hasNext()){
            System.out.println(it.next());//1
                                         // 3
                                         //1
                                        //4
        }
        System.out.println(q);//o/p [1, 3, 1, 4]
    }
}
