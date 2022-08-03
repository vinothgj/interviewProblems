package backtracking;
/*
Count subsequqnce using backtracking
*/


public class CountSubsequence {
    int ans = 0;

    public int solve(int[] A, int B) {
        int sum = 0, count = 0, i = 0;
        ans = 0;
        countSubsequence(A, sum, count, i, B);
        return ans;
    }

    int countSubsequence(int[] S, int sum, int countOfElements, int index, int limit) {

        if (countOfElements == limit && sum <= 1000) {
            return ans++;
        }

        if ((sum > 1000) || (index == S.length)) {
            return 0;
        }

        countSubsequence(S, sum + S[index], countOfElements + 1, index+1, limit);
        countSubsequence(S, sum, countOfElements, index+1, limit);
        return ans;
    }

    public static void main(String args[]) {
        CountSubsequence countSubsequence = new CountSubsequence();
        System.out.println(countSubsequence.solve(new int[] {5, 17, 1000, 11}, 4));
        //System.out.println(countSubsequence.solve(new int[]{1, 2, 8}, 2));
    }
}
