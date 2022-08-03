package backtracking;

import java.util.ArrayList;

public class NQueenProblem {
    boolean[] r2lDiagonal, l2rDiagonal, row;
    char[][] board = null;
    ArrayList<ArrayList<String>> result = null;
    ArrayList<String> option = null;

    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        option = new ArrayList<String>();
        result = new ArrayList<ArrayList<String>>();
        //p = 0;
        board = new char[A][A];
        r2lDiagonal = new boolean[(2 * A) - 1];
        l2rDiagonal = new boolean[(2 * A) - 1];
        row = new boolean[A];

        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                board[i][j] = '.';
            }
        }
        placeQueens(0, A);
       /* for (ArrayList<String> arr : result) {
            System.out.println(arr);
        }*/
        return result;

    }

    void placeQueens(int i, int n) {
        if (i == n) {
            for (int k = 0; k < n; k++) {
                StringBuilder stringBuilder = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    stringBuilder.append(board[k][j]);
                }
                option.add(stringBuilder.toString());
            }
            result.add(option);
            option = new ArrayList<String>();
            //p++;
            return;
        }
        for (int j = n - 1; j >= 0; j--) {
            if (!r2lDiagonal[j + i] && !l2rDiagonal[n - 1 + i - j] && !row[j]) {
                r2lDiagonal[j + i] = l2rDiagonal[n - 1 + i - j] = row[j] = true;
                board[i][j] = 'Q';
                placeQueens(i + 1, n);
                r2lDiagonal[j + i] = l2rDiagonal[n - 1 + i - j] = row[j] = false;
                board[i][j] = '.';
            }
        }
    }

    public static void main(String args[]) {
        NQueenProblem nQueenProblem = new NQueenProblem();
        System.out.println("Options are : ");
        nQueenProblem.solveNQueens(6);
    }

}
