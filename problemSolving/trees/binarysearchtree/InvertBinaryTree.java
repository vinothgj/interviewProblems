package trees.binarysearchtree;

public class InvertBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public TreeNode invertTree(TreeNode A) {
        invert(A);
        return A;
    }

    void invert(TreeNode node) {
        if (node == null) {
            return;
        }

        swap(node);
        invert(node.left);
        invert(node.right);
    }

    void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public int isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }
        if (A == null || B == null) {
            return 0;
        }
        int ans = ((A.val == B.val) && (isSameTree(A.left, B.left) == 1) && (isSameTree(A.right, B.right) == 1)) ? 1 : 0;

        return ans;
    }

    public static void main(String arg[]) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode inp = new TreeNode(1);
        inp.left = new TreeNode(2);
        inp.right = new TreeNode(3);

        inp.left.left = new TreeNode(4);
        inp.left.right = new TreeNode(5);

        inp.right.left = new TreeNode(6);
        inp.right.right = new TreeNode(7);

        System.out.println(invertBinaryTree.invertTree(inp));
    }
}
