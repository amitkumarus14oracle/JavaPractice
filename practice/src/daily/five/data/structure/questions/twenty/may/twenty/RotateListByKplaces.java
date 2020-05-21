package daily.five.data.structure.questions.twenty.may.twenty;

import daily.five.data.structure.questions.Node;

public class RotateListByKplaces {
    public static void main(String[] args) {
        Node head = Node.getDefaultLinkedList();
        int k = 3;
        System.out.println("original list");
        Node.printNodeList(head);
        System.out.println();
        head =  listRotateByK(head, k);
        System.out.println("rotated list");
        Node.printNodeList(head);

    }

    private static Node listRotateByK(Node head, int k) {
        Node rotateStart = head, rotateEnd = head;
        while(k > 0) {
            rotateEnd = rotateEnd.getNext();
            if(rotateEnd == null) {// if list is of lesser size than k
                rotateEnd = head;
            }
            k--;
        }
        while(rotateEnd.getNext() != null) {
            rotateStart = rotateStart.getNext();
            rotateEnd = rotateEnd.getNext();
        }
        rotateEnd.setNext(head);
        head = rotateStart.getNext();
        rotateStart.setNext(null);
        return head;
    }
}
