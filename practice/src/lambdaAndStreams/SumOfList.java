package lambdaAndStreams;

import java.util.Arrays;
import java.util.List;

public class SumOfList {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,2,3,4,5,6,7,8,9);
        // find first number which in greater than 3 and even , then double it
        Integer i = l.stream()
                .filter(GTAndEvenDouble::GT3)
                .filter(GTAndEvenDouble::isEven)
                .mapToInt(GTAndEvenDouble::doubleIt)
                .sum();
                //.reduce(0,(total, e)-> total+e);
        System.out.println(i);
    }
}
