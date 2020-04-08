package HackerRank;

import java.io.IOException;

public class RecursiveBuubleSort {

    public static void RecursiveSort(int[] arr,int n){
        if(n==1)
            return;
        for (int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                int temp = arr[i];
                arr[i]= arr[i+1];
                arr[i+1] = temp;
            }
        }
        RecursiveSort(arr,n-1);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("--Selection Sort--");
        int[] unsort = {64, 34, 25, 12, 22, 11, 90};
        RecursiveSort(unsort,unsort.length);
        for (int s:unsort) {
            System.out.println("values are "+s);
        }
    }
}
