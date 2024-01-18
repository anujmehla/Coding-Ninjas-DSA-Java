package dataStructureAndAlgo.Lecture4Recursion.assignment;

/*
Question : Pair Star
Problem statement
Given a string S, compute recursively a new string where identical chars that are adjacent in the original string are
separated from each other by a "*".

Detailed explanation ( Input/output format, Notes, Images )
Input format :
String S
Output format :
Modified string
Constraints :
0 <= |S| <= 1000
where |S| represents length of string S.
Sample Input 1 :
hello
Sample Output 1:
hel*lo
Sample Input 2 :
aaaa
Sample Output 2 :
a*a*a*a
 */
public class PairStar {
    public static void main(String[] args) {
        String input = "hello";
        System.out.println(addStars1(input));
    }

    //my solution
    public static String addStars(String s) {
        if (s.length() == 1) {
            return s;
        }
        char firstChar = s.charAt(0);
        String smallOutput = addStars(s.substring(1));
        if (firstChar == smallOutput.charAt(0)) {
            smallOutput = '*' + smallOutput;
        }
        return firstChar + smallOutput;
    }
    //their solution
    public static String addStars1(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String out = addStars1(s.substring(1));
        if (s.charAt(0) == s.charAt(1)) {
            out = s.charAt(0) + "*" + s.charAt(1) + out.substring(1);
        } else {
            out = s.charAt(0) + out;
        }
        return out;
    }

}
