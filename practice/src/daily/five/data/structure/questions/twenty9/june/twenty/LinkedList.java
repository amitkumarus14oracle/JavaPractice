package daily.five.data.structure.questions.twenty9.june.twenty;

public class LinkedList {
    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.add(new Node(3));
        l.add(new Node(1));
        l.add(new Node(5));
        l.add(new Node(4));
        l.printList(l.head);
    }

    public void add(Node n) {
        if(head == null) {
            head = n;
            return;
        }
        Node temp = head;
        while(temp.getNext()!=null) {
            temp = temp.getNext();
        }
        temp.setNext(n);
    }

    public void printList(Node head) {
        while(head!= null) {
            System.out.println(head.getData());
            head = head.getNext();
        }
    }
}
class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
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
