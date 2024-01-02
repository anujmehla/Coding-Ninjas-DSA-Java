package dataStructureAndAlgo.Lecture3Recursion;

/*
Question : Replace Character Recursively
Given an input string S and two characters c1 and c2,
you need to replace every occurrence of character c1 with character c2 in the given string.
Do this recursively.
Input Format :
Line 1 : Input String S
Line 2 : Character c1 and c2 (separated by space)
Output Format :
Updated string
Constraints :
1 <= Length of String S <= 10^6
Sample Input :
abacd
a x
Sample Output :
xbxcd
 */
public class ReplaceCharacter {
    public static void main(String[] args) {
        String input = "abacd";
        char c1 = 'a';
        char c2 = 'x';
        System.out.println(replaceCharacter(input, c1, c2));
    }
    public static String replaceCharacter(String input, char c1, char c2) {
        if (input.length() == 0) {
            return input;
        }
        char firstChar = (input.charAt(0) == c1) ? c2 : input.charAt(0);
        return firstChar+replaceCharacter(input.substring(1),c1,c2);
    }
}