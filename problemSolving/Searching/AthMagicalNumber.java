package Searching;

public class AthMagicalNumber {

    public int solve(int A, int B, int C) {
        int l = lcm(B, C);
        long high = (Math.min(B, C) * A * 1L);
        long low = Math.min(B, C);

        return findMagicalNumber(A, low, high, l, B, C);
    }

    int findMagicalNumber(int A, long low, long high, int lc, int b, int c) {
        long ans = 0;

        while (low <= high) {
            long mid = (high + low) / 2;

            if (numberOfElements(mid, b, c, lc) % 1000000007 >= A) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        int ans1 = (int) (ans % 1000000007);
        return ans1;
    }

    int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    int lcm(int a, int b) {
        return (a / gcd(a, b) * b);
    }

    long numberOfElements(long x, int b, int c, int l) {
        return (x / b) + (x / c) - (x / l);
    }

    public static void main(String arg[]) {
        AthMagicalNumber athMagicalNumber = new AthMagicalNumber();
        /*System.out.println(athMagicalNumber.solve(4, 2, 3));
        System.out.println(athMagicalNumber.solve(7, 2, 3));*/
        System.out.println(athMagicalNumber.solve(33488383, 565, 29473));
    }
}
