package daily.five.data.structure.questions.nighteen.may.twenty;

import daily.five.data.structure.questions.Node;

public class QueueImplUsingLinkedList {
    private int length;
    private Node front, rear;

    public void enqueue(int elem) {
        if(rear == null) {
            front = rear = new Node(elem);
        } else {
            Node temp = new Node(elem);
            rear.setNext(temp);
            rear = temp;
        }
        length++;
    }

    public int dequeue() {
        if(length == 0) {
            throw new EmptyQueueException("Queue is empty");
        }
        Node result = front;
        front = front.getNext();
        length--;
        result.setNext(null);
        return result.getData();
    }

    public int size() {
        return length;
    }

    public static void main(String[] args) {
        QueueImplUsingLinkedList q =new QueueImplUsingLinkedList();
        q.enqueue(7);
        q.enqueue(3);
        q.enqueue(9);
        q.enqueue(11);
        q.enqueue(39);
        q.enqueue(4);
        q.enqueue(74);
        System.out.println("length is :"+q.length);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println("length is :"+q.length);
        System.out.println(q.dequeue());
        System.out.println("length is :"+q.length);
        System.out.println(q.dequeue());




    }
}
