package trees.binarysearchtree;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextPointerBT {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public TreeLinkNode connect(TreeLinkNode root) {
        TreeLinkNode head = root;
        breadthFirstSearch(head);
        return root;
    }

    public void breadthFirstSearch(TreeLinkNode A) {
        TreeLinkNode root = A;
        if (root == null) {
            return;
        }
        Deque<TreeLinkNode> queue = new ArrayDeque<TreeLinkNode>();
        queue.push(root);
        int level_size = 1;

        while (!queue.isEmpty()) {
            TreeLinkNode prev = null;
            for (int i = 0; i < level_size; i++) {
                TreeLinkNode curr = queue.peekFirst();
                if (curr.left != null) {
                    queue.add(curr.left);
                    if (prev == null) {
                        prev = curr.left;
                    } else {
                        prev.next = curr.left;
                        prev = prev.next;
                    }
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                    if (prev == null) {
                        prev = curr.right;
                    } else {
                        prev.next = curr.right;
                        prev = prev.next;
                    }
                }
                queue.pollFirst();
            }
            level_size = queue.size();
        }
    }

    public static void main(String arg[]) {
        NextPointerBT nextPointerBT = new NextPointerBT();
        TreeLinkNode inp1 = new TreeLinkNode(3);
        inp1.left = new TreeLinkNode(9);
        inp1.right = new TreeLinkNode(20);

        inp1.left.left = new TreeLinkNode(10);
        inp1.left.right = new TreeLinkNode(11);

        inp1.right.left = new TreeLinkNode(15);
        inp1.right.right = new TreeLinkNode(7);

        inp1.right.left.left = new TreeLinkNode(12);
        inp1.right.right.right = new TreeLinkNode(14);
        System.out.println(nextPointerBT.connect(inp1));
    }
}
