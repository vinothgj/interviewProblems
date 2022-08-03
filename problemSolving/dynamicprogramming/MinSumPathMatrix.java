package dynamicprogramming;

import java.util.Arrays;

public class MinSumPathMatrix {
    int[][] dp;

    public static void main(String arg[]) {
        MinSumPathMatrix minSumPathMatrix = new MinSumPathMatrix();
        int[][] inp = new int[3][3];

        inp[0][0] = 1;
        inp[0][1] = 3;
        inp[0][2] = 2;

        inp[1][0] = 4;
        inp[1][1] = 3;
        inp[1][2] = 1;

        inp[2][0] = 5;
        inp[2][1] = 6;
        inp[2][2] = 1;

        System.out.println(minSumPathMatrix.minPathSum(inp));
    }

    public int minPathSum(int[][] A) {
        int n = A.length, m = A[0].length;
        dp = new int[n + 1][m + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        findPath(A, n - 1, m - 1, n, m);
        return dp[0][0];
    }

    void findPath(int[][] matrix, int rowIndex, int columnIndex, int row, int column) {
        for (int i = rowIndex; i >= 0; i--) {
            for (int j = columnIndex; j >= 0; j--) {
                if (i == row - 1 && j == column - 1) {
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
    }
}

