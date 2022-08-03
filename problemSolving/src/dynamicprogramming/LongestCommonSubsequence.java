package dynamicprogramming;

public class LongestCommonSubsequence {
    int[][] dp;

    public static void main(String arg[]) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.solve("bebdeeedaddecebbbbbabebedc", "abaaddaabbedeedeacbcdcaaed"));
    }

    public int solve(String A, String B) {
        int n = A.length(), m = B.length();
        dp = new int[n][m];
        char[] X = A.toCharArray();
        char[] Y = B.toCharArray();
        return lcs(X, Y, n, m);
    }

    int lcs(char[] a, char[] b, int n, int m) {
        int ans = 0;
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n - 1][m - 1] != 0) {
            return dp[n - 1][m - 1];
        }
        if (a[n - 1] == b[m - 1]) {
            ans = 1 + lcs(a, b, n - 1, m - 1);
        } else {
            ans = Math.max(lcs(a, b, n - 1, m), lcs(a, b, n, m - 1));
        }
        dp[n - 1][m - 1] = ans;
        return dp[n - 1][m - 1];
    }
}
