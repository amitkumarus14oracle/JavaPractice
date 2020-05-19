package daily.five.data.structure.questions.eighteen.may.twenty;

import java.util.Stack;

public class QueueUsingTwoStacks {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public QueueUsingTwoStacks() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }

    public void enque(Integer elem) {
        s1.push(elem);
    }

    public Integer deque() {
        if(s2.isEmpty())
            while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();

        /*Integer result = s2.pop();
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return result;*/
    }

    public Stack<Integer> getS1() {
        return s1;
    }

    public void setS1(Stack<Integer> s1) {
        this.s1 = s1;
    }

    public Stack<Integer> getS2() {
        return s2;
    }

    public void setS2(Stack<Integer> s2) {
        this.s2 = s2;
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks q = new QueueUsingTwoStacks();
        q.enque(3);
        q.enque(7);
        q.enque(9);
        q.enque(4);
        q.enque(1);
        System.out.println(q.deque());
        System.out.println(q.deque());
        System.out.println(q.deque());
        q.enque(14);
        q.enque(41);
        System.out.println(q.deque());
        System.out.println(q.deque());
        System.out.println(q.deque());
    }
}
