package depth;

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
    public static void dfs2(TreeNode root){
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        dfs2(root.left);
        dfs2(root.right);
        TreeNode temp =root.left;
        root.left=root.right;
        root.right=temp;
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res  = new LinkedList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        return null;
    }
}
