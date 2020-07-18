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
public class TwoLinkedListSummation {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*String s1 = "",s2 = "";
        while(l1 != null || l2 != null) {
            if(l1 != null ) {
                s1 = l1.val + s1;
                l1 = l1.next;
            }
            if(l2 != null ) {
                s2 = l2.val + s2;
                l2 = l2.next;
            }
        }
        long i1 = Long.parseLong(s1);
        long i2 = Long.parseLong(s2);

        Long sum = i1+i2;
        String s3 = sum.toString();
        int i = 0;
        ListNode head = null;
        while(i < s3.length()) {
            ListNode n = new ListNode(Character.getNumericValue(s3.charAt(i)));
            if(head == null) {
                head = n;
            } else {
                n.next = head;
                head = n;
            }
            i++;
        }
        return head;*/

        int tensDigit = 0;
        ListNode head = null;
        ListNode prev = null;
        while(l1 != null || l2 != null) {
            ListNode n = new ListNode();
            if(l1 != null && l2 != null) {
                int value = l1.val + l2.val+ tensDigit;
                tensDigit = value/10;
                int resultValue = value%10;
                n.val = resultValue;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l2 == null ) {
                int value = l1.val + tensDigit;
                tensDigit = value/10;
                int resultValue = value%10;
                n.val = resultValue;
                l1 = l1.next;
            } else {
                int value = l2.val + tensDigit;
                tensDigit = value/10;
                int resultValue = value%10;
                n.val = resultValue;
                l2 = l2.next;
            }

            if(head == null) {
                head = n;
            } else {
                prev.next = n;
            }
            prev = n;
        }
        if(tensDigit != 0) {
            prev.next = new ListNode(tensDigit);
        }
        return head;

    }
}