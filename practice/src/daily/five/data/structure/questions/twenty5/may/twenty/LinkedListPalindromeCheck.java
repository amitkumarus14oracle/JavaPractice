package daily.five.data.structure.questions.twenty5.may.twenty;

import daily.five.data.structure.questions.Node;

public class LinkedListPalindromeCheck {
    public static void main(String[] args) {
        Node head = new Node(1,
                new Node(2,
                        //new Node(3,
                                new Node(2,
                                        new Node(1, null))));//);
        System.out.println(isPalindrome(head));
        Node.printNodeList(head);
    }

    private static boolean isPalindrome(Node head) {
        Node mid = findMid(head);
        Node rev = reverse(mid.getNext());
        Node temp = rev;
        while(head != null && rev != null) {
            if(head.getData() != rev.getData()) {
                return false;
            }
            head = head.getNext();
            rev = rev.getNext();
        }
        reverse(temp); // to bring it to original list
        return true;
    }

    private static Node reverse(Node node) {
        Node curr = node;
        Node prev = null;
        Node next;
        while(curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static Node findMid(Node head) {
        Node sloPtr = head;
        Node fastPtr = null;
        if(head != null && head.getNext() != null)
            fastPtr = head.getNext();
        while(fastPtr != null && fastPtr.getNext() != null) {
            sloPtr = sloPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
        }
        return sloPtr;
    }
}
