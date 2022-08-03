package dynamicprogramming.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BiPartite2 {
    static int max = 100009;
    static int[] colorNode = new int[max];
    static long modulo = (1000 * 1000 * 1000) + 7;
    static ArrayList<ArrayList<Integer>> adjucantList;
    long levelZeroCount = 0, levelOneCount = 0;

    public void graph() {
        adjucantList = new ArrayList<ArrayList<Integer>>(max);
        for (int i = 0; i < max; i++) {
            adjucantList.add(new ArrayList<Integer>());
            colorNode[i] = -1;
        }
    }

    public int solve(int A, int[][] B) {
        graph();
        for (int[] edge : B) {
            adjucantList.get(edge[0]).add(edge[1]);
            adjucantList.get(edge[1]).add(edge[0]);
        }
        breathFirstSearch(1);
        return (int) ((((levelZeroCount % modulo * levelOneCount % modulo) % modulo) - (A - 1) + modulo) % modulo);
    }

    public void breathFirstSearch(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        colorNode[node] = 1;
        levelOneCount++;
        while (!queue.isEmpty()) {
            node = queue.poll();
            for (Integer child : adjucantList.get(node)) {
                if (colorNode[child] == -1) {
                    colorNode[child] = 1 - colorNode[node];
                    if (colorNode[child] == 1) {
                        levelOneCount++;
                    } else {
                        levelZeroCount++;
                    }
                    queue.add(child);
                }
            }
        }
    }
}
