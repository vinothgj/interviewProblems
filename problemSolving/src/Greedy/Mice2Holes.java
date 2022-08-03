package Greedy;

import java.util.Arrays;

public class Mice2Holes {
    public int mice(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            ans = Math.max(Math.abs(A[i] - B[i]), ans);
        }
        return ans;
    }
}
