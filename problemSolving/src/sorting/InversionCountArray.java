package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class InversionCountArray {

    ArrayList<Integer> result;
    int inversionCounter = 0;

    public int solve(ArrayList<Integer> A) {
        inversionCounter = 0;
        result = new ArrayList<Integer>();
        mergesort(A, 0, A.size() - 1);
        return inversionCounter;
    }

    void mergesort(ArrayList<Integer> a, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergesort(a, start, mid);
        mergesort(a, mid + 1, end);
        merge(a, start, mid, end);
    }

    private ArrayList<Integer> merge(ArrayList<Integer> arr, int start, int mid, int end) {
        int n = mid - start + 1;
        int m = end - mid;
        int left[] = new int[n];
        int right[] = new int[m];

        for (int i = 0; i < n; ++i) {
            left[i] = arr.get(start + i);
        }
        for (int j = 0; j < m; ++j) {
            right[j] = arr.get(mid + 1 + j);
        }

        int i = 0, j = 0;
        int k = start;

        while (i < n && j < m) {
            if (left[i] <= right[j]) {
                arr.set(k, left[i]);
                i++;
            } else {
                arr.set(k, right[j]);
                inversionCounter = inversionCounter + (n - i);
                j++;
            }
            k++;
        }

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
        return result;
    }

    public static void main(String arg[]) {
        InversionCountArray inversionCountArray = new InversionCountArray();
        ArrayList<Integer> inp = new ArrayList<Integer>();
        //inp.addAll(Arrays.asList(3, 2, 1));
        //inp.addAll(Arrays.asList(1, 2, 3));
        //inp.addAll(Arrays.asList(4, 5, 1, 2, 7, 3));
        inp.addAll(Arrays.asList(1, 3, 2, 4, 2));
        System.out.println(inversionCountArray.solve(inp));
    }
}
