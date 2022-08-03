package dynamicprogramming;

public class MaxSumWOAdjacent {
    public static void main(String arg[]) {
        MaxSumWOAdjacent maxSumWOAdjacent = new MaxSumWOAdjacent();
        int[][] a = new int[2][4];
        a[0][0] = 1;
        a[0][1] = 2;
        a[0][2] = 3;
        a[0][3] = 4;

        a[1][0] = 2;
        a[1][1] = 3;
        a[1][2] = 4;
        a[1][3] = 5;

        System.out.println(maxSumWOAdjacent.adjacent(a));

        a = new int[2][4];

        a[0][0] = 14;
        a[0][1] = 87;
        a[0][2] = 36;
        a[0][3] = 23;

        a[1][0] = 37;
        a[1][1] = 59;
        a[1][2] = 21;
        a[1][3] = 68;

        System.out.println(maxSumWOAdjacent.adjacent(a));

    }

    public int adjacent(int[][] A) {
        int n = A.length, m = A[0].length;
        int[] B = new int[m];
        int[] C = new int[m];

        for (int j = 0; j < m; j++) {
            B[j] = Math.max(A[0][j], A[1][j]);
        }
        int temp = 0;
        for (int k = 0; k < m; k++) {
            if (k == 0) {
                C[k] = B[k];
            } else {
                if (k - 2 < 0) {
                    temp = 0;
                } else {
                    temp = C[k - 2];
                }
                C[k] = Math.max(C[k - 1], B[k] + temp);
            }
        }
        return C[m - 1];
    }
}
