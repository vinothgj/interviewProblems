package dynamicprogramming;

public class WaysToDecode {
    int[] dp;

    public static void main(String args[]) {
        WaysToDecode waysToDecode = new WaysToDecode();
        System.out.println(waysToDecode.numDecodings("123"));
        System.out.println(waysToDecode.numDecodings("12"));
        System.out.println(waysToDecode.numDecodings("8"));
        System.out.println(waysToDecode.numDecodings("226"));
        System.out.println(waysToDecode.numDecodings("2262"));
        System.out.println(waysToDecode.numDecodings("3734"));
        System.out.println(waysToDecode.numDecodings("370134"));
        System.out.println(waysToDecode.numDecodings("371034"));
        System.out.println(waysToDecode.numDecodings("5163490394499093221199401898020270545859326357520618953580237168826696965537789565062429676962877038781708385575876312877941367557410101383684194057405018861234394660905712238428675120866930196204792703765204322329401298924190"));
    }

    public int numDecodings(String A) {
        int n = A.length();
        dp = new int[n + 1];
        return ways(A, n);
    }

    int ways(String str, int len) {
        if (len == 0) {
            return 1;
        }

        if (dp[len] != 0) {
            return dp[len];
        }

        int num = 0;
        for (int i = 0; i < 2 && i < len; i++) {
            num = num * 10 + (str.charAt(i) - '0');
            if (num < 10 && i == 1) {
                break;
            } else if (num == 0) {
                continue;
            } else if (num <= 26 && num > 0) {
                dp[len] = (dp[len] + decode(str.substring(i + 1, len), len - 1 - i)) % 1000000007;
            }
        }
        return dp[len];
    }

    int decode(String A, int n) {
        if (n == 0) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int num = 0;
        for (int i = 0; i < 2 && i < n; i++) {
            num = num * 10 + (A.charAt(i) - '0');
            if (num < 10 && i == 1) {
                break;
            } else if (num == 0) {
                continue;
            } else if (num <= 26 && num > 0) {
                dp[n] = (dp[n] + decode(A.substring(i + 1, n), n - 1 - i)) % 1000000007;
            }
        }

        return dp[n];
    }
}
