package link;

import java.util.List;
import java.util.Objects;

/**
 * 83. 删除排序链表中的重复元素
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 *
 * @author hufei
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode next1 = new ListNode();
        ListNode next2 = new ListNode();
        ListNode next3 = new ListNode();
        ListNode next4 = new ListNode();
        head.val = 1;
        next1.val = 2;
        next2.val = 3;
        next3.val = 3;
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        ListNode listNode = deleteDuplicates(head);
        System.out.printf("");
    }

    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode curNode;
        do {
            curNode = head;
            if (curNode.next != null && curNode.val == curNode.next.val) {
                curNode.next = curNode.next.next;
            }
            curNode = head.next;
        } while (Objects.requireNonNull(curNode).next != null);
        return head;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        //先判断是否有下一个 [1]这种情况直接返回
        if (head == null || head.next == null) {
            return head;
        }
        // 1 1 1 判断下一个与当前是否重复
        if (head.val == head.next.val) {
            head.next = head.next.next;
            // 将新指向的链表再次与当前连标比较
            head = deleteDuplicates(head);
        } else {
            // 如果一开始就不重复 for example [1,2,3]
            // 直接看下一个是否重复
           head.next= deleteDuplicates(head.next);
        }

        return head;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
