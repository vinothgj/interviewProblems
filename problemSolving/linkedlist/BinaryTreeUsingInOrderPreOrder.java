package linkedlist;

public class BinaryTreeUsingInOrderPreOrder {
    public TreeNode buildTree(int[] po, int[] io) {
        if (io.length == 0 || po.length == 0) {
            return null;
        }
        int rootVal = po[0];
        int rootIndex = findIndexOf(io, rootVal);

        int[] leftNode = generateSubArray(io, 0, rootIndex - 1);
        int[] rightNode = generateSubArray(io, rootIndex + 1, io.length - 1);

        int m = leftNode.length;
        int n = rightNode.length;

        TreeNode root = new TreeNode(rootVal);
        int[] po_part_1 = generateSubArray(po, 1, m);
        int[] po_part_2 = generateSubArray(po, m + 1, po.length - 1);
        root.left = buildTree(po_part_1, leftNode);
        root.right = buildTree(po_part_2, rightNode);

        return root;

    }

    int findIndexOf(int[] arr, int rootVal) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == rootVal) {
                return i;
            }
        }
        return -1;
    }

    int[] generateSubArray(int[] arr, int start, int end) {
        int[] leftArray = new int[end - start + 1];
        int j = 0;
        for (int i = start; i <= end; i++) {
            leftArray[j] = arr[i];
            j++;
        }
        return leftArray;
    }

    int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int heightR = heightOfTree(root.right);
        int heightL = heightOfTree(root.left);

        return Math.max(heightL, heightR) + 1;
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
        BinaryTreeUsingInOrderPreOrder binaryTreeUsingInOrderPreOrder = new BinaryTreeUsingInOrderPreOrder();
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{2, 1, 3};
        //System.out.println(binaryTreeUsingInOrderPreOrder.buildTree(a, b));

        int[] c = new int[]{1, 6, 2, 3};
        int[] d = new int[]{6, 1, 3, 2};
        System.out.println(binaryTreeUsingInOrderPreOrder.buildTree(c, d));
    }
}
