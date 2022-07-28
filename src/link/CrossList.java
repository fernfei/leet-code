package link;

import java.util.HashSet;
import java.util.List;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 * <p>
 * <p>
 * <p>
 * 题目数据 保证 整个链式结构中不存在环。
 * <p>
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * <p>
 * 自定义评测：
 * <p>
 * 评测系统 的输入如下（你设计的程序 不适用 此输入）：
 * <p>
 * intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
 * listA - 第一个链表
 * listB - 第二个链表
 * skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
 * skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
 * 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author hufei
 */
public class CrossList {

    public static void main(String[] args) {
//        link.ListNode nodeA1 = new link.ListNode(9);
////        link.ListNode nodeA2 = new link.ListNode(2);
////        link.ListNode nodeA3 = new link.ListNode(3);
//        link.ListNode nodeB1 = new link.ListNode(1);
////        link.ListNode nodeB2 = new link.ListNode(2);
//        link.ListNode node8 = new link.ListNode(8);
////        nodeA1.next = node8;
////        nodeA2.next = nodeA3;
////        nodeA3.next = node8;
//        nodeB1.next = nodeA1;
//        //nodeB2.next = node8;
//
//        ListNode intersectionNode = getIntersectionNode2(nodeA1, nodeB1);
//        System.out.printf("");
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
//        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
//        node2.next = node3;
        node2.next = node4;
//        ListNode listNode = removeElements2(node1, 7);
//        ListNode listNode1 = reverseList2(node1);
//        boolean palindrome = isPalindrome(node1);
        int decimalValue = getDecimalValue(node1);
        Integer.parseInt("100", 2);
        int[] ints = reversePrint(node1);
        System.out.println();
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // A B链表长度
        ListNode tempA = headA;
        ListNode tempB = headB;
        int lenA = 0, lenB = 0;
        while (tempA != null) {
            lenA++;
            tempA = tempA.next;
        }
        while (tempB != null) {
            lenB++;
            tempB = tempB.next;
        }
        tempA = headA;
        tempB = headB;
        int diff = lenA - lenB;
        //如果是正数则表示 A大 则A减去多出的差值个数 从头开删除
        if (diff > 0) {
            while (diff > 0) {
                tempA = tempA.next;
                diff--;
            }

        }
        // 反之 同上
        if (diff < 0) {
            diff = Math.abs(diff);
            while (diff > 0) {
                tempB = tempB.next;
                diff--;
            }
        }
        // 此时元素个数相同
        if (diff == 0) {
            //只需要循环两个相同长度的AB链表 通过统一索引时的元素的地址 是否相等 如果相等则表示 两个链表指向同一个链表
            while (tempA != null && tempB != null) {
                if (tempA == tempB) {
                    return tempA;
                }
                tempA = tempA.next;
                tempB = tempB.next;
            }
        }


        return null;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        // 1 3 8
        // 1 2 3 8
        // 1 3 8 1 2 3 8
        // 1 2 3 8 1 3 8
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }

    /**
     * 删除链表指定元素
     *
     * @param head 链表
     * @param val  元素
     * @return 删除后的链表
     */
    public static ListNode removeElements(ListNode head, int val) {
        // 1 2 3 3 6
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    /**
     * 删除链表指定元素 迭代方式
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 0 7 7 7 7 === 1 3 4 5
        ListNode curNode = dummyHead;
        while (curNode.next != null) {
            if (curNode.next.val == val) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
        }
        return dummyHead.next;

    }

    /**
     * 反转链表
     *
     * @param head 链表
     * @return 结果
     */
    public static ListNode reverseList(ListNode head) {
        // 1 2 3 4 5
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        //制造成环形链表 head = 4 5 4 5 ... newHead = 5 4 5 4 5 4 ...
        head.next.next = head;
        // 因为newHead和head指向的是同一个引用地址 所以改变head就会改变newHead
        // head变成 val = 4 next =null newHead变成 val = 5 next = 4
        head.next = null;
        return newHead;
    }

    public static ListNode reverseList2(ListNode head) {
        // 1 2 3 4 5
        ListNode curNode = head;
        ListNode preNode = null;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

    public static boolean isPalindrome(ListNode head) {
        // [] || [1] 情况
        if (head == null || head.next == null) {
            return true;
        }
        // [1,2,1] [1,2,2,1]
        ListNode fast = head;
        ListNode slow = head;
        // pre = left link slow = right link
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            // 缓存当前迭代元素的下一个链表
            ListNode next = slow.next;
            fast = fast.next.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        //fast == null 说明这个链表是奇数
        if (fast != null) {
            slow = slow.next;
        }
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode middleNode(ListNode head) {
        // [1,2,3,4,5]  [1,2,3,4,5,6] 找出中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res <<= 1;
            res |= head.val;
            head = head.next;
        }
        return res;
    }

    public static int[] reversePrint(ListNode head) {
        ListNode curNode = head;
        ListNode preNode = null;
        int len = 0 ;
        // 1 3 2
        while(curNode!=null){
            ListNode nextNode = curNode.next;
            curNode.next=preNode;
            preNode = curNode;
            curNode = nextNode;
            len++;
        }
        int[]ints = new int[len];
        int index = 0;
        while(preNode!=null){
            ints[index] = preNode.val;
            preNode = preNode.next;
            index++;
        }
        return ints;
    }

}
