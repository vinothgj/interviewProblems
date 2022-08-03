package modulararithematic;

public class PairSumDivisibleByM {


    public int solve(int[] A, int B) {
        int n = A.length;
        int mod = 1000000006;

        if (n == 1) {
            return 0;
        }

        if (n == 2) {

            if ((A[0] % mod + A[1] % mod) % mod == B) {
                return 1;
            }
            return 0;

        }

        int[] count = new int[B];

        for (int i = 0; i < n; i++) {
            count[A[i] % B]++;
        }

        int sum = (1 / 2) * (count[0] % mod * (count[0] - 1) % mod) % mod;

        int i = 1, j = B - 1;
        while (i <= j) {

            if (i == j) {
                sum = (sum + (((count[i] % mod) * ((count[j] - 1) % mod)) % mod) / 2) % mod;
            } else {
                sum = (sum + ((count[i] % mod) * (count[j] % mod)) % mod) % mod;
            }

            i++;
            j--;

        }

        return sum;

    }

    public static void main(String args[]) {

        PairSumDivisibleByM pair = new PairSumDivisibleByM();
        /*System.out.println(pair.solve(new int[]{1, 2, 3, 4, 5}, 2));
        System.out.println(pair.solve(new int[]{5, 17, 100, 11}, 28));*/
        System.out.println(pair.solve(new int[]{93, 9, 46, 79, 56, 24, 10, 26, 9, 93, 31, 93, 75, 7, 4, 80, 19, 67, 49, 84, 62, 100, 17, 40, 35, 84, 14, 81, 99, 31, 100, 66, 70, 2, 11, 84, 60, 89, 13, 57, 47, 60, 59, 60, 42, 67, 89, 29, 85, 83, 42, 47, 66, 80, 88, 85, 83, 82, 16, 23, 21, 55, 26, 2, 21, 92, 85, 26, 46, 3, 7, 95, 50, 22, 84, 52, 57, 44, 4, 23, 25, 55, 41, 49}, 37));
    }
}
