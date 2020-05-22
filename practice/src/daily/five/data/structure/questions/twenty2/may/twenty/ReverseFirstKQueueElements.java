package daily.five.data.structure.questions.twenty2.may.twenty;

import java.util.*;

public class ReverseFirstKQueueElements {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);
        q.offer(7);
        q.offer(8);
        q.offer(9);
        int k =4;
        System.out.println(q);
        reverseFirstKElement(q, k);
        System.out.println(q);
    }

    private static void reverseFirstKElement(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();
        int i =0;
        while(i < k) {
            s.push(q.poll());
            i++;
        }
        while(!s.isEmpty()) {
            q.offer(s.pop());
        }
        i = 0;
        while(i < q.size()-k) {
            q.offer(q.poll());
            i++;
        }
    }
}
