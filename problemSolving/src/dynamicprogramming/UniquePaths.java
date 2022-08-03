package dynamicprogramming;

public class UniquePaths {

    int dp[][];


    public static void main(String arg[]) {
        UniquePaths uniquePaths = new UniquePaths();
        int[][] inp = new int[3][3];
        inp[0][0] = 0;
        inp[0][1] = 0;
        inp[0][2] = 0;

        inp[1][0] = 1;
        inp[1][1] = 1;
        inp[1][2] = 1;

        inp[2][0] = 0;
        inp[2][1] = 0;
        inp[2][2] = 0;

        System.out.println(uniquePaths.uniquePathsWithObstacles(inp));
    }

    public int uniquePathsWithObstacles(int[][] A) {

        int n = A.length, m = A[0].length;
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return numberOfWays(A, n - 1, m - 1, 0, 0);
    }

    int numberOfWays(int[][] src, int row, int column, int rowIndex, int columnIndex) {
        if (rowIndex > row || columnIndex > column || src[rowIndex][columnIndex] == 1) {
            return 0;
        }
        if (rowIndex == row && columnIndex == column) {
            dp[row][column] = 1;
            return dp[row][column];
        }
        if (dp[rowIndex][columnIndex] != -1) {
            return dp[rowIndex][columnIndex];
        }

        dp[rowIndex][columnIndex] = numberOfWays(src, row, column, rowIndex + 1, columnIndex) + numberOfWays(src, row, column, rowIndex, columnIndex + 1);
        return dp[rowIndex][columnIndex];
    }
}
