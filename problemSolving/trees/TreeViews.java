package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TreeViews {

    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    Map<Integer, Info> topMap = new HashMap<Integer, Info>();
    Map<Integer, ArrayList<Info>> verticalMap = new HashMap<Integer, ArrayList<Info>>();

    class Info {
        int val, level;

        public Info(int val, int level) {
            this.val = val;
            this.level = level;
        }
    }

    public int[] solveTopView(TreeNode A) {
        topViewTree(A, 0, 0);
        int dist = max - min + 1, k = 0;
        int[] ans = new int[dist];
        for (int i = min; i <= max; i++) {
            int val = topMap.get(i).val;
            ans[k++] = val;
        }
        return ans;
    }

    public int solveDiameterOfBinaryTree(TreeNode A) {
        if (A == null) {
            return 0;
        }
        return diameterOfTree(A).level;
    }

    Info diameterOfTree(TreeNode root) {
        if (root == null) {
            return new Info(-1, 0);
        }
        Info leftInfo = diameterOfTree(root.left);
        Info rightInfo = diameterOfTree(root.right);
        int height = 1 + Math.max(leftInfo.val, rightInfo.val);
        int diameter = Math.max(2 + leftInfo.val + rightInfo.val, Math.max(rightInfo.level, leftInfo.level));
        return new Info(height, diameter);
    }


    public ArrayList<ArrayList<Integer>> solveVerticalOrderTraversal(TreeNode A) {

        verticalOrderViewTree(A, 0, 0);
        int dist = max - min + 1;
        ArrayList<ArrayList<Integer>> ans1 = new ArrayList<ArrayList<Integer>>();
        int k = 0;

        for (int i = min; i <= max; i++) {
            ArrayList<Info> infos = verticalMap.get(i);
            Collections.sort(infos, new Comparator() {

                public int compare(Object o1, Object o2) {

                    Integer x1 = ((Info) o1).level;
                    Integer x2 = ((Info) o2).level;
                    return x1.compareTo(x2);
                }
            });
            ArrayList<Integer> ans2 = new ArrayList<Integer>(infos.stream()
                    .map(info -> info.val).collect(Collectors.toList()));
            ans1.add(ans2);
        }

        return ans1;


    }

   /* int[] solve(int[] A, int[] B) {
        int n = A.length, m = B.length, i = 0, k = 0, j = 0;
        int[] C = new int[m + n];

        while (i < n && j < m) {
            if (A[i] < B[j]) {
                C[k++] = A[i];
                i++;
            } else {
                C[k++] = B[j];
                j++;
            }
        }

        while (i < n) {
            C[k++] = A[i];
            i++;
        }

        while (j < m) {
            C[k++] = A[j];
            j++;
        }
        return C;
    }*/

    void topViewTree(TreeNode node, int dist, int level) {
        if (node == null) {
            return;
        }

        min = Math.min(min, dist);
        max = Math.max(max, dist);

        if (!topMap.containsKey(dist)) {
            topMap.put(dist, new Info(node.val, level));
        } else {
            if (topMap.get(dist).level > level) {
                topMap.put(dist, new Info(node.val, level));
            }
        }
        topViewTree(node.left, dist - 1, level + 1);
        topViewTree(node.right, dist + 1, level + 1);
    }

    int solveHeightOfTree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = solveHeightOfTree(root.left);
        int rightHeight = solveHeightOfTree(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }


    void verticalOrderViewTree(TreeNode node, int dist, int level) {
        if (node == null) {
            return;
        }

        min = Math.min(min, dist);
        max = Math.max(max, dist);

        ArrayList<Info> temp;
        if (!verticalMap.containsKey(dist)) {
            temp = new ArrayList<Info>();
        } else {
            temp = verticalMap.get(dist);
        }
        temp.add(new Info(node.val, level));
        verticalMap.put(dist, temp);

        verticalOrderViewTree(node.left, dist - 1, level + 1);
        verticalOrderViewTree(node.right, dist + 1, level + 1);

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
        TreeViews treeViews = new TreeViews();

        /*TreeNode inp1 = new TreeNode(1);
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

        TreeNode inp9 = new TreeNode(9);
        inp4.right = inp9;

        TreeNode inp10 = new TreeNode(10);
        inp7.left = inp10;

        TreeNode inp11 = new TreeNode(11);
        inp7.right = inp11;*/

        /*TreeNode inp1 = new TreeNode(1);
        TreeNode inp2 = new TreeNode(15);
        TreeNode inp3 = new TreeNode(2);
        inp1.left = inp2;
        inp1.right = inp3;*/

       /* System.out.println(treeViews.solveTopView(inp1));
        System.out.println(treeViews.solveVerticalOrderTraversal(inp1));
        System.out.println(treeViews.solveDiameterOfBinaryTree(inp1));
        System.out.println(treeViews.solveHeightOfTree(inp1));*/
    }

    //          1
    //      2       3
    //  4       5
    //          6      7
    //8     9   10        11
}
