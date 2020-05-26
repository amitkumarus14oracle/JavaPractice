package daily.five.data.structure.questions.twenty6.may.twenty;

import daily.five.data.structure.questions.Node;

public class ReverseKNodeRecursive {
    public static void main(String[] args) {
        Node head = Node.getDefaultLinkedList();
        int k=3;
        Node.printCircularNodeList(head);
        head = kNodeReversalSuccessively(head, k);
        Node.printCircularNodeList(head);
    }

    private static Node kNodeReversalSuccessively(Node head, int k) {
        Node current = head;
        Node prev = null;
        Node next = null;

        int count = k;
        while(current != null && count-- > 0) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        if(current != null)
        head.setNext(kNodeReversalSuccessively(current, k));
        return prev;
    }
}
