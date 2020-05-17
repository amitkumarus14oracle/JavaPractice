package daily.five.data.structure.questions.seventeen.may.twenty;

import java.util.EmptyStackException;

public class StackArrayImpl {
    private int top;
    private int capacity;
    private int[] stackArray;

    public StackArrayImpl(int capacity) {
        this.top = -1;
        this.capacity = capacity;
        this.stackArray = new int[capacity];
    }

    public void push(int elem) {
        if(top == capacity) {
            throw new StackFullException("No more Push, stack is full");
        }
        stackArray[++top] = elem;
    }

    public int pop() {
        if(top == -1) {
            throw new StackEmptyException("stack is empty");
        }
        int result = stackArray[top];
        stackArray[top--] = Integer.MIN_VALUE;
        return result;
    }

    public int peek() {
        return stackArray[top];
    }

    public static void main(String[] args) {
        StackArrayImpl stack = new StackArrayImpl(16);
        //stack.pop();
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }
}
