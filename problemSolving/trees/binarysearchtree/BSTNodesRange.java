package trees.binarysearchtree;

public class BSTNodesRange {
    int counter;

    public int solve(TreeNode A, int B, int C) {
        counter = 0;
        if (A == null) {
            return 0;
        }
        int rootVal = A.val;

        if (B >= rootVal || A.left == null) {
            traverseTree(A.right, B, C);

        } else if (C <= rootVal || A.right == null) {
            traverseTree(A.left, B, C);

        } else {
            traverseTree(A.right, rootVal, C);
            traverseTree(A.left, B, rootVal);
        }

        if (rootVal >= B && rootVal <= C) {
            counter++;
        }
        return counter;
    }

    private void traverseTree(TreeNode root, int low, int high) {
        TreeNode current, pre;
        int currentVal = 0;
        if (root == null) {
            return;
        }
        current = root;
        while (current != null) {
            if (current.left == null) {
                currentVal = current.val;
                if (currentVal >= low && currentVal <= high) {
                    counter++;
                }
                current = current.right;
            } else {
                pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    currentVal = current.val;
                    if (currentVal >= low && currentVal <= high) {
                        counter++;
                    }
                    current = current.right;
                }
            }
        }
    }

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

    /*
            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8

     */

    public static void main(String args[]) {
        BSTNodesRange bstNodesRange = new BSTNodesRange();
        TreeNode inp15 = new TreeNode(15);
        inp15.left = new TreeNode(12);
        inp15.right = new TreeNode(20);

        inp15.left.left = new TreeNode(10);
        inp15.left.right = new TreeNode(14);

        inp15.right.left = new TreeNode(16);
        inp15.right.right = new TreeNode(27);

        inp15.left.left.left = new TreeNode(8);

        System.out.println(bstNodesRange.solve(inp15, 12, 20));

        /*
            8
           / \
          6  21
         / \
        1   4
         */

        TreeNode inp8 = new TreeNode(8);
        inp8.left = new TreeNode(6);
        inp8.right = new TreeNode(21);
        inp8.left.left = new TreeNode(1);
        inp8.left.right = new TreeNode(4);

        System.out.println(bstNodesRange.solve(inp8, 2, 20));

        TreeNode inp_15 = new TreeNode(15);
        inp_15.left = new TreeNode(10);

        System.out.println(bstNodesRange.solve(inp_15, 6, 38));

    }
}
