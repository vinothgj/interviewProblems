package Searching;

public class SearchForRange {
    int start = -1, end = -1;

    public int[] searchRange(final int[] A, int B) {
        start = -1;
        end = -1;
        start = identifyStartIndex(A, B, 0, A.length - 1);
        end = identifyEndIndex(A, B, 0, A.length - 1);
        System.out.println(start + " " + end);
        return new int[]{start, end};
    }

    int identifyEndIndex(int[] A, int target, int low, int high) {
        if (low >= high) {
            if (A[low] == target) {
                end = low;
            }
            return end;
        }

        int mid = (low + high) / 2;
        if (A[mid] < target) {
            return identifyEndIndex(A, target, mid + 1, high);
        } else if (A[mid] > target) {
            return identifyEndIndex(A, target, low, mid - 1);
        }
        end = mid;
        return identifyEndIndex(A, target, mid + 1, high);
    }

    int identifyStartIndex(int[] A, int target, int low, int high) {
        if (low == high) {
            if (A[low] == target) {
                start = low;
            }
            return start;
        }

        int mid = (low + high) / 2;
        if (A[mid] < target) {
            return identifyStartIndex(A, target, mid + 1, high);
        } else if (A[mid] > target) {
            return identifyStartIndex(A, target, low, mid - 1);
        }
        start = mid;
        return identifyStartIndex(A, target, low, mid);
    }

    public static void main(String arg[]) {
        SearchForRange searchForRange = new SearchForRange();
        System.out.println(searchForRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(searchForRange.searchRange(new int[]{5, 17, 100, 111}, 12));
        System.out.println(searchForRange.searchRange(new int[]{5, 12, 12, 12, 12, 12, 45, 100, 111}, 12));
    }
}
