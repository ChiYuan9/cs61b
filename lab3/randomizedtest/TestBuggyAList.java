package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    public static void testThreeAddThreeRemove(){
        AListNoResizing<Integer> ANR = new AListNoResizing<Integer>();
        BuggyAList<Integer> BA = new BuggyAList<Integer>();
        ANR.addLast(4);
        BA.addLast(4);
        ANR.addLast(5);
        BA.addLast(5);
        ANR.addLast(6);
        BA.addLast(6);

        assertEquals(ANR.removeLast(),BA.removeLast());
        assertEquals(ANR.removeLast(),BA.removeLast());
        assertEquals(ANR.removeLast(),BA.removeLast());
    }
    public static void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<Integer>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int size1 = B.size();
                assertEquals(size, size1);
            } else if(operationNumber == 2){
                if(L.size() != 0){
                    int lastNum = L.getLast();
                    int lastNum1 = B.getLast();
                    assertEquals(lastNum, lastNum1);
                }
            } else if(operationNumber == 3){
                if(L.size() != 0){
                    L.removeLast();
                    B.removeLast();
                }
            }
        }
    }
    public static void main(String[] args){
        testThreeAddThreeRemove();
        randomizedTest();
    }
}
