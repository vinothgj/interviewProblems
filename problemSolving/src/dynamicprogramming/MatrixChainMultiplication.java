package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixChainMultiplication {
    int dpMatrix[][];

    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        dpMatrix = new int[n][n];

        for (int[] dp : dpMatrix) {
            Arrays.fill(dp, -1);
        }

        return calculateMinProduct(A, 0, n - 1);
    }

    public int solve(int[] A) {

        int n = A.length;
        int[][] dp = new int[n][n];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        return findMin(A, 0, n - 1, dp);
    }

    int calculateMinProduct(ArrayList<Integer> a, int left, int right) {
        if (right - left <= 1)
            return 0;
        if (dpMatrix[left][right] != -1) {
            return dpMatrix[left][right];
        }

        int ans = Integer.MAX_VALUE;

        for (int k = left + 1; k < right; k++) {
            ans = Math.min(ans, calculateMinProduct(a, left, k) + calculateMinProduct(a, k, right) + (a.get(left) * a.get(k) * a.get(right)));
        }
        return dpMatrix[left][right] = ans;
    }

    int findMin(int[] A, int start, int end, int[][] dp) {
        if (end - start <= 1)
            return 0;

        if (dp[start][end] != -1)
            return dp[start][end];

        int ans = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i++) {
            ans = Math.min(ans, findMin(A, start, i, dp) + findMin(A, i, end, dp) + A[start] * A[i] * A[end]);
        }
        return dp[start][end] = ans;
    }

    public static void main(String[] arg) {
        MatrixChainMultiplication matrixChainMultiplication = new MatrixChainMultiplication();
        ArrayList<Integer> input = new ArrayList<>();
        input.addAll(Arrays.asList(40, 20, 30, 10, 30));
        System.out.println(matrixChainMultiplication.solve(input));
        System.out.println(matrixChainMultiplication.solve(new int[]{40, 20, 30, 10, 30}));
    }
}
