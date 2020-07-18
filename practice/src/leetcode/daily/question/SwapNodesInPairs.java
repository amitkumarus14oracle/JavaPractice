package leetcode.daily.question;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode temp1 = null;
        ListNode temp2 = null;
        ListNode curr = head;
        ListNode next = null;
        if(head == null || head.next == null) {
            return head;
        }
        while(curr != null && curr.next!=null) {
            if(temp1 != null) {
                temp1.next.next = curr.next;
            }
            next = curr.next;
            curr.next = next.next;
            next.next = curr;
            temp1 = next;
            curr = curr.next;
            if(temp2 == null) {
                temp2 = temp1;
            }
        }

        if(curr != null) {
            temp1.next.next = curr;
        }
        return temp2;

    }
}