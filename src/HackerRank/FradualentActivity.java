package HackerRank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FradualentActivity {

    public static HashMap<Integer,Integer> freq = new HashMap<>();
    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        int index= 0;
        int notification=0;
        while (index < expenditure.length-1){

            if(index>=d) {
                int median = find(d / 2 + d % 2);

                if(d%2 ==0){
                    int ret = find(d/2+1);
                    if (expenditure[index] >= median + ret) {
                        notification++;
                    }
                }else{
                    if (expenditure[index] >= 2 * median) {
                        notification++;
                    }
                }

            }
            feqtable(index,expenditure[index]);

            if(index >= d){
                int prev = expenditure[index-d];
                freq.put(prev,freq.get(prev)-1);
            }
            index++;
        }
        return notification;

    }
    private static int find(int val){
        int sum=0;
        for (int i =0;i<=200;i++){
            int temp =0;
            if (freq.containsKey(i)){
                temp = freq.get(i);
            }
            sum = sum+ temp;
            if(sum>= val)
                return i;
        }

        return 0;
    }
    private static void feqtable(int index ,int val){
        if(freq.containsKey(val)){
            freq.put(val,(freq.get(val)+1));
        }
        else{
            freq.put(val,1);
        }
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}