package stackandqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class TaskSchedule {
    public int solve(int[] A, int[] B) {
        int j = 0, ans = 0;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < A.length; i++) {
            queue.add(A[i]);
        }

        for (int p = 0; p < B.length; p++) {
            int peek = queue.isEmpty() ? Integer.MAX_VALUE : queue.peek();
            while (peek != Integer.MAX_VALUE && B[p] != peek) {
                int poll = queue.poll();
                queue.add(poll);
                peek = queue.isEmpty() ? Integer.MAX_VALUE : queue.peek();
                ans++;
            }
            queue.poll();
            ans++;
        }

        return ans;
    }

    public static void main(String args[]) {
        TaskSchedule taskSchedule = new TaskSchedule();
        System.out.println(taskSchedule.solve(new int[]{2, 3, 1, 5, 4}, new int[]{1, 3, 5, 4, 2}));
        System.out.println(taskSchedule.solve(new int[]{1}, new int[]{1}));
        System.out.println(taskSchedule.solve(new int[]{1, 3, 4, 5, 2}, new int[]{5, 3, 4, 1, 2}));
    }
}
