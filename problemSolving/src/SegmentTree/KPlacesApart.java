package SegmentTree;

import java.util.PriorityQueue;

public class KPlacesApart {

   /* public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[] ans = new int[A];
    }*/

    public int[] solve(int[] A, int B) {
        int n = A.length;
        int[] ans = new int[n];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for (int i = 0; i < B + 1; i++) {
            priorityQueue.add(A[i]);
        }
        int index = 0;
        for (int i = B + 1; i < n; i++) {
            ans[index++] = priorityQueue.poll();
            priorityQueue.add(A[i]);
        }
        while (!priorityQueue.isEmpty()) {
            ans[index++] = priorityQueue.poll();
        }
        return ans;
    }

}
