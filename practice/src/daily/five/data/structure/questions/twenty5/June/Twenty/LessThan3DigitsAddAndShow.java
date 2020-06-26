package daily.five.data.structure.questions.twenty5.June.Twenty;

import java.util.*;
import java.io.*;

public class LessThan3DigitsAddAndShow {
    public static int processArray(ArrayList<Integer> array) {

        ListIterator<Integer> itr = array.listIterator();
        int sum = 0;
        while(itr.hasNext()) {
            Integer i = itr.next();
            if(i >=0 )
                if(i.toString().length() < 3) {
                    itr.remove();
                    sum = sum+i;
                } else {
                    itr.remove();
                    if(sum != 0) {
                        itr.add(sum);
                    }
                    itr.add(i);
                    sum = 0;
                }
        }
        System.out.println(array);
        // Processing the data in same array is fine but returning size would
        //give you original size, please change either question or let the
        //programmer to change return statement.
        return array.size();
    }

    public static void main (String[] args) {
        LessThan3DigitsAddAndShow l = null;

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        l.processArray(arrayList);
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int num = in.nextInt();
            if (num < 0)
                break;
            arrayList.add(new Integer(num));
        }
        int new_length = processArray(arrayList);
        for(int i=0; i<new_length; i++)
            System.out.println(arrayList.get(i));
    }
}