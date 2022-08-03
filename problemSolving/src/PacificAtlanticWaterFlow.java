public class PacificAtlanticWaterFlow {

    int[][] heights;
    int M;
    int N;

    public int solve(int[][] A) {
        this.heights = A;
        int ans = 0;

        // identifyPath First row and first col
        this.M = A.length;
        this.N = A[0].length;
        boolean[][] lakeA = new boolean[M][N];
        traceRow(0, lakeA);
        traceColumn(0, lakeA);

        // identifyPath Last Row and last col
        boolean[][] lakeB = new boolean[M][N];
        traceRow(M - 1, lakeB);
        traceColumn(N - 1, lakeB);

        // add coordinates that are both visited from two tables to the res list
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (lakeB[i][j] == true && lakeA[i][j] == true) {
                    ans++;
                }
            }
        }
        // return the res list
        return ans;
    }

    private void identifyPath(int row, int col, boolean[][] visited) {
        visited[row][col] = true;

        int curCellVal = heights[row][col];

        // Top
        if (0 <= row - 1 && heights[row - 1][col] >= curCellVal && visited[row - 1][col] == false) {
            identifyPath(row - 1, col, visited);
        }
        // Left
        if (0 <= col - 1 && heights[row][col - 1] >= curCellVal && visited[row][col - 1] == false) {
            identifyPath(row, col - 1, visited);
        }
        // Right
        if (col + 1 < N && heights[row][col + 1] >= curCellVal && visited[row][col + 1] == false) {
            identifyPath(row, col + 1, visited);
        }
        // Down
        if (row + 1 < M && heights[row + 1][col] >= curCellVal && visited[row + 1][col] == false) {
            identifyPath(row + 1, col, visited);
        }
    }

    private void traceRow(int row, boolean[][] visited) {
        int totalCols = N;
        for (int i = 0; i < totalCols; i++) {
            int col = i;
            identifyPath(row, col, visited);
        }
    }

    private void traceColumn(int col, boolean[][] visited) {
        int totalRows = M;
        for (int i = 0; i < totalRows; i++) {
            int row = i;
            identifyPath(row, col, visited);
        }
    }

    public static void main(String args[]) {

        //int A[][] = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        //int A[][] = {{2,2},{2,2}};

        int A[][] = {{15, 1, 10}, {5, 19, 19}, {3, 5, 6}, {6, 2, 8},
                {2, 12, 16}, {3, 8, 17}, {12, 5, 3}, {14, 13, 3}, {2, 17, 19},
                {16, 8, 7}, {12, 19, 10}, {13, 8, 20}};

        PacificAtlanticWaterFlow lakeWaterFlow = new PacificAtlanticWaterFlow();
        System.out.println(lakeWaterFlow.solve(A));

    }
}
