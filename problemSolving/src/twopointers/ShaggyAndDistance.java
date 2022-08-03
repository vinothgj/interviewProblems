package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShaggyAndDistance {
    public int solve(ArrayList<Integer> A) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < A.size(); i++) {
            int val = A.get(i);
            System.out.println("Value @ " + i + " " + val);
            if (map.containsKey(val)) {
                int abs = Math.abs((i + 1) - map.get(val));
                System.out.println("Abs @ " + i + " " + abs);
                ans = Math.min(ans, abs);
            } else {
                map.put(val, i + 1);
            }
        }

        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }

    public static void main(String arg[]) {
        ShaggyAndDistance shaggyAndDistance = new ShaggyAndDistance();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        //arrayList.addAll(Arrays.asList(7, 1, 3, 4, 1, 7));
        arrayList.addAll(Arrays.asList(1, 1));
        System.out.println(shaggyAndDistance.solve(arrayList));
    }
}
