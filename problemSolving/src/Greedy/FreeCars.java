package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FreeCars {

    static class Info {
        Integer valA, valB;

        Info(Integer a, Integer b) {
            this.valA = a;
            this.valB = b;
        }

        static Comparator<Info> infoComparator = new Comparator<Info>() {
            public int compare(Info s1, Info s2) {
                Integer valA1 = s1.valA;
                Integer valA2 = s2.valA;
                return valA1.compareTo(valA2);
            }
        };
    }

    public int solve(int[] A, int[] B) {
        int n = A.length, sum = 0;
        ArrayList<Info> infos = new ArrayList<Info>();
        for (int i = 0; i < n; i++) {
            infos.add(new Info(A[i], B[i]));
        }

        Collections.sort(infos, Info.infoComparator);
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        int t = 0;
        for (Info info : infos) {
            if (t < info.valA) {
                pQueue.add(info.valB);
                sum += info.valB;
                sum %= 1000000007;
                t++;
            } else {
                if (info.valB > pQueue.peek()) {
                    sum -= pQueue.poll();
                    pQueue.add(info.valB);
                    sum += info.valB;
                    sum %= 1000000007;
                }
            }
        }
        return sum;
    }

    public static void main(String arg[]) {
        FreeCars freeCars = new FreeCars();
        System.out.println(freeCars.solve(new int[]{1, 3, 2, 3, 3}, new int[]{5, 6, 1, 3, 9}));
        System.out.println(freeCars.solve(new int[]{3, 8, 7, 5}, new int[]{3, 1, 7, 19}));

    }
}
