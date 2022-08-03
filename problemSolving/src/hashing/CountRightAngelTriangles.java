package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountRightAngelTriangles {

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size(), ans = 0;
        Map<Integer, Integer> mapX = new HashMap<Integer, Integer>();
        Map<Integer, Integer> mapY = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            int i1 = A.get(i);
            int i2 = B.get(i);
            int countX = mapX.containsKey(i1) ? mapX.get(i1) : 0;
            int countY = mapY.containsKey(i2) ? mapY.get(i2) : 0;
            mapX.put(i1, countX + 1);
            mapY.put(i2, countY + 1);
        }

        for (int i = 0; i < n; i++) {

            int valX = mapX.get(A.get(i));
            int valY = mapY.get(B.get(i));
            ans += (valX - 1) * (valY - 1);
        }
        return ans;
    }

    public static void main(String arg[]) {
        CountRightAngelTriangles countRightAngelTriangles = new CountRightAngelTriangles();
        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
        //arrayList1.addAll(Arrays.asList(1, 1, 2, 3, 3));
        arrayList1.addAll(Arrays.asList(40, 27, 48, 2, 20, 38, 9, 45, 26, 32, 5, 1, 30, 17, 5, 21, 17, 44, 15));
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        //arrayList2.addAll(Arrays.asList(1, 2, 1, 2, 1));
        arrayList2.addAll(Arrays.asList(13, 5, 40, 36, 11, 12, 47, 18, 13, 30, 20, 29, 50, 8, 5, 6, 23, 46, 30));
        System.out.println(countRightAngelTriangles.solve(arrayList1, arrayList2));
    }
}
