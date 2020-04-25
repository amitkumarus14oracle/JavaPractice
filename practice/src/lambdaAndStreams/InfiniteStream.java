package lambdaAndStreams;

import java.util.stream.Stream;

public class InfiniteStream {
    public static void main(String[] args) {
        // Given n(count) and k(start point), find sum of n double values starting point k where value would be even and its sqrt more than 20
        int n=10;
        int k= 3;
        System.out.println(sumFunctional(k,n));
        System.out.println(sumIterative(k,n));
    }

    public static int sumIterative(int k, int n) {
        int result=0;
        int count =0;
        while(count < n) {
            if(k%2==0 && Math.sqrt(k)>20) {
                result+=k*2;
                count++;
            }
            k++;
        }
        return result;
    }
        public static int sumFunctional(int k, int n) {
        return Stream.iterate(k, e->e+1)
                .filter(e->e%2==0)
                .filter(e->Math.sqrt(e)>20)
                .mapToInt(e->e*2)
                .limit(n)
                .sum();
    }
}
