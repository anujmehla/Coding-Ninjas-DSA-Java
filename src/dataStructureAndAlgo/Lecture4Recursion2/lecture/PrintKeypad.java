package dataStructureAndAlgo.Lecture4Recursion2.lecture;

/*
Question : Print Keypad - String
Problem statement
Given an integer n, using phone keypad find out and print all the possible strings that can be made using digits of input n.

Note :
The order of strings are not important. Just print different strings in new lines.
Detailed explanation ( Input/output format, Notes, Images )
Input Format :
Integer n
Output Format :
All possible strings in different lines
Constraints :
1 <= n <= 10^6

Sample Input:
23
Sample Output:
ad
ae
af
bd
be
bf
cd
ce
cf
 */
public class PrintKeypad {
    public static void main(String[] args) {
        printKeypad(23);
    }
    public static void printKeypad(int input) {
        printKeypad(input,"");
    }
    public static void printKeypad(int input, String outputSoFar) {
        if (input==0) {
            System.out.println(outputSoFar);
            return;
        }
        String[] alphabets = helperFunction(input%10);
        for (int i = 0; i < alphabets.length; i++) {
            printKeypad(input/10,alphabets[i]+outputSoFar);
        }
    }
    public static String[] helperFunction(int n) {
        String[] strings;
        return switch (n) {
            case 2 -> {
                strings = new String[]{"a", "b", "c"};
                yield strings;
            }
            case 3 -> {
                strings = new String[]{"d", "e", "f"};
                yield strings;
            }
            case 4 -> {
                strings = new String[]{"g", "h", "i"};
                yield strings;
            }
            case 5 -> {
                strings = new String[]{"j", "k", "l"};
                yield strings;
            }
            case 6 -> {
                strings = new String[]{"m", "n", "o"};
                yield strings;
            }
            case 7 -> {
                strings = new String[]{"p", "q", "r", "s"};
                yield strings;
            }
            case 8 -> {
                strings = new String[]{"t", "u", "v"};
                yield strings;
            }
            case 9 -> {
                strings = new String[]{"w", "x", "y", "z"};
                yield strings;
            }
            default -> new String[]{""};
        };
    }
}
