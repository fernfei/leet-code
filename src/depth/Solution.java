package depth;

import java.util.*;

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

        isBalanced(new TreeNode(1, new TreeNode(2, new TreeNode(3), null), new TreeNode(2)));

        postorderTraversal3(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)));

        isSymmetric2(new TreeNode(1, new TreeNode(2), new TreeNode(2)));

        recoverTree(new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null));
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
     * 判断二叉树是否是轴对称 - 迭代
     *
     * @param root 二叉树
     * @return true 轴对称
     */
    public static boolean isSymmetric2(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.removeFirst();
            TreeNode right = queue.removeFirst();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }


    /**
     * 判断二叉树是否是轴对称 - 递归
     *
     * @param root 二叉树
     * @return true 轴对称
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }


    /**
     * 判断二叉树是否是轴对称
     *
     * @param left  左二叉树
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

    /**
     * 路径总和-根节点到叶子节点总和==目标值
     *
     * @param root      二叉树
     * @param targetSum 目标值
     * @return 是否存在结果
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        //      1
        //  2       3
        // 4           5
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                res.add(root.val);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            root = pop.right;
        }
        return res;
    }

    /**
     * 后序遍历
     *
     * @param root 二叉树
     * @return 结果
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }


    public static List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * 后序遍历-迭代
     *
     * @param root 二叉树
     * @return res 后序遍历结果
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        //  1
        //      2
        //3
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode preNode = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == preNode) {
                preNode = root;
                res.add(preNode.val);
                root = null;
            } else {
                root = root.right;
                stack.push(root);
            }

        }
        return res;
    }

    /**
     * 后序遍历-递归
     *
     * @param root 二叉树
     * @param res  后序遍历结果
     */
    public void postorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, res);
        postorderTraversal(root.right, res);
        res.add(root.val);
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        long preVal = Long.MIN_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pop.val <= preVal) {
                return false;
            }
            root = pop.right;
            preVal = pop.val;
        }
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    public boolean isValidBST(TreeNode root, int lower, int upper) {
        if (root == null) {
            return true;
        }
        // 3 > +inf || 3 < 2
        if (root.val >= upper || root.val <= lower) {
            return false;
        }
        // 2 1 3
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

    /**
     * 恢复搜索二叉树
     * @param root 二叉树
     */
    public static void recoverTree(TreeNode root) {
        // 中序遍历 4 2 3 1     1 4 2
        // 中序遍历 1 2 3 4     1 2 4
        Stack<TreeNode> stack = new Stack<>();
        TreeNode f = null, s = null, pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {

                stack.push(root);
                root = root.left;
            }
            // 1 2 3 4 9 7 8 6 10
            TreeNode pop = stack.pop();
            if (pre != null && pre.val > pop.val) {
                if (f == null) {
                    f = pre;
                }
                s = pop;
            }
            pre = pop;
            root = pop.right;
        }
        if (f != null && s != null) {
            // f = 1 s = 2
            f.val ^= s.val;
            s.val ^= f.val;
            f.val ^= s.val;

        }
    }

}



