package daily.five.data.structure.questions.seventeen.may.twenty;

public class QueueImpl {
    private int front;
    private int end;
    private int capacity;
    private int[] queue;

    public QueueImpl(int capacity) {
        this.front = 0;
        this.end = 0;
        this.capacity = capacity;
        queue = new int[capacity];
    }

    public void offer(int elem) {
        queue[end = end % capacity] = elem;
        end++;
    }

    public int poll() {
        int result = queue[front = front % capacity];
        queue[front = front % capacity] = Integer.MIN_VALUE;
        front++;
        return result;
    }

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl(10);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);
        queue.offer(9);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);
        queue.offer(9);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
