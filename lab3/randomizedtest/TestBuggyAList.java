package randomizedtest;

import org.junit.Test;
import edu.princeton.cs.algs4.StdRandom;
import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */

public class TestBuggyAList {
  // YOUR TESTS HERE
@Test
    public void testThreeAddThreeRemove(){
    AListNoResizing<Integer> TAListNoRes = new AListNoResizing<>();
    BuggyAList<Integer> TBuggyAList = new BuggyAList<>();

    TAListNoRes.addLast(2);
    TAListNoRes.addLast(3);
    TAListNoRes.addLast(4);

    TBuggyAList.addLast(2);
    TBuggyAList.addLast(3);
    TBuggyAList.addLast(4);

    assertEquals(TAListNoRes.size(), TBuggyAList.size());

    assertEquals(TAListNoRes.removeLast(), TBuggyAList.removeLast());
    assertEquals(TAListNoRes.removeLast(), TBuggyAList.removeLast());
    assertEquals(TAListNoRes.removeLast(), TBuggyAList.removeLast());
}
@Test
    public void randomizedTest() {
    AListNoResizing<Integer> L = new AListNoResizing<>();
    BuggyAList<Integer> B = new BuggyAList<>();
    int N = 5000;
    for (int i = 0; i < N; i += 1) {
        int operationNumber = StdRandom.uniform(0, 4);
        if (operationNumber == 0) {
            // addLast（添加到末尾）
            int randVal = StdRandom.uniform(0, 100);
            L.addLast(randVal);
            B.addLast(randVal);
            System.out.println("addLast(" + randVal + ")");
        } else if (operationNumber == 1) {
            // removeLast
            if (L.size() > 0){
                assertEquals(L.removeLast(), B.removeLast());
            }
        }else if (operationNumber == 2) {
            //getLast
            if (L.size() > 0) {
                assertEquals(L.getLast(), B.getLast());
            }
        }
        else if (operationNumber == 3){
            //size
            int size = L.size();
            System.out.println("Size:"+size);

        }
    }
    }
}
