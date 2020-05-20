package daily.five.data.structure.questions.nighteen.may.twenty;

import daily.five.data.structure.questions.Node;

public class LinkedListPairWiseReversal {
    public static void main(String[] args) {
        Node head = Node.getDefaultLinkedList();
        head = pairWiseReversal(head);
        while (head != null) {
            System.out.println(head.getData());
            head = head.getNext();
        }

    }

    public static Node pairWiseReversal(Node head) {
        Node temp1 = null, temp2 = null;
        while(head != null && head.getNext() != null) {
            if(temp1 != null) {
                temp1.getNext().setNext(head.getNext());
            }
            temp1 = head.getNext();
            Node temp = temp1.getNext();
            temp1.setNext(head);
            head.setNext(temp);
            if(temp2 == null) {
                temp2 = temp1;
            }
            head = temp;
        }
        return temp2;
    }
}
