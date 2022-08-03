package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SortArrayInGivenOrder {

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();

        for (Integer ints : A) {
            if (map.containsKey(ints)) {
                int val = map.get(ints);
                map.put((int) ints, val + 1);
            } else {
                map.put((int) ints, 1);
            }
        }

        for (Integer ints : B) {
            if (map.containsKey(ints)) {
                int val = map.get(ints);
                int i = 0;
                while (i < val) {
                    res.add(ints);
                    i++;
                }
                map.remove(ints);
            }
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            int i = 0;

            while (i < val) {
                temp.add(key);
                i++;
            }
        }
        Collections.sort(temp);
        System.out.println(temp);

        res.addAll(temp);
        return res;
    }

    public static void main(String arg[]) {
        SortArrayInGivenOrder hash = new SortArrayInGivenOrder();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 4, 5));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(2, 3));
        /*a = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        b = new ArrayList<>(Arrays.asList(5, 4, 2));*/
       /* a = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
        b = new ArrayList<>(Arrays.asList(1, 100));*/
        a = new ArrayList<>(Arrays.asList(3, 20, 17, 17));
        b = new ArrayList<>(Arrays.asList(5, 9, 20, 11, 6, 18, 7, 13));
        System.out.println(hash.solve(a, b));
    }
}
