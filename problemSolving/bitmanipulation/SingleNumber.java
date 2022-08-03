package bitmanipulation;

public class SingleNumber {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    static int solve(final int[] A) {

        int x = 0;

        for (int i = 0; i < A.length; i++) {

            x = x ^ A[i];

        }

        return x;

    }

    public static void main(String args[]) {
        System.out.println(solve(new int[]{1, 2, 2, 3, 1}));
    }
}
