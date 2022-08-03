package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CombinationsSubsequence {

    ArrayList<Integer> input = new ArrayList<>();
    int size = 0, k = 0, limit = 0;
    Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> resp = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        for (int i = 1; i <= A; i++) {
            input.add(i);
        }
        size = input.size();
        limit = B;
        int count = 0;
        IdentifySubset(new Stack<Integer>(), 0, count);
        return resp;
    }

    void IdentifySubset(Stack<Integer> src, int idx, int countOfElements) {
        if (countOfElements == limit) {
            ArrayList<Integer> array = convertArrayListToIntArray(src.toArray());
            if (result.add(array)) {
                resp.add(k, array);
                k++;
            }
        }

        if (idx == input.size()) {
            return;
        }

        for (int i = idx; i < input.size(); i++) {
            src.push(input.get(idx));
            IdentifySubset(src, i + 1, countOfElements + 1);
            src.pop();
            IdentifySubset(src, i + 1, countOfElements);
        }
    }

    ArrayList<Integer> convertArrayListToIntArray(Object[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            res.add((Integer) arr[i]);
        }
        return res;
    }

    public static void main(String args[]) {
        CombinationsSubsequence combinationsSubsequence = new CombinationsSubsequence();
        ArrayList<Integer> inp = new ArrayList<>();
        //inp.add(11);
        inp.add(12);
        inp.add(13);
        combinationsSubsequence.combine(4, 3);
    }

}
