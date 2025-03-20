package deque;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static java.util.Collections.max;
import static org.junit.Assert.*;
import java.util.Comparator;

public class MaxArrayDequeTest {
    private MaxArrayDeque<Integer> TestArrayDeque;

    @Test
    /**Just test method max().*/
    public void FindtheMaxElement(){
        Comparator<Integer> intComparator = Integer::compare;
        java.util.ArrayDeque<Integer> StandardArrayDeque = new java.util.ArrayDeque<Integer>();
        TestArrayDeque = new MaxArrayDeque<>(intComparator);
        int N = 500;
        for (int i = 0;i < 500;i++){
            int randomInt = StdRandom.uniform(0,100);
            StandardArrayDeque.addFirst(randomInt);
            TestArrayDeque.addFirst(randomInt);
        }
        assertEquals(max(StandardArrayDeque), TestArrayDeque.max());
    }
}
