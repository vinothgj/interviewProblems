package trees;

import java.util.HashMap;
import java.util.Map;

public class LeftView {
    Map<Integer, Info> map = new HashMap<Integer, Info>();

    public int[] solve(TreeNode A) {
        leftViewTree(A, 0, 0);
        int[] ans = new int[map.size()];
        int k = 0;

        for (int i = 0; i < map.size(); i++) {
            int val = map.get(i).val;
            ans[k++] = val;
        }
        return ans;
    }

    void leftViewTree(TreeNode node, int dist, int level) {
        if (node == null) {
            return;
        }
        if (!map.containsKey(level)) {
            map.put(level, new Info(node.val, level));
        }
        leftViewTree(node.left, dist - 1, level + 1);
        leftViewTree(node.right, dist + 1, level + 1);
    }

    class Info {
        int val;
        int level;

        public Info(int val, int level) {
            this.val = val;
            this.level = level;
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

    public static void main(String args[]) {
        LeftView leftView = new LeftView();

        TreeNode inp1 = new TreeNode(1);
        TreeNode inp2 = new TreeNode(2);
        TreeNode inp3 = new TreeNode(3);
        inp1.left = inp2;
        inp1.right = inp3;

        TreeNode inp4 = new TreeNode(4);
        inp2.left = inp4;

        TreeNode inp5 = new TreeNode(5);
        inp2.right = inp5;

        TreeNode inp6 = new TreeNode(6);
        inp3.left = inp6;

        TreeNode inp7 = new TreeNode(7);
        inp3.right = inp7;

        TreeNode inp8 = new TreeNode(8);
        inp4.left = inp8;

        /*TopView.TreeNode inp1 = new TopView.TreeNode(1);
        TopView.TreeNode inp2 = new TopView.TreeNode(15);
        TopView.TreeNode inp3 = new TopView.TreeNode(2);
        inp1.left = inp2;
        inp1.right = inp3;*/

        System.out.println(leftView.solve(inp1));
    }
}
