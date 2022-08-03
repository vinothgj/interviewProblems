package primenumbers;

public class CountOfDivisors {

    public int[] solve(int[] A) {
        int N = A.length;
        int[] B = new int[N];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            max = Math.max(max,A[i]);
        }

        int[] result = sieveOfEratosthenes(max);

        for (int i = 0; i < N; i++) {
            int value = result[A[i]];
            B[i] = value;
        }
        return B;
    }

    int[] sieveOfEratosthenes(int n) {
        int factors[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            factors[i] = 0;
        }

        for (int i = 1; i <= n; i++) {
                int multiple = 2;
                factors[i] = factors[i] + 1;
                int factor = i * multiple;
                while (factor <= n) {
                    factors[factor] = factors[factor] + 1;
                    multiple++;
                    factor = i * multiple;
                }
        }

        return factors;
    }

    public static void main(String args[]) {

        CountOfDivisors countOfDivisors = new CountOfDivisors();
        //countOfDivisors.solve(new int[]{8, 9, 10});
        //countOfDivisors.solve(new int[]{2,3,4,5});
        countOfDivisors.solve(new int[] {20, 39, 29, 51, 96, 32, 35, 50, 57, 7, 59, 51, 85, 55, 8, 26, 15, 4, 4, 18, 32, 49, 40, 46, 83, 77, 100, 92});
    }

}
