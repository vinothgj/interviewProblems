package combinatorics;

public class ComputeNCR {

    public int solve(int A, int B, int C) {
        int n = A, nr = (A - B), m = C, r = B;
        if (r == 1) {
            return n%m;
        }
        if(n == r || (r == 0)) {
            return 1;
        }

        long[] fact = new long[n+1];

        // base case
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * (i % m)) % m;
        }


        long inverseNR = power(fact[nr], (m - 2), m);
        long inverseR = power(fact[r], (m - 2), m);

        return (int) ((fact[n] * (inverseNR % m)) % m * (inverseR % m)) % m;

    }

    long power(long a, int b, int m) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            return power((a * a) % m, (b / 2), m) % m;
        }
        return (a * power((a * a) % m, (b - 1) / 2, m) % m) % m;

    }

    public static void main(String args[]) {
        ComputeNCR computeNCR = new ComputeNCR();
        System.out.println(computeNCR.solve(3985, 574, 92867));
    }
}
