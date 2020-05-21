package daily.five.data.structure.questions.twenty1.may.twenty;

import java.util.LinkedList;
import java.util.Queue;

class CreateStackUsing2Queues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public CreateStackUsing2Queues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int elem) {
        if(q1.isEmpty())
            q2.offer(elem);
        else
            q1.offer(elem);
    }

    public Integer pop() {
        if(q1.isEmpty()) {
            while(q2.size() > 1) {
                q1.offer(q2.poll());
            }
            return q2.poll();
        } else {
            while(q1.size() > 1) {
                q2.offer(q1.poll());
            }
            return q1.poll();
        }
    }

    public static void main(String[] args) {
        CreateStackUsing2Queues s = new CreateStackUsing2Queues();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }
}
