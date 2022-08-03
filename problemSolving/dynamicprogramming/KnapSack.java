package dynamicprogramming;

public class KnapSack {

    public static void main(String arg[]) {

        KnapSack knapSack = new KnapSack();
        System.out.println(knapSack.solve(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50));
        System.out.println(knapSack.solve(new int[]{20, 5, 10, 40, 15, 25}, new int[]{1, 2, 3, 8, 7, 4}, 10));
        System.out.println(knapSack.solve(new int[]{359, 963, 465, 706, 146, 282, 828, 962, 492}, new int[]{96, 43, 28, 37, 92, 5, 3, 54, 93}, 383));

    }

    public int solve(int[] A, int[] B, int C) {
        return knapSackSolution(A, B, C);
    }

    int knapSackSolution(int[] profit, int[] weight, int cap) {
        int n = profit.length;
        /*int[][] dp = new int[n + 1][cap + 1];
        for (int idx = 0; idx <= n; idx++) {
            for (int wt = 0; wt <= cap; wt++) {
                if (idx == 0 || wt == 0) {
                    dp[idx][wt] = 0;
                } else if (weight[idx - 1] <= wt) {
                    dp[idx][wt] = Math.max(profit[idx - 1] + dp[idx - 1][wt - weight[idx - 1]], dp[idx - 1][wt]);
                } else {
                    dp[idx][wt] = dp[idx - 1][wt];
                }
            }
        }
        return dp[n][cap];*/

        int[] row_1 = new int[cap + 1], row_2 = new int[cap + 1];
        for (int idx = 1; idx <= n; idx++) {
            for (int i = 0; i <= cap; i++) {
                if (i == 0) {
                    row_2[i] = 0;
                } else if (weight[idx - 1] <= i) {
                    row_2[i] = Math.max(profit[idx - 1] + row_1[i - weight[idx - 1]], row_1[i]);
                } else {
                    row_2[i] = row_1[i];
                }
            }
            int[] temp = row_1;
            row_1 = row_2;
            row_2 = temp;
        }

        return row_1[cap];


    }

    /*int knapSackSolution(int[] profit, int[] weight, int idx, int capacity) {
        if (idx <= 0 || capacity <= 0) {
            return 0;
        }

        if (weight[idx - 1] > capacity) {
            return knapSackSolution(profit, weight, idx - 1, capacity);
        }

        int ans = 0;
        int selectionSkip = knapSackSolution(profit, weight, idx - 1, capacity);
        int selectionMade = profit[idx - 1] + knapSackSolution(profit, weight, idx - 1, capacity - weight[idx - 1]);
        ans = Math.max(selectionSkip, selectionMade);
        return ans;
    }*/
}
