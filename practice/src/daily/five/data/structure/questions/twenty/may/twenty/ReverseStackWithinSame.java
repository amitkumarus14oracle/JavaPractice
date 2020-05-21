package daily.five.data.structure.questions.twenty.may.twenty;

import java.util.Stack;

public class ReverseStackWithinSame {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s);
        reverseStack(s);
        System.out.println(s);
    }

    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }
        Integer top = s.pop();
        reverseStack(s);
        insertAtBottom(s, top);
    }

    private static void insertAtBottom(Stack<Integer> s, Integer data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        } else {
           int temp = s.pop();
           insertAtBottom(s, data);
           s.push(temp);
        }
    }
}
