package daily.five.data.structure.questions;

import java.util.Stack;

public class TestMorgan {
    Stack<Integer> maxStack = new Stack<>();
    Stack<Integer> mainStack = new Stack<>();
    public static void main(String[] args) {
        TestMorgan s = new TestMorgan();
        System.out.println((char[])null);
        s.push(2);
        s.push(3);
        s.push(10);
        s.pop();
        s.push(5);
        s.push(9);
        System.out.println(s.maxValue());

    }

    public void push(int s) {
        mainStack.push(s);
        if(maxStack.isEmpty() || maxStack.peek() < s) {
            maxStack.push(s);
        }
    }

    public int pop() {
        int elem = mainStack.pop();
        if(!maxStack.isEmpty() && elem == maxStack.peek()) {
            maxStack.pop();
        }
        return elem;
    }

    public int maxValue() {
        return maxStack.peek();
    }
}
