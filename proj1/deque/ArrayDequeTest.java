package deque;
import edu.princeton.cs.algs4.StdRandom;
import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void randomArrayDequeTest(){
        ArrayDeque<Integer> ArrayDequeT = new ArrayDeque<>();
        java.util.ArrayDeque<Integer> ArrayDequeC = new java.util.ArrayDeque<>();
        int N = 5000;
        for (int i = 0;i < N;i++){
            int MagicNumber = StdRandom.uniform(0,4);
            if (MagicNumber == 0){
                //ADDFIRST
                int randomInt = StdRandom.uniform(0,100);
                ArrayDequeT.addFirst(randomInt);
                ArrayDequeC.addFirst(randomInt);
                System.out.println("addFirst（" + randomInt + ")");
            }else if (MagicNumber == 1){
                //REMOVEFIRST
                if (ArrayDequeC.isEmpty() || ArrayDequeT.isEmpty()){
                    continue;
                }
                int T = ArrayDequeT.removeFirst();
                int C = ArrayDequeC.removeFirst();
                assertEquals(T, C);
                System.out.println("removeFirst(" + C + ")");
            }else if (MagicNumber == 2){
                //SIZE
                assertEquals(ArrayDequeT.size(), ArrayDequeC.size());
            }else if (MagicNumber == 3){
                //ADDLAST
                int randomInt = StdRandom.uniform(0,100);
                ArrayDequeT.addLast(randomInt);
                ArrayDequeC.addLast(randomInt);
                System.out.println("addLast（" + randomInt + ")");
            }

        }
    }
}
