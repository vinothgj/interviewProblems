package twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumContinousSeries {

    ArrayList<Integer> series = null;
    int start = 0;
    int end = 0;

    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        ArrayList<Integer> inp = new ArrayList<Integer>();
        series = new ArrayList<Integer>();
        identifyMaxOnes(A, B, 0, 1);
        for (int j = start; j <= end; j++) {
            series.add(j);
        }
        return series;
    }

    // A   :  1 1 0 1 1 0 0 1 1 1
    // PS  :  1 2 2 3 4 4 4 5 6 7
    // MS  :  10 9 9 8 7 7 7 6 5 4
    // PS1 :  7 6 5 5 4 3 3 3 2 1
    // A  :  1, 0, 0, 0, 1, 0, 1
    // PS :  1, 1, 1, 1, 2, 2, 3
    // MS :  7, 7, 7, 7, 6, 6, 5
    // A   : 1, 0, 0, 0, 1, 1, 1, 0
    // PS  : 8, 8, 8, 8, 7, 6, 5, 5
    void identifyMaxOnes(ArrayList<Integer> src, int operation, int low, int high) {
        while (high < src.size()) {

            if (operation == 0) {
                low++;
                while (src.get(low) > 0) {
                    low++;
                }

                operation++;
            }

            if (src.get(low) == src.get(high)) {
                low++;
                high++;
            } else if (src.get(low) < src.get(high)) {
                if (src.get(high) == src.get(high - 1)) {
                    if (operation > 0) {
                        operation = operation - 1;
                        start = low;
                        end = high;
                    } else {
                        start = low;
                        end = high - 1;
                        break;
                    }

                }
                high++;
            }
        }

        if (high == src.size()) {
            end = end + operation;
        }
    }

    public static void main(String args[]) {
        MaximumContinousSeries maximumContinousSeries = new MaximumContinousSeries();
        ArrayList<Integer> inp = new ArrayList<Integer>();
        inp.addAll(Arrays.asList(1, 1, 0, 1, 1, 0, 0, 1, 1, 1));
        System.out.println(maximumContinousSeries.maxone(inp, 2));

       /* inp = new ArrayList<Integer>();
        inp.addAll(Arrays.asList(1, 0, 0, 0, 1, 0, 1));
        System.out.println(maximumContinousSeries.maxone(inp, 2));*/
    }
}
