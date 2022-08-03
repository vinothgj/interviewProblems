package trees.binarysearchtree;

import java.util.ArrayList;

public class KthSmallestElement {

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

    public int kthsmallest(TreeNode A, int B) {
        ArrayList<Integer> res = traverseTree(A);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i) + " ");
        }
        return res.get(B - 1);
    }

    private ArrayList<Integer> traverseTree(TreeNode root) {
        TreeNode current, pre;
        int currentVal = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (root == null) {
            return null;
        }
        current = root;
        while (current != null) {
            if (current.left == null) {
                currentVal = current.val;
                arr.add(currentVal);
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
                    arr.add(currentVal);
                    current = current.right;
                }
            }
        }
        return arr;
    }

    public static void main(String args[]) {
        KthSmallestElement kthSmallestElement = new KthSmallestElement();
        TreeNode inp2 = new TreeNode(2);
        inp2.left = new TreeNode(1);
        inp2.right = new TreeNode(3);

        System.out.println(kthSmallestElement.kthsmallest(inp2, 2));

        TreeNode inp15 = new TreeNode(15);
        inp15.left = new TreeNode(12);
        inp15.right = new TreeNode(20);

        inp15.left.left = new TreeNode(10);
        inp15.left.right = new TreeNode(14);

        inp15.right.left = new TreeNode(16);
        inp15.right.right = new TreeNode(27);

        inp15.left.left.left = new TreeNode(8);

        System.out.println(kthSmallestElement.kthsmallest(inp15, 5));
    }
}
