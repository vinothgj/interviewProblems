package stackandqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class SumOfMinMax {
    public int solve(int[] A, int B) {
        Queue<Integer> minQueue = new ArrayDeque<Integer>(), maxQueue = new ArrayDeque<Integer>();
        int i = 0, n = A.length, sum = 0;

        while (i < B) {
            if (!maxQueue.isEmpty()) {
                while (!maxQueue.isEmpty() && A[maxQueue.peek()] < A[i]) {
                    maxQueue.poll();
                }
            }
            maxQueue.add(i);
            if (!minQueue.isEmpty()) {
                while (!minQueue.isEmpty() && A[minQueue.peek()] > A[i]) {
                    minQueue.poll();
                }
            }
            minQueue.add(i);
            i++;
        }

        sum += A[minQueue.peek()] + A[maxQueue.peek()];

        for (int j = B; j < n; j++) {
            int poll = (j - B);
            if (poll == maxQueue.peek()) {
                maxQueue.poll();
            }
            if (poll == minQueue.peek()) {
                minQueue.poll();
            }

            while (!maxQueue.isEmpty() && A[maxQueue.peek()] < A[i]) {
                maxQueue.poll();
            }
            while (!minQueue.isEmpty() && A[minQueue.peek()] > A[i]) {
                minQueue.poll();
            }
            maxQueue.add(i);
            minQueue.add(i);
            sum += A[minQueue.peek()] + A[maxQueue.peek()];
        }
        return sum;
    }

    public static void main(String args[]) {
        SumOfMinMax sumOfMinMax = new SumOfMinMax();
        System.out.println(sumOfMinMax.solve(new int[]{2, 5, -1, 7, -3, -1, -2}, 4));
        System.out.println(sumOfMinMax.solve(new int[]{2, -1, 3}, 2));
    }
}
