package tester;
import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
    @Test
    public void randomTest(){
        StudentArrayDeque<Integer> bugArrayDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> correctArrayDeque = new ArrayDequeSolution<>();
        int N = 5000;
        for (int i = 0;i < N;i++){
            int OpNumber = StdRandom.uniform(0,4);
            int RandomNumber = StdRandom.uniform(0, 100);
            if (OpNumber == 0) {
                bugArrayDeque.addFirst(RandomNumber);
                correctArrayDeque.addFirst(RandomNumber);
                System.out.println("removeFirst(" + RandomNumber + ")");
            }else if (OpNumber == 1){
                bugArrayDeque.addLast(RandomNumber);
                correctArrayDeque.addLast(RandomNumber);
                System.out.println("removeLast(" + RandomNumber + ")");
            }else if (OpNumber == 2){
                if (!bugArrayDeque.isEmpty() && !correctArrayDeque.isEmpty()){
                    Integer a = correctArrayDeque.removeFirst();
                    Integer b = bugArrayDeque.removeFirst();
                    System.out.println("removeFirst()");
                    assertEquals("Oh no!This is fucking bad:\n removeFirst is expected to be " + a + ",but turns out " + b + ".", a, b);
                }
            }else if (OpNumber == 3){
                if (!bugArrayDeque.isEmpty() && !correctArrayDeque.isEmpty()) {
                    Integer a = correctArrayDeque.removeLast();
                    Integer b = bugArrayDeque.removeLast();
                    System.out.println("removeLast()");
                    assertEquals("Oh no!This is fucking bad:\n removeLast is expected to be " + a + ",but turns out " + b + ".", a, b);
                }
            }
        }
    }
}
