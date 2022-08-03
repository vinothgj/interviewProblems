package backtracking;

public class Fibonicci {
    static int[] dp;

    public int findAthFibonacci(int A) {
        int n = A;
        dp = new int[n + 1];
        return fibonacci(n);
    }

    static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        if (dp[n] > 0) {
            return dp[n];
        }
        dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return dp[n];
    }

    public static void main(String arg[]) {
        Fibonicci fibonicci = new Fibonicci();
        System.out.println(fibonicci.findAthFibonacci(4));
    }
}
