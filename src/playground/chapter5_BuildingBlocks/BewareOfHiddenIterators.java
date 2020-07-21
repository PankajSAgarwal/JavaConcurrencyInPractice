package playground.chapter5_BuildingBlocks;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Where is the iterator in the following example and possiblity of ConcurrentModificationExceptions?
 * In System.out.println as it might try to iterate over set while calling toString
 * <code>
 *     String getElement(Map<List,String> map,List list){
 *         String listName = map.get(list)
 *     }
 * </code>
 *
 * - Map.get(key) calls key.hashCode() . For a list ,could be a hash of all underlying elements
 * - Map.get(key) also calls key.equals(), which again,for a List,could iterate all underlying elements
 * - Beware of hidden iterators in toString(),hashCode(),equals(),containsAll(),removeAll(),retainAll(),and any
 * constructors that take a container as a parameter
 */
public class BewareOfHiddenIterators {
    public void addTenThings(){
        Random r = new Random();
        Set set = new HashSet();
        for (int i = 0; i < 10; i++) {

            set.add(r.nextInt());
        }
        System.out.println("DEBUG: add ten elements to " + set);
    }
}
