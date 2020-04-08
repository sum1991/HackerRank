package HackerRank;

import java.io.IOException;

public class SelectionSort {


    public static int[] selectionSort(int[] arr){

        for (int i=0;i<arr.length-1;i++){
            int midIndex = i;
            for (int j = i+1;j<arr.length;j++){
                if(arr[midIndex]>arr[j]){
                    int temp = arr[midIndex];
                    arr[midIndex] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
    public static void main(String[] args) throws IOException {
        System.out.println("--Selection Sort--");
        int[] unsort = {7,2,4,1,5};
        int[] sorted = selectionSort(unsort);
        for (int s:sorted) {
            System.out.println("values are "+s);
        }
    }
}
