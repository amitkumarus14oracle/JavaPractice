package daily.five.data.structure.questions.eighteen.june.twenty;

public class QueueArrayImpl<T> {
    private int front;
    private int rear;
    private T[] arr;
    private int capacity;
    private int size;

    public QueueArrayImpl(int capacity) {
        this.capacity = capacity;
        arr = (T[])new Object[capacity];
    }

    public void offer(T elem) {
        if(size == capacity) {
            throw new IllegalStateException(" Queue is full, can't add more element");
        } else {
            arr[(rear%capacity)] = elem;
            rear = (rear%capacity)+1;
            size++;
        }
    }

    public T poll() {
        T elem = null;
        if(size == 0) {
            throw new IllegalStateException(" Queue is empty, can't poll element");
        } else {
            elem = arr[front%capacity];
            front = (front%capacity) +1;
            size--;
        }
        return elem;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        QueueArrayImpl<Integer> q = new QueueArrayImpl<>(10);
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        q.offer(6);
        q.offer(7);
        q.offer(8);
        q.offer(9);
        //q.offer(10);
        //q.offer(11);
        System.out.println(q.size);
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.size);


    }
}
