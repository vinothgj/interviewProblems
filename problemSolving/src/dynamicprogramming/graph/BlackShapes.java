package dynamicprogramming.graph;

public class BlackShapes {
    int[][] visit;

    public int black(String[] A) {
        int n = A.length, m = A[0].length();
        visit = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i].charAt(j) == 0 || visit[i][j] == 1) {
                    continue;
                } else {
                    dfs(A, i, j, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(String[] src, int i, int j, int n, int m) {

        if (i >= 0 && j >= 0 && i <= (n - 1) && j <= (m - 1)) {
            if (src[i].charAt(j) == 1 && visit[i][j] == 0) {
                visit[i][j] = 1;
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
            } else {
                visit[i][j] = 1;
            }
        }
    }
}
