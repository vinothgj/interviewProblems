package backtracking;

public class UniquePath3 {
    int hz[] = new int[]{1, 0, 0, -1};
    int vz[] = new int[]{0, 1, -1, 0};
    int n = 0, m = 0, ans = 0;

    public int solve(int[][] A) {
        ans = 0;
        n = A.length;
        m = A[0].length;

        int hd = -1, vd = -1, count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    hd = i;
                    vd = j;
                } else if (A[i][j] == 0) {
                    count++;
                }

            }
        }
        recursion(A, hd, vd, count + 1);
        return ans;
    }

    void recursion(int[][] arr, int x, int y, int cnt) {
        if (arr[x][y] == 2) {
            if (cnt == 0) {
                ans++;
            }
            return;
        }

        if (arr[x][y] != 1 || arr[x][y] != 2) {
            arr[x][y] = -1;
        }
        for (int i = 0; i < 4; i++) {
            int h = x + hz[i];
            int v = y + vz[i];
            if (isVisitable(h, v, arr)) {
                recursion(arr, h, v, cnt - 1);
            }
        }
        if (arr[x][y] != 1 || arr[x][y] != 2) {
            arr[x][y] = 0;
        }
    }

    boolean isVisitable(int h, int v, int[][] arr) {
        return (0 <= h && h < n && 0 <= v && v < m && arr[h][v] != -1);
    }

    public static void main(String arg[]) {
        UniquePath3 uniquePath3 = new UniquePath3();
        int[][] ip = new int[3][4];
        ip[0][0] = 1;
        ip[0][1] = 0;
        ip[0][2] = 0;
        ip[0][3] = 0;

        ip[1][0] = 0;
        ip[1][1] = 0;
        ip[1][2] = 0;
        ip[1][3] = 0;

        ip[2][0] = 0;
        ip[2][1] = 0;
        ip[2][2] = 2;
        ip[2][3] = -1;

        System.out.println(uniquePath3.solve(ip));
    }
}
