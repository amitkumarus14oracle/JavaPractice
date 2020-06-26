package daily.five.data.structure.questions.twenty3.june.twenty;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LambdaWithCountOperation {
    //static int countn = 0; // this can be used within Lambda
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1, 2, 3, 4, 5, 6);
        AtomicInteger count = new AtomicInteger(0);
        int countn = 0;
        int countArr[] = new int[1]; // this can be used within Lambda
        l.stream().filter(e -> { return e%2 == 0;}).forEach(e -> { count.incrementAndGet(); });
        l.stream().filter(e -> { return e%2 == 0;}).forEach((e) -> { countArr[0]++;});
        System.out.println(countArr[0]);
    }
}
interface X {
    public default void m1() {}
}
