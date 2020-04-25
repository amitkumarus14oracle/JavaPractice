package lambdaAndStreams;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByValue {
    public static void main(String[] args) {
        HashMap<String,Integer> unsorted = new HashMap<>();
        unsorted.put("amit", 6);
        unsorted.put("amitq", 9);
        unsorted.put("amitr", 1);
        unsorted.put("amita", 3);
        unsorted.put("amity", 5);
        unsorted.put("amiti", 8);
        unsorted.put("amito", 9);
        unsorted.put("amitc", 4);
        System.out.println(unsorted);

        System.out.println(unsorted.entrySet().stream()
                //.sorted()
                .collect(Collectors.toMap(e-> e.getValue(),e-> e.getKey())));

        System.out.println(unsorted.entrySet().stream()
                //.sorted()
                .collect(Collectors.groupingBy(Map.Entry:: getValue, Collectors.mapping(Map.Entry:: getKey, Collectors.toList()))));

        Map<String, Integer> sorted = unsorted
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                                LinkedHashMap::new));
        System.out.println(sorted);


    }

}
