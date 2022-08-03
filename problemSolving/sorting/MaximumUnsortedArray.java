package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumUnsortedArray {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int[] B = convertArrayListToIntArray(A.toArray());
        Arrays.sort(B);
        int start = -1, end = -1;
        int noOfElements = A.size();

        for (int i = 0; i < noOfElements; i++) {
            //System.out.println(A.get(i).intValue() + " " + B[i]);
            if (A.get(i).intValue() != B[i]) {
                start = i;
                break;
            }
        }

        for (int i = noOfElements - 1; i >= 0; i--) {
            if (A.get(i) != B[i]) {
                end = i;
                break;
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (start >= 0 && end <= (noOfElements - 1)) {
            arrayList.addAll(Arrays.asList(start, end));
            return arrayList;
        } else {
            arrayList.add(-1);
            return arrayList;
        }
    }

    int[] convertArrayListToIntArray(Object[] arr) {
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] = (int) arr[i];
        }
        return res;
    }

    public static void main(String arg[]) {
        MaximumUnsortedArray maximumUnsortedArray = new MaximumUnsortedArray();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.addAll(Arrays.asList(1, 3, 2, 4, 5));
        System.out.println(maximumUnsortedArray.subUnsort(arrayList));
        arrayList = new ArrayList<Integer>();
        arrayList.addAll(Arrays.asList(16, 6, 18, 17, 13, 6, 18, 16, 6, 15, 15, 18, 16, 13, 16, 16, 6, 18, 15, 15));
        System.out.println(maximumUnsortedArray.subUnsort(arrayList));
    }
}
