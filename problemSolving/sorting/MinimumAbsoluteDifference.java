package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumAbsoluteDifference {
    ArrayList<Integer> result;

    public int solve(ArrayList<Integer> A) {

        result = new ArrayList<Integer>();
        int minimum_diff = Integer.MAX_VALUE;
        mergesort(A, 0, A.size() - 1);
        if (result != null && result.size() > 0) {
            for (int p = 0; p < result.size() - 1; p++) {
                //System.out.print(result.get(p) + " ");
                minimum_diff = Math.min(minimum_diff, Math.abs(result.get(p) - result.get(p + 1)));
            }
            //System.out.print(result.get(result.size() - 1) + " ");
        }
        return minimum_diff;

    }


    void mergesort(ArrayList<Integer> a, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergesort(a, start, mid);
        mergesort(a, mid + 1, end);
        result = merge(a, start, mid, end);
    }

    private ArrayList<Integer> merge(ArrayList<Integer> arr, int start, int mid, int end) {
        // Find sizes of two subarrays to be merged
        int n = mid - start + 1;
        int m = end - mid;
        int left[] = new int[n];
        int right[] = new int[m];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n; ++i) {
            left[i] = arr.get(start + i);
        }
        for (int j = 0; j < m; ++j) {
            right[j] = arr.get(mid + 1 + j);
        }

        int i = 0, j = 0, k = start;
        while (i < n && j < m) {
            if (left[i] <= right[j]) {
                arr.set(k, left[i]);
                i++;
            } else {
                arr.set(k, right[j]);
                j++;
            }
            k++;
        }

        /* Copy remaining elements of left[] if any */
        while (i < n) {
            arr.set(k, left[i]);
            i++;
            k++;
        }

        /* Copy remaining elements of right[] if any */
        while (j < m) {
            arr.set(k, right[j]);
            j++;
            k++;
        }
        return arr;
    }

    public static void main(String args[]) {
        MinimumAbsoluteDifference minimumAbsoluteDifference = new MinimumAbsoluteDifference();
        ArrayList<Integer> inp = new ArrayList<>();
        inp.addAll(Arrays.asList(5, 17, 100, 11));
        System.out.println(minimumAbsoluteDifference.solve(inp));
    }
}
