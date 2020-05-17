package daily.five.data.structure.questions.seventeen.may.twenty;

/*
find whether list has cycle, if has, find starting point of the cycle.
 */

public class ListCycleAndStartingPoint {
    public static void main(String[] args) {

        Node head1 = new Node(1,new Node(2, new Node(3, new Node(4, new Node( 5, new Node(
                6, new Node(7, new Node(8, new Node(9, null)))
        ))))));
        Node x = null;
        Node head2 = new Node(1,new Node(2, x= new Node(3, new Node(4, new Node( 5, new Node(
                6, new Node(7, new Node(8, new Node(9, x)))// x would be null here because x is not yel initialized.
        ))))));
        Node temp = head2;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(x);
        Node ptr1 = cyclePresence(head1);
        Node ptr2 = head1;
        Node strtPoint = ptr1 != null ? getCycleStartPoint(ptr1, ptr2): null;
        if (strtPoint != null) {
            System.out.println("cycle starting point : " + strtPoint.getData());
        } else {
            System.out.println("no cycle found");
        }

        ptr1 = cyclePresence(head2);
        ptr2 = head2;
        strtPoint = ptr1 != null ? getCycleStartPoint(ptr1, ptr2): null;
        if (strtPoint != null) {
            System.out.println("cycle starting point : " + strtPoint.getData());
        } else {
            System.out.println("no cycle found");
        }

    }

    public static Node getCycleStartPoint(Node ptr1, Node ptr2) {
        while(ptr1 != ptr2) {
            ptr1 = ptr1.getNext();
            if(ptr1 == ptr2) {
                return ptr1;
            }
            ptr2 = ptr2.getNext();
        }
        return ptr1;
    }

    public static Node cyclePresence(Node head) {
        Node slowPtr = head;
        Node fastPtr = null;
        boolean found = false;
        if(head != null) {
            fastPtr = head.getNext();
        }
        while(slowPtr != fastPtr && fastPtr != null) {
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext() != null ? fastPtr.getNext().getNext() : null;
        }
        if (slowPtr == fastPtr) {
            found = true;
        }
        System.out.println("cycle found :"+ found);
        return fastPtr;
    }

}
class Node {
    private int data;
    private Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
