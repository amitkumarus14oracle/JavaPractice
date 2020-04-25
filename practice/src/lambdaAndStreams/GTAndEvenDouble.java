package lambdaAndStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class GTAndEvenDouble {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,2,3,4,5,6,7,8,9);
        // find first number which in greater than 3 and even , then double it
        Optional<Integer> i = l.stream()
                .filter(GTAndEvenDouble::GT3)
                .filter(GTAndEvenDouble::isEven)
                .map(GTAndEvenDouble::doubleIt)
                .findFirst();
        System.out.println(i.get());
    }

    public static boolean GT3(int number) {
        return number>3;
    }
    public static boolean isEven(int number) {
        return number%2==0;
    }
    public static int doubleIt(int number) {
        return number*2;
    }
}
