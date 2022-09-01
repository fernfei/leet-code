package depth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 深度优先算法练习题
 * create by hufei on 2022-08-24 14:44
 */
public class Solution {

    public static void main(String[] args) {
        // 二叉树中序遍历
        List<Integer> inorderTraversal = inorderTraversal(
                new TreeNode(
                        2,
                        new TreeNode(3, new TreeNode(1), null),
                        null)
        );

        // 判断两个二叉树是否相等
        boolean sameTree = isSameTree(new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));

        isBalanced(new TreeNode(1, new TreeNode(2,new TreeNode(3),null), new TreeNode(2)));
    }

    /**
     * 二叉树的中序遍历
     *
     * @param root 二叉树
     * @return 结果
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            res.add(pop.val);
            root = pop.right;
        }
        return res;
    }

    /**
     * 二叉树的中序遍历
     *
     * @param root 二叉树
     * @return 结果
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    public static void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);

    }

    /**
     * 判断两个二叉树是否一样
     *
     * @param p 二叉树p
     * @param q 二叉树q
     * @return 结果
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        //   2          2
        // 1   3     4    3
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        // 1.left,4.left
        boolean resL = isSameTree(p.left, q.left);
        // 1.right,4.right
        boolean resR = isSameTree(p.right, q.right);
        // 1.val != 4.val
        if (p.val != q.val) {
            return false;
        }
        return resL && resR;
    }

    /**
     * 判断二叉树是否是轴对称
     * @param root 二叉树
     * @return true 轴对称
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    /**
     * 判断二叉树是否是轴对称
     * @param left 左二叉树
     * @param right 右二叉树
     * @return true 轴对称
     */
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null) return false;
        if (right == null) return false;
        boolean resL = isSymmetric(left.left, right.right);
        boolean resR = isSymmetric(left.right, right.left);
        if (left.val != right.val) {
            return false;
        }
        return resL && resR;
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        boolean balancedLeft = isBalanced(root.left);
        boolean balancedRight = isBalanced(root.right);
        List<String> arr = Arrays.asList("12", "@");
        // arr转换,分隔
        String s = String.join(",", arr);
        return Math.abs(left - right) <= 1 && balancedLeft && balancedRight;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return (Math.max(left, right)) + 1;
    }
}



