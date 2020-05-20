package daily.five.data.structure.questions.nighteen.may.twenty;

import daily.five.data.structure.questions.Node;

import java.util.EmptyStackException;

public class StackImplUsingLinkedList {
    private Node top;
    private int length;

    public StackImplUsingLinkedList() {
        this.length = 0;
    }


    public void push(int elem) {
        if(top == null) {
            top = new Node(elem);
        } else {
            Node temp = new Node(elem);
            temp.setNext(top);
            top = temp;
        }
        length++;
    }

    public int pop() {
        if(length == 0) {
            throw new EmptyStackException();
        }
        Node result =  top;
        top = top.getNext();
        length--;
        result.setNext(null);
        return result.getData();
    }

    public int peek() {
        if(length == 0) {
            throw new EmptyStackException();
        }
        return top.getData();
    }

    public int size() {
        return length;
    }

    public static void main(String[] args) {
        StackImplUsingLinkedList s = new StackImplUsingLinkedList();
        s.push(4);
        s.push(2);
        s.push(6);
        s.push(8);
        s.push(9);
        s.push(1);
        System.out.println(s.length);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.length);
        System.out.println(s.pop());
    }

}
