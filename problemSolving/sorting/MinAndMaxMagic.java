package sorting;

import java.util.Arrays;

public class MinAndMaxMagic {

    public int[] solve(int[] A) {

        Arrays.sort(A);
        int n = A.length;

        int minValue = 0, maxValue = 0;
        for (int i = 0; i < n; i = i + 2) {
            minValue = minValue + Math.abs(A[i] - A[i + 1]);
        }

        for (int i = 0; i < (n / 2); i++) {
            maxValue = maxValue + Math.abs(A[i] - A[n - 1 - i]);
        }

        //System.out.println("Max Value: " + maxValue + " Min Value:" + minValue);
        return new int[]{maxValue, minValue};

    }

    public static void main(String args[]) {
        MinAndMaxMagic minAndMaxMagic = new MinAndMaxMagic();
        System.out.println(minAndMaxMagic.solve(new int[]{3, 11, -1, 5}));

    }

}
