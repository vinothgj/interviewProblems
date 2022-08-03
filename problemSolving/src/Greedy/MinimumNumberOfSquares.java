package Greedy;

public class MinimumNumberOfSquares {
    public static void main(String arg[]) {
        MinimumNumberOfSquares minimumNumberOfSquares = new MinimumNumberOfSquares();
        System.out.println(minimumNumberOfSquares.countMinSquares(12));
        System.out.println(minimumNumberOfSquares.countMinSquares(13));
        System.out.println(minimumNumberOfSquares.countMinSquares(30));
        System.out.println(minimumNumberOfSquares.countMinSquares(27));
        System.out.println(minimumNumberOfSquares.countMinSquares(42));
    }

    public int countMinSquares(int A) {
       /* int n = A / 2, count = 0;
        while (n >= 2 && A > 0) {
            if ((n * n) <= A) {
                A -= (n * n);
                n = A / 2;
                count++;
            } else {
                n--;
            }

        }

        if (A > 0) {
            count += A;
        }
        return count;*/
        int[] dp = new int[A + 1];
        for (int i = 1; i <= A; i++) {
            dp[i] = i;
            for (int x = 1; (x * x) <= i; x++) {
                dp[i] = Math.min(dp[i], dp[i - (x * x)] + 1);
            }
        }
        return dp[A];
    }
}
