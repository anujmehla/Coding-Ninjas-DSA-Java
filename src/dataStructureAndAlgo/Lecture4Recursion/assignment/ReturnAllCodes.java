package dataStructureAndAlgo.Lecture4Recursion.assignment;

/*
Question : Return all codes - String
Problem statement
Assume that the value of a = 1, b = 2, c = 3, ... , z = 26. You are given a numeric string S.
Write a program to return the list of all possible codes that can be generated from the given string.

Note : The order of codes are not important. And input string does not contain 0s.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
A numeric string
Constraints :
1 <= Length of String S <= 10

Sample Input:
1123
Sample Output:
aabc
kbc
alc
aaw
kw
 */
public class ReturnAllCodes {
    public static void main(String[] args) {
        String input = "1123";
        String[] output = getCode1(input);
        for (String s : output) {
            System.out.print(s+" ");
        }
    }
    public static String[] getCode(String input) {
        //base case uwu
        if(input.length() == 0){
            String ans[] = {""};
            return ans;
        }

        //first character case
        String[] smallAns1 = getCode(input.substring(1));
        char firstChar = (char)((input.charAt(0) - '0' + 'a' - 1));
        for (int i = 0; i<smallAns1.length; i++){
            smallAns1[i] = firstChar + smallAns1[i];
        }


        //check validity of the first two characters
        String[] smallAns2 = new String[0];

        if(input.length()>=2){
            char firstTwoChar = (char)((input.charAt(0)-'0')*10 + (input.charAt(1)-'0') + 'a' -1);
            if (firstTwoChar>= 'a' && firstTwoChar<='z'){
                smallAns2 = getCode(input.substring(2));
                for(int i = 0; i<smallAns2.length; i++){
                    smallAns2[i] = firstTwoChar + smallAns2[i];
                }
            }
        }

        //combine smallAns1 and SmallAns2

        String[] ans = new String[smallAns1.length + smallAns2.length];

        for(int i = 0; i<smallAns1.length; i++){
            ans[i] = smallAns1[i];
        }

        for(int i = smallAns1.length; i<ans.length; i++){
            ans[i] = smallAns2[i-smallAns1.length];
        }

        return ans;
    }
    //their solution
    public static String[] getCode1(String input) {
        if (input.length() == 0) {
            String[] output = {""};
            return output;
        }
        int firstDigit = (input.charAt(0)-'0');
        String[] smallOutput1 = getCode1(input.substring(1));
        String[] smallOutput2 = new String[0];

        int firstTwoDigits = 0;
        if (input.length() >= 2) {
            firstTwoDigits = (input.charAt(0) - '0')*10 + (input.charAt(1)-'0');
            if (firstTwoDigits > 10 && firstTwoDigits <= 26) {
                smallOutput2 = getCode1(input.substring(2));
            }
        }
        String[] output = new String[smallOutput1.length + smallOutput2.length];
        int k = 0;
        for (String s : smallOutput1) {
            char firstDigitChar = getChar(firstDigit); //(char) ('a'-1+lastDigit)
            output[k] = firstDigitChar + s;
            k++;
        }
        for (String s : smallOutput2) {
            char firstTwoDigitChar = getChar(firstTwoDigits);
            output[k] = firstTwoDigitChar + s;
            k++;
        }
        return output;
    }

    public static char getChar(int n) {
        return (char)(96+n);
    }
}
