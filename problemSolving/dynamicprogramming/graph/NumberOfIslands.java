package dynamicprogramming.graph;

public class NumberOfIslands {
    int[][] visit;

    public static void main(String args[]) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        int[][] inp = new int[5][5];

        inp[0][0] = 1;
        inp[0][1] = 1;
        inp[0][2] = 0;
        inp[0][3] = 0;
        inp[0][4] = 0;

        inp[1][0] = 0;
        inp[1][1] = 1;
        inp[1][2] = 0;
        inp[1][3] = 0;
        inp[1][4] = 0;

        inp[2][0] = 1;
        inp[2][1] = 0;
        inp[2][2] = 0;
        inp[2][3] = 1;
        inp[2][4] = 1;

        inp[3][0] = 0;
        inp[3][1] = 0;
        inp[3][2] = 0;
        inp[3][3] = 0;
        inp[3][4] = 0;

        inp[4][0] = 1;
        inp[4][1] = 0;
        inp[4][2] = 1;
        inp[4][3] = 0;
        inp[4][4] = 1;

        System.out.println(numberOfIslands.solve(inp));

        inp = new int[3][3];

        inp[0][0] = 0;
        inp[0][1] = 1;
        inp[0][2] = 0;

        inp[1][0] = 0;
        inp[1][1] = 0;
        inp[1][2] = 1;

        inp[2][0] = 1;
        inp[2][1] = 0;
        inp[2][2] = 0;

        System.out.println(numberOfIslands.solve(inp));

    }

    public int solve(int[][] A) {
        int n = A.length, m = A[0].length;
        visit = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 0 || visit[i][j] == 1) {
                    continue;
                } else {
                    dfs(A, i, j, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(int[][] src, int i, int j, int n, int m) {

        if (i >= 0 && j >= 0 && i <= (n - 1) && j <= (m - 1)) {

            if (src[i][j] == 1 && visit[i][j] == 0) {
                visit[i][j] = 1;
                /*if (i > 0 && j > 0) {
                    dfs(src, i - 1, j - 1, n, m);
                }*/
                if (i > 0) {
                    dfs(src, i - 1, j, n, m);
                    if (j < (m - 1)) {
                        dfs(src, i - 1, j + 1, n, m);
                    }
                }
                if (j > 0) {
                    dfs(src, i, j - 1, n, m);
                    if (i < (n - 1)) {
                        dfs(src, i + 1, j - 1, n, m);
                    }
                }
                if (i >= 0 && j < (m - 1)) {
                    dfs(src, i, j + 1, n, m);
                }

                if (j >= 0 && i < (n - 1)) {
                    dfs(src, i + 1, j, n, m);
                }

                /*if (i < (n - 1) && j < (m - 1)) {
                    dfs(src, i + 1, j + 1, n, m);
                }*/
            } else {
                visit[i][j] = 1;
            }
        }
    }

}
