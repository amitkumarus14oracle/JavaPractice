package daily.five.data.structure.questions.eighteen.june.twenty;

public class LinkedListImpl {
    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<Integer>(1, new ListNode(2, new ListNode(3)));
        while(head != null) {
            System.out.println(head.getData());
            head = head.getNext();
        }
    }
}
class ListNode<T> {
    private T data;
    private ListNode next;

    public ListNode(T data) {
        this.data = data;
    }

    public ListNode(T data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
