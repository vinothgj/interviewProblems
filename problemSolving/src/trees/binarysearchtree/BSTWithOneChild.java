package trees.binarysearchtree;

public class BSTWithOneChild {
    public String solve(int[] A) {

        int n = A.length;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        int root = A[0];

        for (int i = 1; i < n; i++) {
            if (A[i] > root) {
                min = root;
            } else {
                max = root;
            }

            if (A[i] < min || A[i] > max) {
                return "NO";
            }
            root = A[i];
        }
        return "YES";

    }
}
