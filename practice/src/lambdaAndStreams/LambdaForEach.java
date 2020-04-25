package lambdaAndStreams;

import java.util.Arrays;
import java.util.List;

public class LambdaForEach {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
        l.forEach(e -> System.out.println(e)); // executed in iteration order of iterable i.e. same order
        l.stream().forEach(e -> System.out.println(e)); // order will be undefined
        l.forEach(LambdaForEach::doubleValue);
    }
    public static void doubleValue(int number) {
        System.out.println(" double value is :"+ number*2);
    }
}
