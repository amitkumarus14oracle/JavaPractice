package daily.five.data.structure.questions.twenty6.may.twenty;

import java.util.Stack;

public class DeleteMiddleElementOfStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        System.out.println(s);
        deleteMid(s, s.size(), 0);
        System.out.println(s);
    }

    private static void deleteMid(Stack<Integer> s, int size, int count) {
        if(count == size/2) {
            s.pop();
            return;
        }
        int top = s.pop();
        deleteMid(s, size, count+1);
        s.push(top);
    }
}
