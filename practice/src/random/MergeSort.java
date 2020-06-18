package random;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        String[] sorted= {"amit", "sumit", "akash", "ali", "anjali","sandeep", "ayushi"};
        String[] unsorted = {"anish", "sanjay", "abhishek", "hanu"};
        System.out.println(Arrays.asList(unsorted));
        mergeSort(unsorted, 0, unsorted.length-1);
        System.out.println(Arrays.asList(unsorted));
    }

    public static void mergeSort(String[] a, int l, int h) {
        int m = (l+h)/2;
        if(l==h) {
            return;
        }
        mergeSort(a, l, m);
        mergeSort(a, m+1, h);
        merge(a, l, m, h);
    }

    public static void merge(String[] a, int l, int m, int h) {
        String b[] = new String[m-l+1];
        String c[] = new String[h-m];

        for(int i=0; i<b.length; i++) {
            b[i] = a[l+i];
        }
        for(int i=0; i<c.length; i++) {
            c[i] = a[m+i+1];
        }

        int i=0, j=0, k=l;
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
    }
}
