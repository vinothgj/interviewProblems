package combinatorics;

public class Summation {
    public int solve(int A) {
        int P = 1000000007;
        long product = A * (A - 1);
        long sum = power(3, (A - 2), P) % P;
        //long result = ((sum % P) * (product % P)) % P;
        return (int) ((sum % P * product % P) % P);
    }

    static long power(long a, int b, int m) {
        if (b == 0) {
            return 1;
        }
        long result = power(a, b / 2, m);
        result = (result * result) % m;
        if (b % 2 != 0) {
            return (result * a) % m;
        }
        return result;
    }

    public static void main(String arg[]) {
        Summation summation = new Summation();
        System.out.println(summation.solve(90));
    }
}
