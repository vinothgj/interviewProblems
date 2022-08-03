package trees.binarysearchtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedArray2BinarySearch {
    TreeNode ans;

    public TreeNode sortedArrayToBST(final List<Integer> A) {
        int n = A.size();
        ans = constructTree(A, 0, n - 1);
        return ans;
    }

    TreeNode constructTree(List<Integer> arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr.get(mid));
        node.left = constructTree(arr, start, mid - 1);
        node.right = constructTree(arr, mid + 1, end);
        return node;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static void main(String arg[]) {
        SortedArray2BinarySearch sortedArray2BinarySearch = new SortedArray2BinarySearch();
        System.out.println(sortedArray2BinarySearch
                .sortedArrayToBST(new ArrayList<Integer>(Arrays.asList(1, 2, 3))));
    }
}
