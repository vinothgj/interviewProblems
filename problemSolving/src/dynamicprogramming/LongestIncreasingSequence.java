package dynamicprogramming;

public class LongestIncreasingSequence {
    int[] dp;
    int ans;

    public static void main(String args[]) {
        LongestIncreasingSequence longestIncreasingSequence = new LongestIncreasingSequence();
        System.out.println(longestIncreasingSequence.findLIS(new int[]{6, 6, 9, 7, 3, 5, 1, 7, 10}));
        System.out.println(longestIncreasingSequence.findLIS(new int[]{1, 9, 5, 10, 2, 3, 1, 7, 6}));
        System.out.println(longestIncreasingSequence.findLIS(new int[]{9, 8, 3, 6, 4, 9, 2, 7, 2, 4}));
    }

    public int findLIS(int[] A) {
        int n = A.length;
        dp = new int[n];
        dp[0] = A[0];
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (dp[ans - 1] < A[i]) {
                dp[ans] = A[i];
                ans++;
            } else {
                int pos = lis(0, ans - 1, A[i]);
                dp[pos] = A[i];
            }
        }
        return ans;
    }

    int lis(int low, int high, int target) {
        int res = 0;
        while (low <= high) {
            int mid = low + high >> 1;
            if (dp[mid] == target) {
                return mid;
            }
            if (dp[mid] > target) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

}
