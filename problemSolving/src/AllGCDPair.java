import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllGCDPair {

    public static int[] solve(int[] A) {

        int n = A.length;
        int g = 0;
        Set<Integer> resultSet = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(A[i]);
        }
        Collections.sort(list, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            System.out.print(list.get(i) + " ");
        }
        //System.out.println();
        for (int i = 0; i < n; i++) {
            int newVal = list.get(i);
            if (g > newVal) {
                g = 0;
            }
            g = gcd(g, newVal);
            resultSet.add(g);

            System.out.print(g + " ");
        }

        int i = 0;
        System.out.println();
        int[] arr = new int[resultSet.size()];
        for (Integer val : resultSet) {
            arr[i++] = val;

            //System.out.print(val + " ");
        }

        return arr;


    }

    static int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);

    }


    public static void main(String args[]) {

        //System.out.println(AllGCDPair.solve(new int[]{2, 2, 2, 2, 8, 2, 2, 2, 10}));
        //System.out.println(AllGCDPair.solve(new int[]{ 2, 3, 6, 12, 15}));
        //System.out.println(AllGCDPair.solve(new int[]{ 5, 5, 5, 15}));

        System.out.println(AllGCDPair.solve(new int[]{1, 31, 1, 1, 1, 1, 14, 2, 1, 1, 1, 2, 22, 1, 11, 1, 1, 1, 1, 23, 1, 1, 11, 1, 11}));
    }
}
