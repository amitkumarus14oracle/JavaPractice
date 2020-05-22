package daily.five.data.structure.questions;

import java.util.HashSet;

public class Node {
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

    public String toString() {
        return String.valueOf(data);
    }

    public static void printNodeList(Node n) {
        while(n != null) {
            System.out.print(n + "\t");
            n = n.getNext();
        }
    }

    public static void printCircularNodeList(Node n) {
        HashSet<Integer> h = new HashSet<>();
        while(n != null) {
            if(!h.add(n.hashCode())) {
                n = null;
            } else {
                System.out.print(n + "\t");
                n = n.getNext();
            }
        }
    }
    
    public static Node getDefaultLinkedList() {
         return new Node(1,new Node(2, new Node(3, new Node(4, new Node( 5, new Node(
                6, new Node(7, new Node(8, new Node(9, null)))
        ))))));
    }
}
