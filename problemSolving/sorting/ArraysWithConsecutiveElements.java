package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArraysWithConsecutiveElements {

    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        boolean repeat = false;
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) == A.get(i + 1)) {
                repeat = true;
                break;
            }
        }
        if (((A.get(0) + A.size()) == ((A.get(A.size() - 1)) + 1)) && !repeat) {
            return 1;
        }
        return 0;
    }

    public static void main(String args[]) {
        ArraysWithConsecutiveElements arraysWithConsecutiveElements = new ArraysWithConsecutiveElements();
        System.out.println(arraysWithConsecutiveElements.solve(new ArrayList<Integer>(Arrays.asList(3, 2, 1, 4, 5))));
        System.out.println(arraysWithConsecutiveElements.solve(new ArrayList<Integer>(Arrays.asList(1, 5, 1, 4, 5))));
    }
}
