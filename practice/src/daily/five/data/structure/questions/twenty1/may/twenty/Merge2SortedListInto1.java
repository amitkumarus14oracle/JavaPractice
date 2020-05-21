package daily.five.data.structure.questions.twenty1.may.twenty;

import daily.five.data.structure.questions.Node;

public class Merge2SortedListInto1 {
    public static void main(String[] args) {
        Node head1 = Node.getDefaultLinkedList();
        Node head2 = new Node(11, new Node(15, new Node(19, null)));
        Node head3 = new Node(12, new Node(13, new Node(17, new Node(20, new Node(25, new Node(34, null))))));

        Node merged1 = mergeTwoSortedList(head1, head2);
        Node merged2 = mergeTwoSortedList(head2, head3);
        System.out.println("merged1 List :");
        Node.printNodeList(merged1);
        System.out.println();
        System.out.println("merged2 List :");
        Node.printNodeList(merged2);
    }

    private static Node mergeTwoSortedList(Node head1, Node head2) {
        Node head = new Node(0);
        Node curr = head;
        while(head1 != null && head2 != null) {
            if(head1.getData() > head2.getData()) {
                curr.setNext( head2);
                head2 = head2.getNext();
            } else {
                curr.setNext(head1);
                head1 = head1.getNext();
            }
            curr = curr.getNext();
        }
        if(head1 == null) {
            curr.setNext(head2);
        } else {
            curr.setNext(head1);
        }
        return head.getNext();
    }
}
