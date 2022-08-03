package dynamicprogramming;

public class MaximumSum {
    public static void main(String arg[]) {
        MaximumSum maximumSum = new MaximumSum();
        //System.out.println(maximumSum.solve(new int[]{1, 5, -3, 4, -2}, 2, 1, -1));
        System.out.println(maximumSum.solve(new int[]{-44, -41, 1, -26}, 29, -15, 27));
        //System.out.println(maximumSum.solve(new int[]{-5, -39, -13, 38, -28, 28}, 0, -20, 20));
        //System.out.println(maximumSum.solve(new int[]{-6, 12, 10, 28, -14, -35, 42, 28}, -5, 14, 6));
    }

    public int solve(int[] A, int B, int C, int D, int E) {
        int n = A.length, maxIndex_1 = -1, maxIndex_2 = -1, max = 0, prod = 0;
        int[] dp_1 = new int[n], dp_2 = new int[n], dp_3 = new int[n];

        for (int i = 0; i < n; i++) {
            prod = A[i] * B;
            if (max < prod) {
                max = prod;
                maxIndex_1 = i;
            }
            dp_1[i] = prod;
        }
        for (int i = 0; i < n; i++) {
            prod = A[i] * C;
            dp_2[i] = prod;
        }

        prod = 0;
        for (int i = 0; i < n; i++) {
            prod = A[i] * D;
            dp_3[i] = prod;
        }

        int intrimMax = 0;
        for (int i = maxIndex_1; i < n; i++) {
            int sum = max + dp_2[i];
            if (intrimMax < sum) {
                intrimMax = sum;
                maxIndex_2 = i;
            }
        }

        int intrimMax_2 = 0;
        for (int i = maxIndex_2; i < n; i++) {
            int sum = intrimMax + dp_3[i];
            if (intrimMax_2 < sum) {
                intrimMax_2 = sum;
            }
        }

        return intrimMax_2;

    }

    public int solve(int[] A, int B, int C, int D) {
        int n = A.length;
        int[] first = new int[n];
        first[0] = A[0] * B;
        for (int i = 1; i < n; i++) {
            first[i] = Math.max(first[i - 1], A[i] * B);
        }
        int[] second = new int[n];
        second[0] = first[0] + (A[0] * C);
        for (int i = 1; i < n; i++) {
            second[i] = Math.max(second[i - 1], first[i] + (A[i] * C));
        }
        int[] third = new int[n];
        third[0] = second[0] + (A[0] * D);
        for (int i = 1; i < n; i++) {
            third[i] = Math.max(third[i - 1], second[i] + (A[i] * D));
        }
        return third[n - 1];
    }
}
