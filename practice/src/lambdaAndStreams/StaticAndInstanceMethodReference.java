package lambdaAndStreams;

import java.util.Arrays;
import java.util.List;

public class StaticAndInstanceMethodReference {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        list.stream()
                //.map(e -> String.valueOf(e))
                .map(String::valueOf) // Static method reference// alternate of above of above statement
                //.map(e-> e.toString())
                .map(String::toString) // Instance Method Reference// alternate of above of above statement
                .forEach(System.out:: println);


    }
}
