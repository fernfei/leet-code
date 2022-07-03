package link;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Salution2 {

    public static void main(String[] args) {
        link.ListNode cycleNode1 = new link.ListNode(3);
        link.ListNode cycleNode2 = new link.ListNode(2);
        link.ListNode cycleNode3 = new link.ListNode(0);
        cycleNode1.next = cycleNode2;
        cycleNode2.next = cycleNode3;

        boolean result = hasCycle(cycleNode1);
        System.out.println("结果:" + result);
    }

    /**
     * 快慢指针
     * @param head
     * @return 结果
     */
    public static boolean hasCycle(link.ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        link.ListNode slowNode = head;
        link.ListNode fastNode = head;
        while (slowNode != null && fastNode != null) {
            // 1 2 3 4 5
            if (fastNode.next == null) {
                return false;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                return true;
            }

        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}

