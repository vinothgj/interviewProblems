public class LakeWaterFlow {

    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int solve(int[][] A) {

        int sum = 0;
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int row = A.length, col = A[0].length;
        boolean[][] lakeA = new boolean[row][col];
        boolean[][] lakeB = new boolean[row][col];

        // call path identification
        for (int i = 0; i < row; i++) {
            identifyPath(A, 0, i, Integer.MIN_VALUE, lakeA);
            identifyPath(A, row - 1, i, Integer.MIN_VALUE, lakeB);
        }

        for (int i = 0; i < col; i++) {
            identifyPath(A, i, 0, Integer.MIN_VALUE, lakeA);
            identifyPath(A, i, col - 1, Integer.MIN_VALUE, lakeB);
        }

        // Final result
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (lakeA[i][j] && lakeB[i][j]) {
                    sum = sum + 1;
                }
            }
        }
        return sum;
    }

    public void identifyPath(int[][] src, int i, int j, int prev, boolean[][] lake) {
        if (i < 0 || (i > lake.length - 1) || j < 0 || j > (lake[0].length - 1)) {
            return;
        }

        if ((src[i][j] < prev) || (lake[i][j])) {
            return;
        }

        lake[i][j] = true;

        for (int[] move : direction) {
            identifyPath(src, i + move[0], j + move[1], src[i][j], lake);
        }

    }


    public static void main(String args[]) {

        //int A[][] = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        //int A[][] = {{2,2},{2,2}};

        int A[][] = {{15, 1, 10}, {5, 19, 19}, {3, 5, 6}, {6, 2, 8},
                {2, 12, 16}, {3, 8, 17}, {12, 5, 3}, {14, 13, 3}, {2, 17, 19},
                {16, 8, 7}, {12, 19, 10}, {13, 8, 20}};

        LakeWaterFlow lakeWaterFlow = new LakeWaterFlow();
        System.out.println(lakeWaterFlow.solve(A));

    }

}

