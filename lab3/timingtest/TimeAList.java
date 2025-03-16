package timingtest;
import afu.org.checkerframework.checker.oigj.qual.O;
import edu.princeton.cs.algs4.Stopwatch;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.Time;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList TimeStore = new AList();
        AList NsStore = new AList();
        AList OpStore = new AList();
        for (int i = 1000;i <= 1e7;i = i * 2){
            AList TestList = new AList();
            Stopwatch sw = new Stopwatch();
            for (int j =0 ; j < i;j++){
                TestList.addLast(100);
            }
            double timeInSeconds = sw.elapsedTime();
            TimeStore.addLast(timeInSeconds);
            NsStore.addLast(i);
            OpStore.addLast(i);
        }
        printTimingTable(NsStore, TimeStore, OpStore);
    }
}
