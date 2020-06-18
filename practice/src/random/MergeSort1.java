package random;

import java.util.Arrays;

public class MergeSort1 {
    public static void main(String[] args) {
        String[] sorted= {"akash", "ali", "amit",  "anjali", "ayushi", "sandeep","sumit"};
        String[] unsorted = {"anish", "sanjay", "abhishek", "hanu"};
        System.out.println(Arrays.asList(unsorted));
        unsorted = mergeSort(unsorted, 0, unsorted.length-1);
        System.out.println(Arrays.asList(unsorted));
        sorted = merge(sorted,unsorted);
        System.out.println(Arrays.asList(sorted));
    }

    public static String[] mergeSort(String[] a, int l, int h) {
        int m = (l+h)/2;
        if(l==h) {
            String[] x = new String[1];
            x[0] = a[l];
            return x;
        }
        return merge(mergeSort(a, l, m), mergeSort(a, m+1, h));
    }

    public static String[] merge(String[] b, String[] c) {
        String a[] = new String[b.length+c.length];
        int i=0, j=0, k=0;
        while(i<b.length && j<c.length) {
            if(b[i].compareTo(c[j]) < 0) {
                a[k++] = b[i++];
            }
            else if(b[i].compareTo(c[j]) > 0) {
                a[k++] = c[j++];
            }else {
                a[k++] = b[i++];
                a[k++] = c[j++];
            }
        }
        if(i==b.length) {
            while(j<c.length) {
                a[k++] = c[j++];
            }
        } else {
            while(i<b.length) {
                a[k++] = b[i++];
            }
        }
        return a;
    }
}
