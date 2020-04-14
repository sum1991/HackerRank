package HackerRank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ContinueStr {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {

        boolean lookingforA= false;
        boolean lookingforB = false;
        char[] chs = s.toCharArray();
        int numOfDel=0;
        int index=0;
        if(chs[index]=='A'){
            lookingforB = true;
        }else {
            lookingforA = true;
        }
        index++;
        while(index<chs.length){
            if(chs[index] == 'B' && lookingforB)
            {
                lookingforA = true;
                lookingforB = false;
                index++;
                continue;
            }else if(chs[index]=='A' && lookingforA){
                lookingforB = true;
                lookingforA = false;
                index++;
                continue;
            }
            if(chs[index]=='A' && lookingforB){
                numOfDel++;
                index++;
            }else if(chs[index]=='B' && lookingforA){
                numOfDel++;
                index++;
            }


        }

        return numOfDel;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);
            System.out.println("val is"+result);
            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
