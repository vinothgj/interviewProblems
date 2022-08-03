package arrays;

public class SubMatrixSumQueries {

    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int sum = 0, q1tl1 = 0, q1tl2 = 0, q1br1 = 0, q1br2 = 0, p = 0;
        int[] res = new int[B.length + 1];

        for (int k = 0; k < B.length; k++) {
            q1tl1 = B[k];
            q1tl2 = C[k];
            q1br1 = D[k];
            q1br2 = E[k];
            sum = 0;

            for (int i = q1tl1 - 1; i < q1br1; i++) {
                for (int j = q1tl2 - 1; j < q1br2; j++) {
                    //System.out.print(A[i][j] + " ");
                    sum = sum + (A[i][j] % 1000000007);
                    sum %= 1000000007;
                }
                //System.out.println();
            }
            res[p++] = sum;
            //p++;
            System.out.println("Answer : " + sum);
            System.out.println();
        }

        return res;
    }

    public static void main(String arg[]) {
        SubMatrixSumQueries subMatrixSumQueries = new SubMatrixSumQueries();

        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] B = {1, 2};
        int[] C = {1, 2};

        int[] D = {2, 3};
        int[] E = {2, 3};

        System.out.println(subMatrixSumQueries.solve(A, B, C, D, E));

        int[][] A1 = {{5, 17, 100, 11}, {0, 0, 2, 8}};
        int[] B1 = {1, 1};
        int[] C1 = {1, 4};

        int[] D1 = {2, 2};
        int[] E1 = {2, 4};

        System.out.println(subMatrixSumQueries.solve(A1, B1, C1, D1, E1));
    }
}

