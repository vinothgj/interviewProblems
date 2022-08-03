package dynamicprogramming.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BiPartite {

    int[] visitied;
    int[] colorNode;
    Map<Integer, ArrayList<Integer>> adjacentList;
    int isBiPartite;

    public int solve(int A, int[][] B) {
        adjacentList = new HashMap<Integer, ArrayList<Integer>>();
        colorNode = new int[A + 1];
        colorNode[0] = -1;
        visitied = new int[A + 1];
        visitied[0] = 1;
        isBiPartite = 1;

        for (int i = 1; i <= A; i++) {
            adjacentList.put(i, null);
        }
        int n = B.length;
        buildAdjucencyList(n, B);

        depthFirstSearch(1, A);
        return isBiPartite == 0 ? 0 : 2;
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

            if (adjacentList.get(key_2) == null) {
                lst = new ArrayList<Integer>();
                lst.add(key_1);
            } else {
                lst = adjacentList.get(key_2);
                lst.add(key_1);
            }

            adjacentList.put(key_2, lst);
        }
    }

    void depthFirstSearch(Integer element, int color) {
        visitied[element] = 1;
        colorNode[element] = color;

        if (adjacentList.get(element) != null && adjacentList.get(element).size() > 0) {
            for (Integer lstElement : adjacentList.get(element)) {
                if (visitied[lstElement] == 1) {
                    if (colorNode[lstElement] == colorNode[element]) {
                        isBiPartite = 0;
                    }
                } else {
                    depthFirstSearch(lstElement, 1 - color);
                }
            }
        }
    }
}
