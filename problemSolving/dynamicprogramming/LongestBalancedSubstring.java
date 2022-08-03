package dynamicprogramming;

public class LongestBalancedSubstring {
    int[] dp;
    int n, max = 0;

    public static void main(String arg[]) {
        LongestBalancedSubstring longestBalancedSubstring = new LongestBalancedSubstring();
        System.out.println(longestBalancedSubstring.LBSlength("[()]"));
        System.out.println(longestBalancedSubstring.LBSlength("[(])"));
        System.out.println(longestBalancedSubstring.LBSlength("[[{()}]]"));
        System.out.println(longestBalancedSubstring.LBSlength("([[]]()}["));
        System.out.println(longestBalancedSubstring.LBSlength("[]]"));
    }

    public int LBSlength(final String A) {
        n = A.length();
        max = 0;
        dp = new int[n];
        dp[0] = 0;
        return balanceSubstring(A);
    }

    int balanceSubstring(String inputString) {
        for (int i = 1; i < n; i++) {
            int ans = 0;
            if (inputString.charAt(i) == ')') {
                if (inputString.charAt(i - 1) == '(') {
                    ans = (i - 2) > 0 ? dp[i - 2] + 2 : 2;
                } else if ((i - dp[i - 1] - 1) >= 0 && inputString.charAt(i - dp[i - 1] - 1) == '(') {
                    int temp = (i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0;
                    ans = dp[i - 1] + 2 + temp;
                }
            } else if (inputString.charAt(i) == ']') {
                if (inputString.charAt(i - 1) == '[') {
                    ans = (i - 2) > 0 ? dp[i - 2] + 2 : 2;
                } else if ((i - dp[i - 1] - 1) >= 0 && inputString.charAt(i - dp[i - 1] - 1) == '[') {
                    int temp = (i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0;
                    ans = dp[i - 1] + 2 + temp;
                }
            } else if (inputString.charAt(i) == '}') {
                if (inputString.charAt(i - 1) == '{') {
                    ans = (i - 2) > 0 ? dp[i - 2] + 2 : 2;
                } else if ((i - dp[i - 1] - 1) >= 0 && inputString.charAt(i - dp[i - 1] - 1) == '{') {
                    int temp = (i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0;
                    ans = dp[i - 1] + 2 + temp;
                }
            } else {
                ans = 0;
            }
            max = Math.max(ans, max);
            dp[i] = ans;
        }
        return max;
    }
}
