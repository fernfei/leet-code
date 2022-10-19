package depth;

import java.util.*;

/**
 * create by hufei on 2022-10-18 15:54
 */
public class GraphCloned {

    public static void main(String[] args) {
        // 克隆图
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);
        Node clone = cloneGraph(node1);
        System.out.println(clone);
    }

    private static HashMap<Node, Node> visited = new HashMap<>();

    /**
     * 克隆图-深度优先搜索
     * @param node
     * @return
     */
    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node node1 = new Node(node.val);
        visited.put(node, node1);
        for (Node neighbor : node.neighbors) {
            Node visitedNode = visited.get(neighbor);
            if (visitedNode == null) {
                node1.neighbors.add(cloneGraph(neighbor));
            } else {
                node1.neighbors.add(visitedNode);
            }
        }
        return node1;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
