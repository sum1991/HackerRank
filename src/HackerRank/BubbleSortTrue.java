package HackerRank;

import java.io.IOException;

public class BubbleSortTrue {

    public static int[] trueBubbleSort(int[] arr){
        for (int i =0;i<arr.length;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) throws IOException {


        System.out.println("--Bubble Sort--");
        int[] unsort = {7,2,4,1,5};
        int[] sorted = trueBubbleSort(unsort);
        for (int s:sorted) {
            System.out.println("values are "+s);
        }
    }
}
