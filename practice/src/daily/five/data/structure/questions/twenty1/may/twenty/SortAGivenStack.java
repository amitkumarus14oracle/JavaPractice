package daily.five.data.structure.questions.twenty1.may.twenty;

import java.util.Stack;

public class SortAGivenStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(6);
        s.push(5);
        s.push(8);
        s.push(9);
        s.push(2);
        s.push(1);
        s.push(7);
        s.push(11);
        s.push(6);
        System.out.println(s);
        s = sortStack(s);
        System.out.println(s);

    }

    private static Stack<Integer> sortStack(Stack<Integer> s) {
        Stack<Integer> res = new Stack<>();
        while(!s.isEmpty()) {
            int value = s.pop();
            while(!res.isEmpty() && value < res.peek()) {
                s.push(res.pop());
            }
            res.push(value);
        }
        return res;
    }
}
