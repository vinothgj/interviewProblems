package stackandqueue;

public class LargestRectangle {
    public int largestRectangleArea(int[] A) {
        if (A.length == 0) {
            return 0;
        } else if (A.length == 1) {
            return A[0];
        }

        int height = 0, max_area = Integer.MIN_VALUE;
        int index = 0, left = 0, right = 0;


        // Values   : 2, 1, 5, 6, 2, 3
        // Indexes  : 0, 1, 2, 3, 4, 5
        for (int x = index; x < A.length; x++) {
            right = x;
            left = x;
            height = A[x];

            while (left >= 0 && A[left] >= height) {
                left--;
            }

            while (right < A.length && A[right] >= height) {
                right++;
            }
            max_area = Math.max(max_area, (right - left - 1) * height);
        }

        return max_area;

    }

    public static void main(String arg[]) {
        LargestRectangle largestRectangle = new LargestRectangle();
        System.out.println(largestRectangle.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3})); // 10
        System.out.println(largestRectangle.largestRectangleArea(new int[]{10, 6, 4, 8, 5, 9, 3})); //24
        System.out.println(largestRectangle.largestRectangleArea(new int[]{3}));
        System.out.println(largestRectangle.largestRectangleArea(new int[]{3, 5, 7, 3})); // 12
    }
}
