package trees.binarysearchtree;

import java.util.ArrayList;
import java.util.Collections;

public class RecoverBinarySearchTree {
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

    int prev = -1, first = -1, middle = -1, last = -1;

    public ArrayList<Integer> recoverTree(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        mTraversalInOrder(A);
        ans.add(first);
        if (last != -1) {
            ans.add(last);
        } else {
            ans.add(middle);
        }

        Collections.sort(ans);
        return ans;

    }

    void mTraversalInOrder(TreeNode root) {
        TreeNode current, pre;

        if (root == null) {
            return;
        }

        current = root;
        while (current != null) {
            if (current.left == null) {
                if (prev != -1) {
                    if (prev > current.val) {
                        if (first == -1) {
                            first = prev;
                            middle = current.val;
                        } else {
                            last = current.val;
                        }
                    }
                }
                prev = current.val;
                current = current.right;
            } else {
                pre = current.left;
                while (pre.right != null
                        && pre.right != current) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    if (prev != -1) {
                        if (prev > current.val) {
                            if (first == -1) {
                                first = prev;
                                middle = current.val;
                            } else {
                                last = current.val;
                            }
                        }
                    }
                    prev = current.val;
                    current = current.right;
                }
            }
        }
    }

    public static void main(String args[]) {
        RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
        TreeNode inp = new TreeNode(5);
        inp.left = new TreeNode(3);
        inp.right = new TreeNode(8);

        inp.left.left = new TreeNode(1);
        inp.left.right = new TreeNode(10);

        inp.right.left = new TreeNode(7);
        inp.right.right = new TreeNode(4);

        System.out.println(recoverBinarySearchTree.recoverTree(inp));
    }

}
