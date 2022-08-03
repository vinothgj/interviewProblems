package heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EuclideanDistance {
    static Comparator<List<Integer>> infoComparator = new Comparator<List<Integer>>() {
        public int compare(List<Integer> s1, List<Integer> s2) {
            Integer distOne = s1.get(0) * s1.get(0) + s1.get(1) * s1.get(1);
            Integer distTwo = s2.get(0) * s2.get(0) + s2.get(1) * s2.get(1);
            return distOne >= distTwo ? 1 : -1;
        }
    };

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        Collections.sort(A, infoComparator);
        for (int i = 0; i < B; i++) {
            ans.add(A.get(i));
        }
        return ans;
    }
}
