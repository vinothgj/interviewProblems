package trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumBinaryTree {

    int target = 0;
    int sum = 0;

    public static void main(String[] arg) {
        SumBinaryTree sumBinaryTree = new SumBinaryTree();
        TreeNode node = new TreeNode(26);
        node.left = new TreeNode(10);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(6);

        node.right = new TreeNode(3);
        node.right.right = new TreeNode(3);

        System.out.println(sumBinaryTree.solve(node));
    }

    public int solve(TreeNode A) {
        traverseTree(A);
        return (sum - target) == target ? 1 : 0;
    }

    void traverseTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return;
        }
        queue.push(root);
        target = root.val;
        sum = 0;

        while (!queue.isEmpty()) {
            TreeNode child = queue.peekFirst();
            queue.removeFirst();
            sum += child.val;

            if (child.left != null) {
                queue.push(child.left);
            }

            if (child.right != null) {
                queue.push(child.right);
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
}
