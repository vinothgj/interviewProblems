package trees;

public class SymmetricIdenticalTrees {

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

    public int isSymmetric(TreeNode A) {
        if (A == null) {
            return 1;
        }
        return isMirror(A.left, A.right) ? 1 : 0;
    }

    boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
        }
        return false;
    }

    public static void main(String[] arg) {
        SymmetricIdenticalTrees symmetricIdenticalTrees = new SymmetricIdenticalTrees();
        TreeNode inp = new TreeNode(1);
        inp.left = new TreeNode(2);
        inp.right = new TreeNode(2);

        inp.left.left = new TreeNode(3);
        inp.left.right = new TreeNode(4);

        inp.right.left = new TreeNode(4);
        inp.right.right = new TreeNode(3);

        System.out.println(symmetricIdenticalTrees.isSymmetric(inp));
    }
}
