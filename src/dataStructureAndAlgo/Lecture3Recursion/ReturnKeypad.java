package dataStructureAndAlgo.Lecture3Recursion;

/*
Question : Return Keypad
Problem statement
Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.

Return empty string for numbers 0 and 1.

Note :
1. The order of strings are not important.
2. Input and output has already been managed for you.
You just have to populate the output array and return the count of elements populated in the output array.
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

public class ReturnKeypad {
    public static void main(String[] args) {
        int n = 23;
        String[] ans = keypad(n);
        print(ans);
    }
    public static String[] keypad(int n) {
        if(n == 0) {
            return new String[]{""};
        }
        String[] smallAns = keypad(n/10);
        String[] alphabets = helperFunction(n%10);
        String[] output = new String[alphabets.length * smallAns.length];
        int k = 0;
        for (String alphabet : alphabets) {
            for (String str : smallAns) {
                output[k] = str + alphabet;
                k++;
            }
        }
        return output;
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
    public static void print(String[] ans) {
        for (String s : ans) {
            System.out.print(s+" ");
        }
    }
}
