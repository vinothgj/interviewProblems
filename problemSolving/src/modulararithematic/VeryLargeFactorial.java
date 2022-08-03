package modulararithematic;

public class VeryLargeFactorial {

    public static void main(String args[]) {
        VeryLargeFactorial factorial = new VeryLargeFactorial();
        //System.out.println(factorial.solve(91, 72));
        //System.out.println(factorial.solve(35, 68));
        System.out.println(factorial.solve(2, 27));
    }

    int mod = 1000000007;

    public int solve(int A, int B) {
        long [] fact = new long[B + 1];
        // base case
        fact[0] = 1;
        for (int i = 1; i <= B; i++) {
            fact[i] = ((fact[i - 1] % (mod - 1)) * (i % (mod - 1))) % (mod - 1);
            System.out.println(fact[i]);
        }

        int ans = (int)fact[B];
        return (int) power(A, ans, mod);
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

}
