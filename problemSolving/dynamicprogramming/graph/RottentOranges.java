package dynamicprogramming.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class RottentOranges {
    int[][] visited;
    int max ;
    int count;

    public static void main(String arg[]) {

        RottentOranges rottentOranges = new RottentOranges();
        int[][] inp = new int[3][3];

        inp[0][0] = 2;
        inp[0][1] = 1;
        inp[0][2] = 1;

        inp[1][0] = 1;
        inp[1][1] = 1;
        inp[1][2] = 0;

        inp[2][0] = 0;
        inp[2][1] = 1;
        inp[2][2] = 1;
        System.out.println(rottentOranges.solve(inp));

        inp = new int[5][6];

        inp[0][0] = 0;
        inp[0][1] = 2;
        inp[0][2] = 2;
        inp[0][3] = 2;
        inp[0][4] = 1;
        inp[0][5] = 2;

        inp[1][0] = 2;
        inp[1][1] = 0;
        inp[1][2] = 0;
        inp[1][3] = 0;
        inp[1][4] = 1;
        inp[1][5] = 2;

        inp[2][0] = 1;
        inp[2][1] = 2;
        inp[2][2] = 1;
        inp[2][3] = 2;
        inp[2][4] = 2;
        inp[2][5] = 1;

        inp[3][0] = 0;
        inp[3][1] = 1;
        inp[3][2] = 0;
        inp[3][3] = 1;
        inp[3][4] = 1;
        inp[3][5] = 0;

        inp[4][0] = 0;
        inp[4][1] = 2;
        inp[4][2] = 0;
        inp[4][3] = 1;
        inp[4][4] = 2;
        inp[4][5] = 2;

        System.out.println(rottentOranges.solve(inp));
    }

    public int solve(int[][] A) {
        int n = A.length, m = A[0].length;
        max = Integer.MIN_VALUE;
        count = 0;
        visited = new int[n][m];
        for (int[] arr : visited) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        Queue<Info> queue = new ArrayDeque<Info>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 2) {
                    queue.add(new Info(i, j));
                    A[i][j] = 10;
                } else if (A[i][j] == 1) {
                    count++;
                }
            }
        }

        while (!queue.isEmpty()) {
            Info info = queue.poll();
            int idx = info.i, jdx = info.j;
            int indexVal = A[idx][jdx];
            visited[idx][idx] = 1;

            if (idx > 0) {
                if (A[idx - 1][jdx] == 1) {
                    count--;
                    queue.add(new Info(idx - 1, jdx));
                    A[idx - 1][jdx] = applyValInMatrix(A, idx - 1, jdx, indexVal);
                    max = Math.max(max, A[idx - 1][jdx]);
                }
            }
            if (jdx > 0) {
                if (A[idx][jdx - 1] == 1) {
                    count--;
                    queue.add(new Info(idx, jdx - 1));
                    A[idx][jdx - 1] = applyValInMatrix(A, idx, jdx - 1, indexVal);
                    max = Math.max(max, A[idx][jdx - 1]);
                }
            }

            if (idx < n - 1) {
                if (A[idx + 1][jdx] == 1) {
                    count--;
                    queue.add(new Info(idx + 1, jdx));
                    //visited[idx + 1][jdx] = 1;
                    A[idx + 1][jdx] = applyValInMatrix(A, idx + 1, jdx, indexVal);
                    max = Math.max(max, A[idx + 1][jdx]);
                }
            }
            if (jdx < m - 1) {
                if (A[idx][jdx + 1] == 1) {
                    count--;
                    queue.add(new Info(idx, jdx + 1));
                    A[idx][jdx + 1] = applyValInMatrix(A, idx, jdx + 1, indexVal);
                    max = Math.max(max, A[idx][jdx + 1]);
                }
            }
        }

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    return -1;
                }
            }
        }*/
        if (count > 0) {
            return -1;
        }

        return max - 1;


    }

    int applyValInMatrix(int[][] src, int ithIdx, int jthIdx, int val) {
        if (val == 10) {
            src[ithIdx][jthIdx] = 2;
        } else if (val > 0) {
            int temp = val + 1;
            //src[ithIdx][jthIdx] = Math.min(src[ithIdx][jthIdx], temp);
            if (src[ithIdx][jthIdx] == 1) {
                src[ithIdx][jthIdx] = temp;
            } else {
                src[ithIdx][jthIdx] = Math.min(src[ithIdx][jthIdx], temp);
            }
        }
        return src[ithIdx][jthIdx];
    }

    class Info {
        int i;
        int j;

        Info(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
