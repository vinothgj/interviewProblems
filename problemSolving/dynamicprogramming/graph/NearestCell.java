package dynamicprogramming.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class NearestCell {
    int[][] visited;
    int max;
    int count;

    public static void main(String arg[]) {

        NearestCell nearestCell = new NearestCell();
        int[][] inp = new int[3][4];

        inp[0][0] = 0;
        inp[0][1] = 0;
        inp[0][2] = 0;
        inp[0][3] = 1;

        inp[1][0] = 0;
        inp[1][1] = 0;
        inp[1][2] = 1;
        inp[1][3] = 1;

        inp[2][0] = 0;
        inp[2][1] = 1;
        inp[2][2] = 1;
        inp[2][3] = 0;


        //System.out.println(nearestCell.solve(inp));

        inp = new int[5][2];

        inp[0][0] = 0;
        inp[0][1] = 1;

        inp[1][0] = 1;
        inp[1][1] = 0;

        inp[2][0] = 1;
        inp[2][1] = 1;

        inp[3][0] = 1;
        inp[3][1] = 1;

        inp[4][0] = 0;
        inp[4][1] = 0;

        System.out.println(nearestCell.solve(inp));

    }

    public int[][] solve(int[][] A) {

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
                if (A[i][j] == 1) {
                    queue.add(new Info(i, j));
                    A[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            Info info = queue.poll();
            int idx = info.i, jdx = info.j;
            int indexVal = A[idx][jdx];

            if (idx > 0) {
                if (A[idx - 1][jdx] == 0) {
                    queue.add(new Info(idx - 1, jdx));
                    A[idx - 1][jdx] = applyValInMatrix(A, idx - 1, jdx, indexVal);
                    max = Math.max(max, A[idx - 1][jdx]);
                }
            }
            if (jdx > 0) {
                if (A[idx][jdx - 1] == 0) {
                    queue.add(new Info(idx, jdx - 1));
                    A[idx][jdx - 1] = applyValInMatrix(A, idx, jdx - 1, indexVal);
                    max = Math.max(max, A[idx][jdx - 1]);
                }
            }

            if (idx < n - 1) {
                if (A[idx + 1][jdx] == 0) {
                    queue.add(new Info(idx + 1, jdx));
                    A[idx + 1][jdx] = applyValInMatrix(A, idx + 1, jdx, indexVal);
                    max = Math.max(max, A[idx + 1][jdx]);
                }
            }
            if (jdx < m - 1) {
                if (A[idx][jdx + 1] == 0) {
                    queue.add(new Info(idx, jdx + 1));
                    A[idx][jdx + 1] = applyValInMatrix(A, idx, jdx + 1, indexVal);
                    max = Math.max(max, A[idx][jdx + 1]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == -1) {
                    A[i][j] = 0;
                }
            }
        }

        return A;
    }

    int applyValInMatrix(int[][] src, int ithIdx, int jthIdx, int val) {
        if (val == -1) {
            src[ithIdx][jthIdx] = 1;
        } else if (val > 0) {
            int temp = val + 1;
            if (src[ithIdx][jthIdx] == 0) {
                src[ithIdx][jthIdx] = temp;
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
