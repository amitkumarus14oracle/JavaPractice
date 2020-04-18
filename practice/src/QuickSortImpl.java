import java.util.Arrays;

public class QuickSortImpl {

    public static void main(String[] args) {
        int a[] = {84,73,62,20,30,50,40,4,7,2,9,5,1,8,6,22,11,26,34,17,29};
       /* System.out.println(partition(a,0,a.length-1));
        for(int i=0; i<a.length;i++) {
            System.out.print(a[i]+",");
        }*/
        quickSort(a,0,a.length-1);
        for(int i=0; i<a.length;i++) {
            System.out.print(a[i]+",");
        }
    }

    public static void quickSort(int a[], int l, int h) {
        if(l <h) {
            int j = partition(a, l, h);
            quickSort(a, l, j-1);
            quickSort(a, j+1, h);
        }
    }

    public static int partition(int a[], int l, int h) {//{4,7,2,9,5,1,8,7};
        int pivot = a[l];
        int i= l+1;
        int j= h;
        while(i<j) {
            while(a[i] < pivot && i<j) {
                i++;
            }
            while(a[j] >= pivot) {
                j--;
            }
            if(i<j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        if(a[l] > a[j]) {
            int temp = a[j];
            a[j] = a[l];
            a[l] = temp;
        }
        return j;
    }
}
