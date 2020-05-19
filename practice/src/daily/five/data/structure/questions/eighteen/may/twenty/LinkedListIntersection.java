package daily.five.data.structure.questions.eighteen.may.twenty;

import java.util.Stack;

public class LinkedListIntersection {
    public static void main(String[] args) {
        Node x = null;
        Node y = null;
        Node head1 = new Node(1, y = new Node(2,
                new Node(3, x = new Node(4, new Node(5,null )))));
        Node head2 = new Node(9, new Node(8,
                new Node(7, new Node(6, y))));

        // solving using two stack
        System.out.println(intersectionPoint(head1, head2)!=null ? intersectionPoint(head1, head2).getData() : null );

    }
    public static Node intersectionPoint(Node head1, Node head2) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        Node curr = head1;
        while(curr != null) {
            s1.push(curr);
            curr = curr.getNext();
        }
        curr = head2;
        while(curr != null) {
            s2.push(curr);
            curr = curr.getNext();
        }
        Node p1 = s1.pop();
        Node p2 = s2.pop();
        Node lastMatched = null;
        while(p1 == p2) {
            lastMatched = p1;
            p1 = s1.pop();
            p2 = s2.pop();
        }
        return lastMatched;
    }
}
class Node {
    private int data;
    private Node next;

    public Node() {
    }

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
}

