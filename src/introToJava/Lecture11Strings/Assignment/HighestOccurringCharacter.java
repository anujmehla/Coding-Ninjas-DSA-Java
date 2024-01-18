package introToJava.Lecture11Strings.Assignment;

import java.util.HashMap;
import java.util.Map;

public class HighestOccurringCharacter {
    public static void main(String[] args) {
//        String str = "abdefgbabfba";
        String str = "xy";
        System.out.println(highestOccurringChar(str));
    }
    public static char highestOccurringChar(String str) {
        char[] charArray = str.toCharArray();
        Map<Character,Integer> countMap = new HashMap<>();
        int maxCount = 0;
        char maxChar = charArray[0];
        for (char c : charArray) {
            countMap.put(c,countMap.getOrDefault(c,0)+1);
            if (countMap.get(c) > maxCount) {
                maxCount = countMap.get(c);
                maxChar = c;
            }
        }
        return maxChar;
    }
}
//sample 1
//input = abdefgbabfba
//output = b

//sample 2
//input = xy
//output = x