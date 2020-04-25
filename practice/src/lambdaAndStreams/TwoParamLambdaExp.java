package lambdaAndStreams;

import java.util.Arrays;
import java.util.List;

public class TwoParamLambdaExp {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(list.stream().reduce(0,(total, e)-> total+e));
        System.out.println(list.stream().reduce(0,(total, e)-> Integer.sum(total,e)));
        System.out.println(list.stream().reduce(0,Integer::sum));
        System.out.println(list.stream()
                .map(String::valueOf)
                .reduce("",(carry, e)-> carry.concat(e)));
        System.out.println(list.stream()
                .map(String::valueOf)
                .reduce("",String::concat));
    }
}
