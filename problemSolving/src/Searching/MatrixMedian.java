package Searching;

public class MatrixMedian {
    public int findMedian(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int desireCount = (1 + (m * n)) / 2;

        int k = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(A[i][k], min);
        }
        k = m - 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(A[i][k], max);
        }

        int low = min, high = max;

        while (low <= high) {
            int mid = (low + high) / 2;
            int counter = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (A[i][j] <= mid) {
                        counter++;
                    }
                }
            }

            if (counter < desireCount) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;

    }

    public static void main(String args[]) {
        MatrixMedian matrixMedian = new MatrixMedian();
        /*int[][] inp = new int[3][3];
        inp[0][0] = 1;
        inp[0][1] = 3;
        inp[0][2] = 5;

        inp[1][0] = 2;
        inp[1][1] = 6;
        inp[1][2] = 9;

        inp[2][0] = 3;
        inp[2][1] = 6;
        inp[2][2] = 9;*/
        int[][] inp = new int[1][3];
        inp[0][0] = 5;
        inp[0][1] = 17;
        inp[0][2] = 100;
        System.out.println(matrixMedian.findMedian(inp));
    }
}
