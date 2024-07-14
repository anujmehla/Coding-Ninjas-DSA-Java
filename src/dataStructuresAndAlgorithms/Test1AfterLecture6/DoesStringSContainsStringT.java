package dataStructuresAndAlgorithms.Test1AfterLecture6;

/*
Question : Does string 's' contains  string 't' ?
Problem statement
Given two string s and t, write a function to check if s contains all characters of t
(in the same order as they are in string t).

Return true or false.

Do it recursively.

E.g. : s = “abchjsgsuohhdhyrikkknddg” contains all characters of t=”coding” in the same order.
So function will return true.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
abchjsgsuohhdhyrikkknddg
coding
Sample Output 1 :
true
Sample Input 2 :
abcde
aeb
Sample Output 2 :
false
 */
public class DoesStringSContainsStringT {
    public static void main(String[] args) {
        String s = "abchjsgsuohhdhyrikkknddg";
        String t = "coding";
        System.out.println(checkSequence(s, t));
    }

    public static boolean checkSequence(String a, String b) {
        if (b.isEmpty()) {
            return true;
        }
        if (a.isEmpty()) {
            return false;
        }
        if (a.charAt(0) == b.charAt(0)) {
            return checkSequence(a.substring(1), b.substring(1));
        } else {
            return checkSequence(a.substring(1),b);
        }
    }
}
