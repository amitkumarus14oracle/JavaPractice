package lambdaAndStreams;

import java.util.Arrays;
import java.util.List;

public class SortDistinctUsingStream {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,3,2,4,3,5,6,7,8,9);
        list.stream()
                .sorted()
                .distinct()
                .forEach(System.out::println);
    }
}
