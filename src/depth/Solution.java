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
        List<Integer> inorderTraversal = inorderTraversal(
                new TreeNode(
                        2,
                        new TreeNode(3, new TreeNode(1), null),
                        null)
        );
    }

    /**
     * 二叉树的中序遍历
     *
     * @param root 二叉树
     * @return 结果
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.add(root);
            root = root.left;
            if (root == null) {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                root = pop.right;
            }
        }
        return res;
    }


}



