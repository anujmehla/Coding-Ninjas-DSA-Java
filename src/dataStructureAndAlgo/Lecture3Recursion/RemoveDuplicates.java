package dataStructureAndAlgo.Lecture3Recursion;

/*
Question : Remove Duplicates Recursively
Given a string S, remove consecutive duplicates from it recursively.
Input Format :
String S
Output Format :
Output string
Constraints :
1 <= |S| <= 10^3
where |S| represents the length of string
Sample Input 1 :
aabccba
Sample Output 1 :
abcba
Sample Input 2 :
xxxyyyzwwzzz
Sample Output 2 :
xyzwz
*/
public class RemoveDuplicates {
    public static void main(String[] args) {
        String s = "aabccba";
        System.out.println(removeConsecutiveDuplicates1(s));
    }
    //my solution
    public static String removeConsecutiveDuplicates(String s) {
        if (s.length()==1) {
            return s;
        }
        String ans = "";
        if (s.charAt(0)!=s.charAt(1)) {
            ans = String.valueOf(s.charAt(0));
        }
        return ans+removeConsecutiveDuplicates(s.substring(1));
    }
    //their solution
    public static String removeConsecutiveDuplicates1(String s) {
        if (s.length() <= 1) {
            return s;
        }
        if (s.charAt(0) == s.charAt(1)) {
            return removeConsecutiveDuplicates1(s.substring(1));
        } else {
            String small = removeConsecutiveDuplicates1(s.substring(1));
            return s.charAt(0)+small;
        }
    }
}