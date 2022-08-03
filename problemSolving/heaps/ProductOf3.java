package heaps;

import java.util.ArrayList;

public class ProductOf3 {
    ArrayList<Integer> inc;

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        inc = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int k = 0;
        while (k < 3) {
            ans.add(-1);
        }
        for (Integer a : A) {
            inc.add(a);
            buildHeap();
            heapify();
        }
        return null;
    }

    void buildHeap() {

    }

    void heapify() {

    }
}
