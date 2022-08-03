package dynamicprogramming.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PathExistsDFS {
    int[] visitied;
    Map<Integer, ArrayList<Integer>> adjacentList;

    public static void main(String[] args) {
        PathExistsDFS pathInDirectedGraph = new PathExistsDFS();
        //System.out.println(pathInDirectedGraph.solve(new int[]{1, 1, 2}, 1, 2));
        System.out.println(pathInDirectedGraph.solve(new int[]{1, 1, 2}, 2, 1));
    }

    public int solve(int[] A, final int B, final int C) {
        adjacentList = new HashMap<Integer, ArrayList<Integer>>();
        int n = A.length;
        visitied = new int[n + 1];
        visitied[0] = 1;
        for (int i = 1; i <= C; i++) {
            adjacentList.put(i, null);
        }
        buildAdjucencyList(n, A);

        depthFirstSearch(C, B);
        return visitied[B];
    }

    void buildAdjucencyList(int n, int[] inp) {
        for (int j = 0; j < n; j++) {
            ArrayList<Integer> lst;
            int key_1 = inp[j];
            int key_2 = j + 1;
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

    void depthFirstSearch(Integer element, int target) {
        visitied[element] = 1;
        if (adjacentList.get(element) != null && adjacentList.get(element).size() > 0) {
            for (Integer lstElement : adjacentList.get(element)) {
                if (visitied[lstElement] != 1) {
                    depthFirstSearch(lstElement, target);
                }
            }
        }
    }

}
