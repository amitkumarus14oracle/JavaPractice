package daily.five.data.structure.questions.twenty5.June.Twenty;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapIteration {
    public static void main(String[] args) {
        HashMap<String, String> h = new HashMap<>();
        h.put("amit", "amit1");
        h.put("akash", "akash1");
        h.put("anish", "anish1");
        h.put("abhishek", "abhishek1");
        h.put("kunal", "kunal1");

        Set<Map.Entry<String, String>> s = h.entrySet();
        Iterator<Map.Entry<String,String>> itr = s.iterator();
        while(itr.hasNext()) {
            Map.Entry<String,String> en = itr.next();
            System.out.println("key is :"+ en.getKey());
            System.out.println("value is :"+ en.getValue());

        }
    }
}