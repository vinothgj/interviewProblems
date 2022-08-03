package twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class ClosestPair {

    int diff = Integer.MAX_VALUE;
    ArrayList<Integer> pair = new ArrayList<Integer>();

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int len = A.size() + B.size() - 1;
        return identifyPair(mergeSortedArrays(A, B), 0, len, C, A, B);
        //return mergeSortedArrays(A, B);
    }

    ArrayList<Integer> mergeSortedArrays(ArrayList<Integer> x, ArrayList<Integer> y) {
        int ptr1 = 0, ptr2 = 0;
        ArrayList<Integer> sortedArr = new ArrayList<Integer>();

        while (ptr1 < x.size() && ptr2 < y.size()) {
            if (x.get(ptr1) < y.get(ptr2)) {
                sortedArr.add(x.get(ptr1));
                ptr1++;
            } else {
                sortedArr.add(y.get(ptr2));
                ptr2++;
            }
        }

        if (ptr1 <= x.size() - 1) {
            for (int i = ptr1; i < x.size(); i++) {
                sortedArr.add(x.get(i));
            }
        } else if (ptr2 <= y.size() - 1) {
            for (int i = ptr2; i < y.size(); i++) {
                sortedArr.add(y.get(i));
            }
        }
        System.out.println("Sorted Array : " + sortedArr);
        return sortedArr;
    }

    ArrayList<Integer> identifyPair(ArrayList<Integer> src, int start, int end, int sum, ArrayList<Integer> a, ArrayList<Integer> b) {
        while (start <= end) {
            int p1 = src.get(start);
            int p2 = src.get(end);
            int absMin = Math.abs((p1 + p2) - sum);
            if (!(a.contains(p1) && a.contains(p2)) && !(b.contains(p1) && b.contains(p2))) {
                if (absMin < diff) {
                    diff = absMin;
                    pair = new ArrayList<Integer>();
                    if (a.contains(p1)) {
                        pair.add(p1);
                        pair.add(p2);
                    } else {
                        pair.add(p2);
                        pair.add(p1);
                    }

                    if ((p1 + p2) == sum) {
                        return pair;
                    }

                }
            }



            if ((p1 + p2) > sum) {
                end--;
            } else {
                start++;
            }
        }
        //System.out.println("Pair : " + pair);
        return pair;
    }

    public static void main(String args[]) {
        ClosestPair closestPair = new ClosestPair();
        /*ArrayList<Integer> inp1 = new ArrayList<Integer>();
        inp1.addAll(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> inp2 = new ArrayList<Integer>();
        inp2.addAll(Arrays.asList(2, 4, 6, 8));
        System.out.println(closestPair.solve(inp1, inp2, 9));*/

        /*ArrayList<Integer> inp1 = new ArrayList<Integer>();
        ArrayList<Integer> inp2 = new ArrayList<Integer>();
        inp1 = new ArrayList<Integer>();
        inp1.addAll(Arrays.asList(5, 10, 20));
        inp2 = new ArrayList<Integer>();
        inp2.addAll(Arrays.asList(1, 2, 30));
        System.out.println(closestPair.solve(inp1, inp2, 13));*/

        ArrayList<Integer> inp1 = new ArrayList<Integer>();
        ArrayList<Integer> inp2 = new ArrayList<Integer>();
        inp1.addAll(Arrays.asList(6, 7, 9, 13, 21, 29, 56, 74, 77, 83, 84, 88, 93, 96, 101, 104, 114, 115, 122, 125, 144, 147, 151, 152, 154, 161, 165, 167, 174, 179, 185, 189, 192, 194, 198, 201, 203, 208, 224, 229, 230, 238, 252, 253, 257, 264, 266, 275, 278, 279, 282, 284, 291, 312, 316, 322, 332, 335, 336, 339, 364, 380, 381, 384, 387, 388, 390, 392, 394, 395, 401, 403, 431, 432, 440, 442, 443, 444, 446, 451, 454, 461, 470, 483, 492));
        inp2.addAll(Arrays.asList(2, 8, 13, 16, 19, 21, 22, 23, 37, 48, 63, 66, 68, 71, 72, 95, 102, 116, 123, 127, 131, 132, 146, 148, 153, 171, 173, 179, 187, 194, 215, 220, 227, 229, 240, 245, 254, 255, 257, 259, 271, 276, 277, 286, 296, 312, 314, 318, 321, 333, 339, 341, 343, 355, 356, 359, 363, 364, 380, 390, 393, 398, 401, 409, 413, 417, 427, 442, 444, 446, 454, 455, 459, 460, 468, 471, 473, 475, 476, 478, 479, 482, 483, 488, 489));
        //System.out.println(inp1.get(6) + " " + inp2.get(403));
        System.out.println(closestPair.solve(inp1, inp2, 409));
        //System.out.println(inp1.get(29) + " " + inp2.get(380));

        /*ArrayList<Integer> inp1 = new ArrayList<Integer>();
        inp1.addAll(Arrays.asList(1));
        ArrayList<Integer> inp2 = new ArrayList<Integer>();
        inp2.addAll(Arrays.asList(2, 4));
        System.out.println(closestPair.solve(inp1, inp2, 4));*/

        /*ArrayList<Integer> inp1 = new ArrayList<Integer>();
        inp1.addAll(Arrays.asList(1, 3, 5, 7, 9));
        ArrayList<Integer> inp2 = new ArrayList<Integer>();
        inp2.addAll(Arrays.asList(2, 4, 6, 8, 10));
        System.out.println(closestPair.solve(inp1, inp2, 10));*/
    }
}

