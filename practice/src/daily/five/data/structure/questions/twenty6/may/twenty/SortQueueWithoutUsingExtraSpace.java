package daily.five.data.structure.questions.twenty6.may.twenty;

import java.util.LinkedList;
import java.util.Queue;

public class SortQueueWithoutUsingExtraSpace {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(56);
        q.offer(5);
        q.offer(6);
        q.offer(43);
        q.offer(11);
        q.offer(45);
        System.out.println(q);
        sort(q);
        System.out.println(q);
    }

    private static void sort(Queue<Integer> q) {

        for(int i=0; i<q.size(); i++) {
            int min_index = findMinIndex(q, q.size()-i);
            punMinIndexAtRearEnd(q, min_index);
        }
    }

    private static void punMinIndexAtRearEnd(Queue<Integer> q, int min_index) {
        int minValue = 0;
        int size = q.size();
        for(int i=0; i< size; i++) {
            int current = q.peek();
            q.poll();
            if (i != min_index) {
                q.offer(current);
            } else {
                minValue = current;
            }
        }
        q.offer(minValue);
    }

    private static int findMinIndex(Queue<Integer> q, int count) {
        int minIndex = 0;
        int minValue = Integer.MAX_VALUE;
        for(int i=0; i<q.size(); i++) {
            int current = q.peek();
            q.poll();
            if(current <= minValue && i< count) {
                minIndex = i;
                minValue = current;
            }
            q.offer(current);
        }
        return minIndex;
    }
}
