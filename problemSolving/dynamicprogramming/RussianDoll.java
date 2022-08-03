package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class RussianDoll {
    static Comparator<Envelope> envelopeComparator = new Comparator<Envelope>() {
        public int compare(Envelope s1, Envelope s2) {
            return s1.height - s2.height;
        }
    };

    public int solve(int[][] A) {
        int max = 0;
        int n = A.length;
        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
        //lis array
        int[] lis = new int[n];
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i][0] > A[j][0] && A[i][1] > A[j][1] && lis[i] <= lis[j]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
//pick max among lis values
        for (int i = 0; i < n; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }
        return max;
    }

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int size = A.size();
        int[] dp = new int[size];
        int max = Integer.MIN_VALUE;

        ArrayList<Envelope> envelopes = new ArrayList<Envelope>();
        for (ArrayList<Integer> lst : A) {
            envelopes.add(new Envelope(lst.get(0), lst.get(1)));
        }
        int n = envelopes.size();
        Collections.sort(envelopes, envelopeComparator);
        Arrays.fill(dp, 1);

        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j < n) {
                if (envelopes.get(i).height > envelopes.get(j).height &&
                        envelopes.get(i).width > envelopes.get(j).width && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
                j++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    /* Before SOrting : [5, 4], [6, 4], [6, 7], [2, 3]
     * After Sorting : [2, 3], [5, 4], [6, 4], [6, 7] */

    /*
    [2, 14] , [3, 11], [4, 15], [5, 6], [5, 11], [6, 18], [8, 11], [11, 10]
     */

    class Envelope {
        int height;
        int width;

        public Envelope(int height, int width) {
            this.height = height;
            this.width = width;
        }
    }
}


