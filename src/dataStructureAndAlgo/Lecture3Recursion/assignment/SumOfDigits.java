package dataStructureAndAlgo.Lecture3Recursion.assignment;

/*
Question : Sum Of Digits
Problem statement
Write a recursive function that returns the sum of the digits of a given integer.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
Integer N
Output format :
Sum of digits of N
Constraints :
0 <= N <= 10^9
Sample Input 1 :
12345
Sample Output 1 :
15
Sample Input 2 :
9
Sample Output 2 :
9
 */
public class SumOfDigits {
    public static void main(String[] args) {
        int input = 12345;
        System.out.println(sumOfDigits(input));
    }
    public static int sumOfDigits(int input) {
        if (input==0) {
            return 0;
        }
        int ans = sumOfDigits(input/10);
        ans += input%10;
        return ans;
    }
}