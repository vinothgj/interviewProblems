package Searching;

public class SingleElementSortedArray {

    public int solve(int[] A) {
        return identifySingleElement(A, 0, A.length - 1);
    }

    int identifySingleElement(int[] src, int low, int high) {
        int n = src.length;
        if (src[0] != src[1]) {
            return src[0];
        }
        if (src[n - 1] != src[n - 2]) {
            return src[n - 1];
        }

        int mid = (low + high) / 2;
        if (src[mid] != src[mid - 1] && src[mid] != src[mid + 1]) {
            return src[mid];
        }
        if ((mid % 2 == 0 && src[mid + 1] == src[mid]) || (mid % 2 == 1 && src[mid - 1] == src[mid])) {
            return identifySingleElement(src, mid + 1, high);
        }
        return identifySingleElement(src, low, mid - 1);
    }

    public static void main(String args[]) {
        SingleElementSortedArray singleElementSortedArray = new SingleElementSortedArray();
        System.out.println(singleElementSortedArray.solve(new int[]{2, 2, 4, 4, 5, 9, 9, 12, 12, 15, 15}));
    }

}
