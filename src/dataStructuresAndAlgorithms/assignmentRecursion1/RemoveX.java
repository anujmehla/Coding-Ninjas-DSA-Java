package dataStructuresAndAlgorithms.assignmentRecursion1;

/*
Question : Remove X
Problem statement
Given a string, compute recursively a new string where all 'x' chars have been removed.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
String S
Output format :
Modified String
Constraints :
1 <= |S| <= 10^3
where |S| represents the length of string S.
Sample Input 1 :
xaxb
Sample Output 1:
ab
Sample Input 2 :
abc
Sample Output 2:
abc
Sample Input 3 :
xx
Sample Output 3:
 */
public class RemoveX {
    public static void main(String[] args) {
        String input = "xaxb";
//        String input2 = "abc";
//        String input3 = "xx";
        System.out.println(removeX(input));
    }
    public static String removeX(String input) {
        if (input.isEmpty()) {
            return "";
        }
        if (input.charAt(0) == 'x') {
            return removeX(input.substring(1));
        }
        return input.charAt(0) + removeX1(input.substring(1));
    }
    public static String removeX1(String input) {
        if (input.length()<=0) {
            return "";
        }
        char firstChar = input.charAt(0);
        String restOfString = input.substring(1);

        if (firstChar=='x') {
            return removeX1(restOfString);
        } else {
            return firstChar+removeX1(restOfString);
        }
    }
}
