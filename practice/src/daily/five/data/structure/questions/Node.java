package daily.five.data.structure.questions;

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
}
