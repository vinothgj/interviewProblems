package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindMaxJobs {
    static class Info {
        Integer valA , valB;
        Info(Integer a, Integer b) {
            this.valA = a;
            this.valB = b;
        }
        static Comparator<Info> infoComparator = new Comparator<Info>() {
            public int compare(Info s1, Info s2) {
                Integer valB1 = s1.valB;
                Integer valB2 = s2.valB;
                return valB1.compareTo(valB2);
            }
        };
    }

    public int solve(int[] A, int[] B) {
        int count = 0;
        List<Info> infos = new ArrayList<Info>();
        int minA = Integer.MAX_VALUE, maxB = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            minA = Math.min(minA, A[i]);
            maxB = Math.min(maxB, B[i]);
            infos.add(new Info(A[i], B[i]));
        }
        Collections.sort(infos, Info.infoComparator);

        Info prev = null;
        for (Info info : infos) {
            if (prev == null) {
                prev = info;
                count++;
            } else {
                if (info.valA >= prev.valB) {
                    prev = info;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        FindMaxJobs findMaxJobs = new FindMaxJobs();
        System.out.println(findMaxJobs.solve(new int[]{5, 7, 1, 1}, new int[]{8, 8, 8, 7}));
        System.out.println(findMaxJobs.solve(new int[]{3, 2, 6}, new int[]{9, 8, 9}));
    }
}
