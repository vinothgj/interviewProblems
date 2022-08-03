package dynamicprogramming;

public class LongestValidParanthesis {
    int n, max;
    int[] dp;

    public static void main(String arg[]) {
        LongestValidParanthesis longestValidParanthesis = new LongestValidParanthesis();
        System.out.println(longestValidParanthesis.longestValidParentheses("(())"));
        System.out.println(longestValidParanthesis.longestValidParentheses("())"));
        System.out.println(longestValidParanthesis.longestValidParentheses(")()())"));
        System.out.println(longestValidParanthesis.longestValidParentheses(")()()())("));
    }

    public int longestValidParentheses(String A) {
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
            } else {
                ans = 0;
            }
            max = Math.max(ans, max);
            dp[i] = ans;
        }
        return max;
    }
}
