package Searching;

public class RotatedSearchArray {
    public int search(final int[] A, int B) {
        return identifyTargetIndex(A, B, 0, A.length - 1);
    }

    int identifyTargetIndex(int[] A, int B, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + ((high - low) / 2);
        if (A[mid] == B) {
            return mid;
        }

        if (A[low] <= A[mid]) {
            if (A[low] <= B && B <= A[mid]) {
                return identifyTargetIndex(A, B, low, mid - 1);
            }
            return identifyTargetIndex(A, B, mid + 1, high);
        }
        if (A[mid] <= B && B <= A[high]) {
            return identifyTargetIndex(A, B, mid + 1, high);
        }
        return identifyTargetIndex(A, B, low, mid - 1);
    }

    public static void main(String arg[]) {
        RotatedSearchArray rotatedSearchArray = new RotatedSearchArray();
        System.out.println(rotatedSearchArray.search(new int[]{4, 5, 6, 7, 0, 1, 2, 3}, 5));
        System.out.println(rotatedSearchArray.search(new int[]{7, 8, 0, 1, 2, 3, 4, 5, 6}, 5));
        System.out.println(rotatedSearchArray.search(new int[]{19, 20, 21, 22, 28, 29, 32, 36, 39, 40, 41, 42, 43, 45, 48, 49, 51, 54, 55, 56, 58, 60, 61, 62, 65, 67, 69, 71, 72, 74, 75, 78, 81, 84, 85, 87, 89, 92, 94, 95, 96, 97, 98, 99, 100, 105, 107, 108, 109, 110, 112, 113, 115, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 128, 130, 131, 133, 134, 135, 136, 137, 138, 139, 141, 142, 144, 146, 147, 148, 149, 150, 153, 155, 157, 159, 161, 163, 164, 169, 170, 175, 176, 179, 180, 185, 187, 188, 189, 192, 196, 199, 201, 203, 205, 3, 7, 9, 10, 12, 13, 17}, 6));
    }

}
