package dynamicprogramming.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CycleInDirectedGraph {
    int[] visitied;
    Map<Integer, ArrayList<Integer>> adjacentList;
    boolean cycleExists;

    public static void main(String[] args) {
        CycleInDirectedGraph cycleInDirectedGraph = new CycleInDirectedGraph();
        System.out.println(cycleInDirectedGraph.solve(5, new int[][]{{1, 2}, {4, 1}, {2, 4}, {3, 4}, {5, 2}, {1, 3}}));
        System.out.println(cycleInDirectedGraph.solve(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
        System.out.println(cycleInDirectedGraph.solve(5, new int[][]{{1, 2}, {1, 3}, {2, 3}, {1, 4}, {4, 3}, {4, 5}, {3, 5}}));
    }

    public int solve(int A, int[][] B) {
        cycleExists = false;
        adjacentList = new HashMap<Integer, ArrayList<Integer>>();
        visitied = new int[A + 1];
        visitied[0] = 1;
        for (int i = 1; i <= A; i++) {
            adjacentList.put(i, null);
        }
        int n = B.length;
        buildAdjucencyList(n, B);

        for (int i = 1; i <= A; i++) {
            ArrayList<Integer> list = adjacentList.get(i);
            if (list != null && list.size() > 0 && visitied[i] == 0) {
                depthFirstSearch(list);
            }

            if (cycleExists) {
                return 1;
            }

        }
        return 0;
    }

    void buildAdjucencyList(int n, int[][] inp) {
        for (int j = 0; j < n; j++) {
            ArrayList<Integer> lst;
            int key_1 = inp[j][0];
            int key_2 = inp[j][1];
            if (adjacentList.get(key_1) == null) {
                lst = new ArrayList<Integer>();
                lst.add(key_2);
            } else {
                lst = adjacentList.get(key_1);
                lst.add(key_2);
            }
            adjacentList.put(key_1, lst);
        }
    }

    void depthFirstSearch(ArrayList<Integer> list) {
        for (Integer adj : list) {
            if (visitied[adj] == 1) {
                cycleExists = true;
                return;
            }
            ArrayList<Integer> lst = adjacentList.get(adj);
            visitied[adj] = 1;
            if (lst != null && lst.size() > 0) {
                depthFirstSearch(lst);
            }
            visitied[adj] = 2;
        }
    }


}
