package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PointsOnSameLine {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        int n = A.size(), m = B.size(), ans = 0;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<String, Integer>();
            int duplicate = 1;
            for (int j = i + 1; j < n; j++) {
                if (A.get(j) == A.get(i) && B.get(i) == B.get(j)) {
                    duplicate++;
                } else {
                    int dx = A.get(j) - A.get(i);
                    int dy = B.get(j) - B.get(i);
                    int g = gcd(dx, dy);
                    String key = (dx / g) + "_" + (dy / g);
                    int count = map.containsKey(key) ? map.get(key) : 0;
                    map.put(key, count + 1);
                }
            }
            ans = Math.max(ans, duplicate);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                ans = Math.max(ans, entry.getValue() + duplicate);
            }
        }
        return ans;
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String args[]) {
        PointsOnSameLine pointsOnSameLine = new PointsOnSameLine();
        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
        //arrayList1.addAll(Arrays.asList(-1, 0, 1, 2, 3, 3));
        arrayList1.addAll(Arrays.asList(3, 1, 4, 5, 7, -9, -8, 6));
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        //arrayList2.addAll(Arrays.asList(1, 0, 1, 2, 3, 4));
        arrayList2.addAll(Arrays.asList(4, -8, -3, -2, -1, 5, 7, -4));
        System.out.println(pointsOnSameLine.solve(arrayList1,arrayList2));
    }
}
