package sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedArray {
    public ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int n = A.size(), m = B.size();
        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < n && ptr2 < m) {
            if (A.get(ptr1) < B.get(ptr2)) {
                result.add(A.get(ptr1));
                ptr1++;
            } else {
                result.add(B.get(ptr2));
                ptr2++;
            }
        }

        while (ptr1 < n) {
            result.add(A.get(ptr1));
            ptr1++;
        }

        while (ptr2 < m) {
            result.add(B.get(ptr2));
            ptr2++;
        }

        return result;
    }

    public static void main(String arg[]) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        List<Integer> lst1 = new ArrayList<>();
        lst1.add(4);
        lst1.add(7);
        lst1.add(9);

        List<Integer> lst2 = new ArrayList<>();
        lst2.add(2);
        lst2.add(11);
        lst2.add(19);

        System.out.println(mergeSortedArray.solve(lst1, lst2));
    }
}
