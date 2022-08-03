package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubArraySum {
    public int solve(ArrayList<Integer> A) {
        long prefixSum = 0;
        Set<Long> mapper = new HashSet<Long>();

        int i = 0;
        while (i < A.size()) {
            int val = A.get(i);
            prefixSum += val;

            if (prefixSum == 0) {
                return 1;
            }
            if (mapper.contains(prefixSum)) {
                return 1;
            }
            mapper.add(prefixSum);
            i++;
        }
        return 0;
    }

    public static void main(String args[]) {
        SubArraySum subArraySum = new SubArraySum();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.addAll(Arrays.asList(88, 2, 46, 66, 89, -79, 36, 72, 30, 60, 89, 23, 60, 26, -43, -14, 20, 92, -48, 45, 84, -22, 65, -57, 7));
        System.out.println(subArraySum.solve(arrayList));
    }
}
