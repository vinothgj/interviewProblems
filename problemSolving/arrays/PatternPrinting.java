package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatternPrinting {
    public static void main(String arg[]) {
        PatternPrinting patternPrinting = new PatternPrinting();
        // System.out.println(patternPrinting.solve(5));
        List<Integer> lst = new ArrayList<>();
        lst.addAll(Arrays.asList(4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8));
        System.out.println(patternPrinting.twoSum(lst, -3));
    }

    public ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> inter;
        int k = 1;
        for (int j = A; j >= 1; j--) {
            inter = new ArrayList<>();
            for (int i = A; i >= 1; i--) {
                if (i <= k) {
                    inter.add(i);
                } else {
                    inter.add(0);
                }
            }
            k++;
            ans.add(inter);
        }
        return ans;
    }

    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int minIndex2 = Integer.MAX_VALUE;
        int minIndex1 = Integer.MAX_VALUE;
        boolean found = false;
        for (int i = 0; i < A.size(); i++) {
            int temp = B - A.get(i);
            if (A.contains(temp)) {
                found = true;
                int cur = A.indexOf(temp) + 1;
                if (minIndex2 != cur) {
                    minIndex2 = Math.min(cur, minIndex2);
                    minIndex1 = i + 1;
                } else {
                    minIndex2 = cur;
                    minIndex1 = Math.min(minIndex1, i + 1);
                }
            }
        }
        if (found) {
            ans.add(minIndex1);
            ans.add(minIndex2);
            return ans;
        }

        return ans;
    }
}
