package sorting;

public class KthSmallestElement {

    public int kthsmallest(final int[] A, int B) {
        int[] res = A;
        int n = A.length, k = 0, minVal = Integer.MAX_VALUE, index = 0, temp = 0;
        while (k < n) {
            for (int i = k; i < n; i++) {
                int val = res[i];
                if (minVal > val) {
                    minVal = val;
                    index = i;
                }
            }
            temp = res[k];
            res[k] = minVal;
            res[index] = temp;
            k++;
            minVal = Integer.MAX_VALUE;
        }
        return res[B - 1];
    }

    public static void main(String arg[]) {
        KthSmallestElement kthSmallestElement = new KthSmallestElement();
        //List<Integer> inp = Arrays.asList(8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92);
        /*inp.add(8);
        inp.add(4);
        inp.add(3);
        inp.add(9);
        inp.add(10);*/
        //List<Integer> inp = Arrays.asList(44, 69, 63, 90, 69, 83, 48, 87, 99, 63, 45, 26, 82, 35, 37, 4, 97, 29, 91);
        //List<Integer> inp = Arrays.asList(74, 90, 85, 58, 69, 77, 90, 85, 18, 36);
        //List<Integer> inp = Arrays.asList(43, 31, 68, 21, 25, 4, 36, 76, 6, 25, 7);
        int[] inp = new int[]{43, 31, 68, 21, 25, 4, 36, 76, 6, 25, 7};

        System.out.println(kthSmallestElement.kthsmallest(inp, 3));
        //Collections.sort(inp);
        //System.out.println(inp);
    }

}
