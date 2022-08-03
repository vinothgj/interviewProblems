package dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;

public class NDigitNumbers {
    int numberOfDigits = 0;
    int sum = 0; // counter = 0;
    int[][] dp;

    public static void main(String[] args) {
        NDigitNumbers nDigitNumbers = new NDigitNumbers();
        //System.out.println(nDigitNumbers.solve(2, 4));
        int[] a = { 1,2,3};
        int[] b = { 4,5,6};

        Collections.addAll(Arrays.asList(a));
        Collections.addAll(Arrays.asList(b));



    }

    public int solve(int A, int B) {
        numberOfDigits = A;
        sum = B;
        dp = new int[A][B];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = 0;
        for (int i = 1; i < 10; i++) {
            ans += ndigitNumber(A - 1, B - i);
            ans %= 1000000007;
        }
        return ans;
    }

    int ndigitNumber(int n, int s) {

        if (s < 0) {
            return 0;
        }

        if (n == 0 && s == 0) {
            return 1;
        }


        if (n == 0) {
            return 0;
        }

        if (dp[n][s] != -1) {
            return dp[n][s];
        }

        int ans = 0;
        for (int k = 0; k < 10; k++) {
            ans += ndigitNumber(n - 1, s - k);
            ans %= 1000000007;
        }

        dp[n][s] = ans;

        return dp[n][s];

    }
}
