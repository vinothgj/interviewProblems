package hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CommonElements {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < A.size(); i++) {
            Integer key = A.get(i);
            if (map.containsKey(key)) {
                Integer val = map.get(key);
                map.put(key, val + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (int i = 0; i < B.size(); i++) {
            Integer key = B.get(i);
            if (map.containsKey(key)) {
                Integer val = map.get(key);
                if (val == 1)
                    map.remove(key);
                else
                    map.put(key, val - 1);
                ans.add(key);
            }
        }

        Collections.sort(ans);

        return ans;
    }

    public static void main(String args[]) {
        CommonElements commonElements = new CommonElements();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(2);
        a.add(1);

        ArrayList<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(3);
        b.add(1);
        b.add(2);

        System.out.println(commonElements.solve(a, b));
    }
}
