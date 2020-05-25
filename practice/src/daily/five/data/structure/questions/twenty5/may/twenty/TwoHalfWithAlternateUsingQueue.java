package daily.five.data.structure.questions.twenty5.may.twenty;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TwoHalfWithAlternateUsingQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(11);
        q.offer(12);
        q.offer(13);
        q.offer(14);
        q.offer(15);
        q.offer(16);
        q.offer(17);
        q.offer(18);
        q.offer(19);
        q.offer(20);
        System.out.println(q);
        createQueueWithAlternateValuesFromtwoHalves(q);
        System.out.println(q);
    }

    private static void createQueueWithAlternateValuesFromtwoHalves(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        int size = q.size();
        for(int i=0; i<size/2; i++) {
            s.push(q.poll());
        }
        while(!s.isEmpty()) {
            q.offer(s.pop());
        }
        for(int i=0; i<size/2; i++) {
            q.offer(q.poll());
        }
        for(int i=0; i<size/2; i++) {
            s.push(q.poll());
        }
        while(!s.isEmpty()) {
            q.offer(s.pop());
            q.offer(q.poll());
        }

    }
}
