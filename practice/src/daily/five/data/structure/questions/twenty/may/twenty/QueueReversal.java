package daily.five.data.structure.questions.twenty.may.twenty;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {
    public static void main(String[] args) {
        Queue<Integer> q =new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        System.out.println(q);
        reverseQueue(q);
        System.out.println(q);
    }

    private static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()) {
            s.push(q.poll());
        }
        while(!s.isEmpty()) {
            q.offer(s.pop());
        }
    }
}
