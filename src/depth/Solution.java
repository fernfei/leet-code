package depth;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
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
}



