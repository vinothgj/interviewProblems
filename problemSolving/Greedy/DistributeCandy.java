package Greedy;

public class DistributeCandy {
    public int candy(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        int[] C = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                B[i] = 1;
            } else {
                if (A[i] > A[i - 1]) {
                    B[i] = B[i - 1] + 1;
                } else {
                    B[i] = 1;
                }
            }
        }
        int val = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                C[i] = 1;
            } else {
                if (A[i] > A[i + 1]) {
                    C[i] = C[i + 1] + 1;
                } else {
                    C[i] = 1;
                }
            }
            val = Math.max(C[i], B[i]);
            sum += val;
        }

        return sum;
    }

    public static void main(String args[]) {
        DistributeCandy distributeCandy = new DistributeCandy();
        System.out.println(distributeCandy.candy(new int[]{1, 2}));
        System.out.println(distributeCandy.candy(new int[]{1, 5, 2, 1}));
        System.out.println(distributeCandy.candy(new int[]{2, 3, 4, 4, 3, 2, 1}));
    }
}
