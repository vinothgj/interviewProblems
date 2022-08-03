package dynamicprogramming;

public class MaximumProductSubArray {
    public static void main(String args[]) {
        MaximumProductSubArray maximumProductSubArray = new MaximumProductSubArray();
        System.out.println(maximumProductSubArray.maxProduct(new int[]{4, 2, -5, -1}));
    }

    /*
    Problem Description - Given an integer array A of size N.
    Find the contiguous subarray within the given array
    (containing at least one number) which has the largest product.
    Return an integer corresponding to the maximum product possible.
    NOTE: Answer will fit in 32-bit integer value.
     */
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProduct(final int[] A) {
        int n = A.length, minElement = 0, maxElement = 0;
        int dpMinSeq[] = new int[n];
        int dpMaxSeq[] = new int[n];

        dpMinSeq[0] = dpMaxSeq[0] = A[0];

        for (int i = 1; i < n; i++) {
            dpMinSeq[i] = Math.min(Math.min(A[i], A[i] * dpMinSeq[i - 1]), A[i] * dpMaxSeq[i - 1]);
            minElement = Math.min(minElement, dpMinSeq[i]);
            dpMaxSeq[i] = Math.max(Math.max(A[i], A[i] * dpMinSeq[i - 1]), A[i] * dpMaxSeq[i - 1]);
            maxElement = Math.max(maxElement, dpMaxSeq[i]);
        }

        return maxElement;


    }
}
