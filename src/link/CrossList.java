package link;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 * 自定义评测：
 *
 * 评测系统 的输入如下（你设计的程序 不适用 此输入）：
 *
 * intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
 * listA - 第一个链表
 * listB - 第二个链表
 * skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
 * skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
 * 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
 *
 *  
 *
 * 示例 1：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author hufei
 */
public class CrossList {

    public static void main(String[] args) {
        link.ListNode nodeA1 = new link.ListNode(9);
//        link.ListNode nodeA2 = new link.ListNode(2);
//        link.ListNode nodeA3 = new link.ListNode(3);
        link.ListNode nodeB1 = new link.ListNode(1);
//        link.ListNode nodeB2 = new link.ListNode(2);
        link.ListNode node8 = new link.ListNode(8);
//        nodeA1.next = node8;
//        nodeA2.next = nodeA3;
//        nodeA3.next = node8;
        nodeB1.next = nodeA1;
        //nodeB2.next = node8;

        ListNode intersectionNode = getIntersectionNode2(nodeA1, nodeB1);
        System.out.printf("");
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
        while (tempA !=tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }
}
