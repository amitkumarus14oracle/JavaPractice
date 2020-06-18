package daily.five.data.structure.questions.eighteen.june.twenty;

import java.util.EmptyStackException;

public class StackUsingArray {

    private static final int DEFAULT_CAPACITY = 12;
    private int[] arr;
    private int top;
    private int capacity;

    public StackUsingArray() {
        this(DEFAULT_CAPACITY);
    }

    public StackUsingArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public void push(int elem) {
        arr[top++] = elem;
    }

    public int pop() {
        if(top > 0)
        return arr[--top];
        else throw new EmptyStackException();
    }

    public int size() {
        return top+1;
    }

    public static void main(String[] args) {
        StackUsingArray s = new StackUsingArray();
        s.push(2);
        s.push(23);
        s.push(21);
        s.push(25);
        s.push(27);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }
}
