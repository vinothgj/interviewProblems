package dynamicprogramming;

public class DungeonPrincess {
    public static void main(String arg[]) {
        DungeonPrincess dungeonPrincess = new DungeonPrincess();
        int[][] input = new int[3][3];
        input[0][0] = -2;
        input[0][1] = -3;
        input[0][2] = 3;

        input[1][0] = -5;
        input[1][1] = -10;
        input[1][2] = 1;

        input[2][0] = 10;
        input[2][1] = 30;
        input[2][2] = -5;

        System.out.println(dungeonPrincess.calculateMinimumHP(input));
    }

    public int calculateMinimumHP(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int[][] ans = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            if (i == n - 1 || i == m - 1) {
                ans[i][m] = 1;
                ans[n][i] = 1;
            } else {
                ans[i][m] = Integer.MAX_VALUE;
                ans[n][i] = Integer.MAX_VALUE;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int res = Math.min(ans[i + 1][j], ans[i][j + 1]) - A[i][j];
                ans[i][j] = Math.max(1, res);
            }
        }

        return ans[0][0];

    }
}
