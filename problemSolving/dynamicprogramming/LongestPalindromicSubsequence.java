package dynamicprogramming;

public class LongestPalindromicSubsequence {
    public static void main(String arg[]) {
        LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();
        System.out.println(longestPalindromicSubsequence.solve("abac"));
        System.out.println(longestPalindromicSubsequence.solve("abaaddaabbedeedeacbcdcaaed"));
    }

    public int solve(String A) {
        int n = A.length(), j = 0;
        int[][] ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            ans[i][i] = 1;
        }
        for (int diff = 1; diff < n; diff++) {
            for (int i = 0; i < (n - diff); i++) {
                j = i + diff;
                if (A.charAt(i) == A.charAt(j)) {
                    if (diff == 1) {
                        ans[i][j] = 2;
                    } else {
                        ans[i][j] = ans[i + 1][j - 1] + 2;
                    }
                } else if (A.charAt(i) != A.charAt(j)) {
                    ans[i][j] = Math.max(ans[i][j - 1], ans[i + 1][j]);
                }
            }
        }
        return ans[0][n - 1];
    }
}
