package dynamicprogramming;

public class PalindromicPartitioning2 {
    boolean[][] pal;
    int[] dp;

    public static void main(String arg[]) {
        PalindromicPartitioning2 palindromicPartitioning2 = new PalindromicPartitioning2();
        //System.out.println(palindromicPartitioning2.minCut("aba"));
        System.out.println(palindromicPartitioning2.minCut("banana"));
        /*System.out.println(palindromicPartitioning2.minCut("aab"));
        System.out.println(palindromicPartitioning2.minCut("bananas"));
        System.out.println(palindromicPartitioning2.minCut("malayalam"));
        System.out.println(palindromicPartitioning2.minCut("rajan"));
        System.out.println(palindromicPartitioning2.minCut("ababb"));*/
        //System.out.println(palindromicPartitioning2.minCut("XfCtL38GNmYvAhmYEIecokbWJjAXsdGZ3Ro1dT1BEx6fFGPqmMMaRAaYcPFvcobsNtWZxW1U11kEHfRbMpv2q3VGPVOP8dK"));


    }

    public int minCut1(String A) {
        int n = A.length();
        if (isPalindrome(0, n - 1, A)) {
            return 0;
        }
        dp = new int[n];
        //Arrays.fill(dp, 0);
        pal = new boolean[n][n];
        buildMatrix(A, n);

        for (int i = 0; i < n; i++) {
            if (pal[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j <= i; j++) {
                if (pal[j][i]) {
                    //dp[i] = Math.min(dp[i] == 0 ? Integer.MAX_VALUE : dp[i], j == 0 ? 0 : 1 + dp[j - 1]);
                    dp[i] = j == 0 ? 0 : 1 + dp[j - 1];
                    break;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            System.out.print(dp[k] + " ");
        }
        System.out.println();
        return dp[n - 1];
    }

    boolean isPalindrome(int a, int b, String str) {
        if (a > b) {
            return true;
        }

        if (str.charAt(a) == str.charAt(b)) {
            return isPalindrome(a + 1, b - 1, str);
        }
        return false;
    }

    void buildMatrix(String str, int size) {
        for (int i = size - 1; i >= 0; i--) {
            pal[i][i] = true;
            for (int j = 0; j < size; j++) {
                if (j > i) {
                    if (str.charAt(i) == str.charAt(j) && (pal[i + 1][j - 1] || Math.abs(j - i) == 1)) {
                        pal[i][j] = true;
                    } else {
                        pal[i][j] = false;
                    }
                }
            }
        }
    }

    public int minCut(String A) {
        boolean dp[][] = new boolean[A.length()][A.length()];

        for (int g = 0; g < A.length(); g++) {
            for (int i = 0, j = g; j < A.length(); j++, i++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    dp[i][j] = A.charAt(i) == A.charAt(j);
                } else {
                    dp[i][j] = A.charAt(i) == A.charAt(j) && dp[i + 1][j - 1];
                }
            }
        }

        int cost[] = new int[A.length()];
        cost[0] = 0;
        for (int j = 1; j < A.length(); j++) {
            if (dp[0][j]) {
                cost[j] = 0;
            } else {
                int min = Integer.MAX_VALUE;

                for (int i = j; i >= 1; i--) {

                    if (dp[i][j]) {
                        if (cost[i - 1] < min) {
                            min = cost[i - 1];
                        }
                    }
                }
                cost[j] = min + 1;
            }
        }
        return cost[A.length() - 1];
    }
}
