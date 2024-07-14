package dataStructuresAndAlgorithms.Lecture4$assignmentRecursion1;

/*
Question : Replace pi (recursive)

Problem statement
Given a string, compute recursively a new string where all appearances of "pi" have been replaced by "3.14".

Constraints :
1 <= |S| <= 50
where |S| represents the length of string S.
Constraints :
1 <= |S| <= 50
where |S| represents the length of string S.
Sample Input 1 :
xpix
Sample Output :
x3.14x
Sample Input 2 :
pipi
Sample Output :
3.143.14
Sample Input 3 :
pip
Sample Output :
3.14p
Constraints:-
1<=|S|<=50
 */
public class ReplacePi {
    public static void main(String[] args) {
        String input = "xpix";
        String input2 = "pix";
        System.out.println(replace1(input2));
    }

    //their solution
    public static String replace(String input) {
        String output;
        if (input.length()<=1) {
            return input;
        }
        String small = replace(input.substring(1));
        if (input.charAt(0) == 'p' && small.charAt(0) == 'i') {
            output = "3.14"+small.substring(1);
        } else {
            output = input.charAt(0) + small;
        }
        return output;
    }


    //my solution to it
    public static String replace1(String input) {
        if (input.length()<=1) {
            return input;
        } else {
            if (input.startsWith("pi")) {
                input = "3.14"+input.substring(2);
            }
        }
        return input.charAt(0) + replace1(input.substring(1));
    }
}