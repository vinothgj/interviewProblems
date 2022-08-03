package stackandqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class SlidingWindowMax {
    int max = Integer.MIN_VALUE;

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] slidingMaximum(final int[] A, int B) {

        Queue<Integer> queue = new ArrayDeque<Integer>();
        int n = A.length, j = 0, k = 0, i = 0;
        int[] ans = new int[n - B + 1];

        //max = findMax(j, B - 1, A);
        while (j < B) {
            while (!queue.isEmpty() && A[queue.peek()] <= A[i]) {
                queue.poll();
            }
            queue.add(i);
            max = Math.max(max, A[i]);
            j++;
            i++;
        }

        ans[k++] = max;
        for (int p = B; p < n; p++) {
            int peek = queue.peek();
            if (A[peek] == A[p - B] && peek != -1) {
                if (A[peek] >= max) {
                    max = Integer.MIN_VALUE;
                }
                queue.poll();
            }

            int peekLast = !queue.isEmpty() ? ((ArrayDeque<Integer>) queue).peekLast() : -1;

            while (peekLast > 0 && A[peekLast] < A[p]) {
                ((ArrayDeque<Integer>) queue).pollLast();
                peekLast = !queue.isEmpty() ? ((ArrayDeque<Integer>) queue).peekLast() : -1;
            }
            queue.add(p);
            peek = !queue.isEmpty() ? queue.peek() : -1;
            max = (max == Integer.MIN_VALUE) ? findMax(peek, p, A) : Math.max(max, A[p]);
            {
                ans[k++] = max;
            }
        }
        for (int q = 0; q < ans.length; q++) {
            System.out.print(ans[q] + " ");
        }
        return ans;
    }

    int findMax(int peek, int p, int[] arr) {
        for (int q = peek; q <= p; q++) {
            max = Math.max(max, arr[q]);
        }
        return max;
    }

    public static void main(String arg[]) {
        SlidingWindowMax slidingWindowMax = new SlidingWindowMax();
     /*   System.out.println(slidingWindowMax.slidingMaximum(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
        System.out.println(slidingWindowMax.slidingMaximum(new int[]{1, 2, 3, 4, 2, 7, 1, 3, 6}, 6));
        System.out.println(slidingWindowMax.slidingMaximum(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 1));
        System.out.println(slidingWindowMax.slidingMaximum(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 2));
        System.out.println(slidingWindowMax.slidingMaximum(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 3));
        System.out.println(slidingWindowMax.slidingMaximum(new int[]{648, 614, 490, 138, 657, 544, 745, 582,
                738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178,
                637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705,
                900, 482, 558, 937, 207, 368}, 9));*/

        //System.out.println(slidingWindowMax.slidingMaximum(new int[]{718, 622, 531, 279, 442, 893, 282, 875, 252, 70, 402, 663, 22, 69, 611, 412, 302, 840, 589, 668, 346, 983, 227, 23, 703, 818, 100, 943, 728, 305, 72, 772, 35, 721, 550, 12, 405, 454, 902, 978, 579}, 9));
        System.out.println(slidingWindowMax.slidingMaximum(new int[]{268, 202, 139, 744, 502, 582, 94, 81, 117, 258, 506, 461, 531, 768, 827, 128, 592, 571, 559, 374, 910, 610, 561, 489, 647, 246, 355, 313, 158, 922, 557, 36, 430, 983, 913, 303, 765, 945, 167, 340, 869, 869, 609, 809, 529, 715, 34, 13, 657, 407, 684, 801, 129, 952, 159, 250, 546, 508, 540, 948, 429, 174}, 6));
    }
}
