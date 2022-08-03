package bitmanipulation;

import java.util.Arrays;

public class MinimunDifference {

    public int findMinXor(int[] A) {
        Arrays.sort(A);
        int minValue = Integer.MAX_VALUE;
        int xor = 0;

        for (int i = 0; i < A.length - 1; i++) {
            System.out.println("A @ " + i + " " + A[i]);
            xor = A[i] ^ A[i + 1];
            System.out.println("Xor " + xor);
            minValue = Math.min(minValue, xor);
            System.out.println("Min Value " + minValue);
        }

        return minValue;
    }

    public static void main(String args[]) {
        MinimunDifference minimunDifference = new MinimunDifference();
        //identify2Elements.solve(new int[] {1, 2, 3, 1, 2, 4});
        minimunDifference.findMinXor(new int[]{12, 4, 6, 2});
    }

}
