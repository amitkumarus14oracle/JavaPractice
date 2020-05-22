package daily.five.data.structure.questions.twenty2.may.twenty;

import daily.five.data.structure.questions.Node;

public class SplitCircularLinkedListInto2 {
    public static void main(String[] args) {
        Node head = Node.getDefaultLinkedList();
        Node curr = head;
        while(curr.getNext() != null) {
            curr =curr.getNext();
        }
        curr.setNext(head);
        Node head1 = null, head2 = null;
        Node[] split = splitIntoTwo(head, head1, head2);
        System.out.println();
        Node.printCircularNodeList(split[0]);
        System.out.println();
        Node.printCircularNodeList(split[1]);
    }

    private static Node[] splitIntoTwo(Node head, Node head1, Node head2) {
        Node slowPtr = head, fastPtr = head;
        while(fastPtr.getNext() != head && fastPtr.getNext().getNext() != head) {
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
        }
        head2 = slowPtr.getNext();
        slowPtr.setNext(head);

        if(fastPtr.getNext() == head) {
            fastPtr.setNext(head2);
        } else {
            fastPtr.getNext().setNext(head2);
        }
        head1 = head;
        return new Node[]{head1, head2};
    }
}
