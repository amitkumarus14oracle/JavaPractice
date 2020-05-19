package daily.five.data.structure.questions.eighteen.may.twenty;

import java.util.Stack;

public class StackGetMin {

    private Stack<Integer> elemStack = new Stack();
    private Stack<Integer> minStack = new Stack();

    public void push(int elem) {
        elemStack.push(elem);
        if(minStack.isEmpty() || (!minStack.isEmpty() && minStack.peek() > elem)) {
            minStack.push(elem);
        }
    }

    public int pop() {
        if(!elemStack.isEmpty() && elemStack.peek() == minStack.peek()) {
            minStack.pop();
        }
        return elemStack.pop();
    }

    public int getMin() {
        return minStack.peek();
    }

    public Stack getElemStack() {
        return elemStack;
    }

    public void setElemStack(Stack elemStack) {
        this.elemStack = elemStack;
    }

    public Stack getMinStack() {
        return minStack;
    }

    public void setMinStack(Stack minStack) {
        this.minStack = minStack;
    }

    public static void main(String[] args) {
        StackGetMin m = new StackGetMin();
        m.push(5);
        m.push(6);
        m.push(2);
        m.push(8);
        m.push(9);
        m.push(1);
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());

    }
}
