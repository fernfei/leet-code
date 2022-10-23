package depth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * create by hufei on 2022-10-19 16:58
 */
public class ReverseNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

//        upsideDownBinaryTree(root);

        invertTree(root);

        levelOrder3(root);

    }


    static TreeNode head = null;

    public static TreeNode upsideDownBinaryTree(TreeNode root) {
        dfs(root);
        return head;
    }

    public static TreeNode dfs(TreeNode root) {
        if (root == null || root.left == null) {
            head = root;
            return root;
        }

        TreeNode left = dfs(root.left);
        left.right = root;
        left.left = root.right;
        root.left = null;
        root.right = null;
        return root;
    }


    public static TreeNode invertTree(TreeNode root) {
        bfs(root);
        return root;
    }

    public static void dfs2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        dfs2(root.left);
        dfs2(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            TreeNode temp = poll.left;
            poll.left = poll.right;
            poll.right = temp;
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        LinkedList<Integer> tire = new LinkedList<>();
        queue.add(root);
        Integer preLevel = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            Integer level = levelMap.getOrDefault(poll, 0);
            // 先判断层级是否变化，如果变化创建新的数组 并将结果存入
            if (!preLevel.equals(level)) {
                res.add(tire);
                tire = new LinkedList<>();
                preLevel = level;
            }
            tire.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
                levelMap.put(poll.left, preLevel + 1);
            }
            if (poll.right != null) {
                queue.add(poll.right);
                levelMap.put(poll.right, preLevel + 1);
            }
        }
        // 把叶子节点放入结果
        res.add(tire);
        return res;
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tire = new LinkedList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                tire.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                size--;
            }
            res.add(tire);
        }
        return res;
    }


    public static List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        dfs3(root, 0, res);
        return res;
    }

    public static void dfs3(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            List<Integer> e = new ArrayList<>();
            res.add(e);
        }
        List<Integer> integers = res.get(level);
        integers.add(root.val);
        dfs3(root.left, level+1, res);
        dfs3(root.right, level+1, res);
    }
}
