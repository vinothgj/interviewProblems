package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountRectangles {

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        int n = A.size();
        int m = B.size();
        if (n != m) {
            return 0;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < n; i++) {
            String key = A.get(i) + "," + B.get(i);
            int count = map.containsKey(key) ? map.get(key) : 0;
            map.put(key, count + 1);
        }
        int counter = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int ai = A.get(i);
                int aj = A.get(j);

                int bi = B.get(i);
                int bj = B.get(j);

                String pair1 = ai + "," + bi;
                String pair2 = aj + "," + bj;

                String check1 = ai + "," + bj;
                String check2 = aj + "," + bi;

                /*System.out.println("Ai " + ai);
                System.out.println("Aj " + aj);
                System.out.println("Bi " + bi);
                System.out.println("Bj " + bj);*/

                if (ai != aj && bi != bj) {
                    if (map.containsKey(check1) && map.containsKey(check2)) {
                        if (map.get(check1) == 1 && map.get(check2) == 1) {
                            counter++;
                        }
                    }
                }
                //System.out.println();
            }
        }

        return counter / 2;

    }

    public static void main(String arg[]) {
        CountRectangles countRectangles = new CountRectangles();
        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
        //arrayList1.addAll(Arrays.asList(9, 5, 1, 1, 3, 7, 7, 9, 6, 9, 2, 8));
        arrayList1.addAll(Arrays.asList(1302, 589, 651, 279, 1054, 1550, 310, 496, 1519, 992, 1302, 279, 1488, 1488, 434, 1178, 1054, 1054, 930, 930, 682, 341, 775, 62, 434, 899, 992, 1395, 1457, 1085, 1116, 496, 496, 155, 1116, 806, 310, 372, 1116, 496, 744, 93, 186, 372, 1178, 372, 1519, 1271, 0, 124, 31, 620, 93, 155, 465, 1023, 93, 217, 806, 217, 961, 558, 155, 1457, 1457, 124, 403, 992, 1457, 341, 1457, 248, 403));
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        //arrayList2.addAll(Arrays.asList(8, 1, 5, 3, 8, 5, 4, 5, 2, 2, 7, 9));
        arrayList2.addAll(Arrays.asList(1302, 248, 589, 93, 0, 961, 310, 868, 1209, 372, 620, 1178, 1178, 0, 1426, 1519, 310, 899, 403, 620, 1426, 527, 806, 1023, 1085, 1271, 527, 1085, 744, 310, 1240, 527, 341, 775, 62, 651, 806, 31, 1302, 1550, 1209, 713, 527, 1116, 0, 589, 651, 961, 403, 1023, 651, 465, 1488, 248, 961, 93, 589, 124, 93, 682, 1426, 992, 682, 1054, 217, 1426, 1085, 217, 1085, 1488, 1457, 620, 1302));
        System.out.println(countRectangles.solve(arrayList1, arrayList2));
    }

}
