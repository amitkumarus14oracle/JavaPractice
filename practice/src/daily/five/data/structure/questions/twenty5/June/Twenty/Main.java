package daily.five.data.structure.questions.twenty5.June.Twenty;/*
 * Save this in a file called Main.java and compile it. To test it 
 * create the file `input.txt` in the workspace / Working Directory
 * (For Eclipse/VisualStudio, by default this is the top level project folder)
 */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the 
   standard library */

/* Do not add a namespace declaration */
public class Main {
    public static Map<String,Integer> processData(ArrayList<String> array) {
        /* 
         * Modify this method to process `array` as indicated
         * in the question. At the end, return a Map containing
         * the appropriate values
         *
         * Please create appropriate classes, and use appropriate
         * data structures as necessary.
         *
         * Do not print anything in this method.
         *
         * Submit this entire program (not just this method)
         * as your answer
         */
        Map<String,Integer> retVal = new TreeMap<String,Integer>();
        Map<String,Integer> deptSal = new TreeMap<String,Integer>();
        for(int i=0; i< array.size(); i++) {
            String s = array.get(i);
            String line[] = s.split(",");
            int empId = Integer.parseInt(line[0].trim());
            String dept = line[2].trim();
            int salary = Integer.parseInt(line[3].trim());
            if(deptSal.containsKey(dept)) {
                if(deptSal.get(dept) < salary)
                deptSal.put(dept, salary);
            } else {
                    deptSal.put(dept, salary);
            }
        }
        for(int i=0; i< array.size(); i++) {
            String s = array.get(i);
            String line[] = s.split(",");
            int empId = Integer.parseInt(line[0].trim());
            String dept = line[2].trim();
            int salary = Integer.parseInt(line[3].trim());
            if(deptSal.get(dept) == salary ) {
                retVal.put(dept, empId);
            }
        }
       return retVal;
    }

    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        String line;
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("/home/amit/JavaLearning/JavaPractice/practice/src/daily/five/data/structure/questions/twenty5/input.txt")));
            while(in.hasNextLine())
                inputData.add(in.nextLine());
            Map<String,Integer> retVal = processData(inputData);
            System.out.println(retVal);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            for(Map.Entry<String,Integer> e: retVal.entrySet())
                output.println(e.getKey() + ": " + e.getValue());
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
class EmpSal {
    int sal;
    int empId;

}