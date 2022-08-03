package Searching;

public class MatrixSearch {
    public int searchMatrix(int[][] A, int B) {
        int n = A.length, m = A[0].length;
        int high = m - 1, low = 0;

        if (n == 1 && m == 1) {
            if (A[0][0] == B) {
                return 1;
            } else {
                return 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if (A[i][m - 1] == B) {
                return 1;
            } else if (A[i][m - 1] > B) {
                low = 0;
                high = m - 1;
                return searchValue(A, B, low, high, i);
            }
        }
        return 0;
    }

    int searchValue(int[][] A, int B, int low, int high, int row) {
        int mid = 0;
        while (low <= high) {
            int inter = high + low;
            mid = inter / 2;
            if (A[row][mid] == B) {
                return 1;
            } else if (A[row][mid] < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        MatrixSearch matrixSearch = new MatrixSearch();
        int[][] inp = new int[10][9];
        inp[0][0] = 1;
        inp[1][0] = 9;
        inp[2][0] = 23;
        inp[3][0] = 38;
        inp[4][0] = 45;
        inp[5][0] = 51;
        inp[6][0] = 60;
        inp[7][0] = 67;
        inp[8][0] = 74;
        inp[9][0] = 89;

        inp[0][1] = 1;
        inp[1][1] = 10;
        inp[2][1] = 26;
        inp[3][1] = 39;
        inp[4][1] = 45;
        inp[5][1] = 51;
        inp[6][1] = 61;
        inp[7][1] = 67;
        inp[8][1] = 79;
        inp[9][1] = 93;

        inp[0][2] = 2;
        inp[1][2] = 10;
        inp[2][2] = 26;
        inp[3][2] = 39;
        inp[4][2] = 46;
        inp[5][2] = 54;
        inp[6][2] = 61;
        inp[7][2] = 70;
        inp[8][2] = 79;
        inp[9][2] = 94;

        inp[0][3] = 2;
        inp[1][3] = 12;
        inp[2][3] = 29;
        inp[3][3] = 39;
        inp[4][3] = 46;
        inp[5][3] = 54;
        inp[6][3] = 62;
        inp[7][3] = 70;
        inp[8][3] = 80;
        inp[9][3] = 94;

        inp[0][4] = 5;
        inp[1][4] = 12;
        inp[2][4] = 29;
        inp[3][4] = 41;
        inp[4][4] = 46;
        inp[5][4] = 54;
        inp[6][4] = 63;
        inp[7][4] = 71;
        inp[8][4] = 82;
        inp[9][4] = 97;

        inp[0][5] = 6;
        inp[1][5] = 13;
        inp[2][5] = 31;
        inp[3][5] = 41;
        inp[4][5] = 47;
        inp[5][5] = 54;
        inp[6][5] = 64;
        inp[7][5] = 73;
        inp[8][5] = 84;
        inp[9][5] = 98;

        inp[0][6] = 6;
        inp[1][6] = 14;
        inp[2][6] = 32;
        inp[3][6] = 42;
        inp[4][6] = 48;
        inp[5][6] = 56;
        inp[6][6] = 65;
        inp[7][6] = 73;
        inp[8][6] = 84;
        inp[9][6] = 98;

        inp[0][7] = 6;
        inp[1][7] = 21;
        inp[2][7] = 35;
        inp[3][7] = 42;
        inp[4][7] = 48;
        inp[5][7] = 58;
        inp[6][7] = 66;
        inp[7][7] = 73;
        inp[8][7] = 84;
        inp[9][7] = 98;

        inp[0][8] = 7;
        inp[1][8] = 21;
        inp[2][8] = 37;
        inp[3][8] = 43;
        inp[4][8] = 51;
        inp[5][8] = 59;
        inp[6][8] = 67;
        inp[7][8] = 74;
        inp[8][8] = 87;
        inp[9][8] = 98;
        /*int[][] inp = new int[8][1];
        inp[0][0] = 1;
        inp[1][0] = 11;
        inp[2][0] = 49;
        inp[3][0] = 74;
        inp[4][0] = 77;
        inp[5][0] = 78;
        inp[6][0] = 93;
        inp[7][0] = 94;*/

        System.out.println(matrixSearch.searchMatrix(inp, 38));
    }

}
