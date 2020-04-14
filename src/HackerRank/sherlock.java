package HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class sherlock {

    public static HashMap<Character,Integer> sh = new HashMap<>();
    static String isValid(String s) {

        char[] charr = s.toCharArray();
        int prevValue=0;
        boolean firstEntry= true;
        boolean valOnce = false;
        String finalAnswer ="NO";
        for (Character ch : charr){
            if(sh.containsKey(ch)){
                int h = sh.get(ch);
                h = h+1;
                sh.put(ch,h);

            }else
            {
                sh.put(ch,1);
            }
        }
        Map<Character, Integer> hm1 = sortByValue(sh);
        for (Map.Entry<Character, Integer> entry : hm1.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            if(firstEntry){
                prevValue = entry.getValue();
                finalAnswer ="YES";
                firstEntry = false;
                continue;
            }
            if (entry.getValue()!= prevValue && entry.getValue() - 1 == prevValue && !valOnce){
                finalAnswer ="YES";
                valOnce = true;
            }else if (entry.getValue()!= prevValue && valOnce){
                finalAnswer ="NO";
                break;
            }
            finalAnswer ="YES";

        }

        return finalAnswer;
    }
    public static HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Character, Integer> > list =
                new LinkedList<Map.Entry<Character, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);
        System.out.println("value is "+result);
        // bufferedWriter.write(result);
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
