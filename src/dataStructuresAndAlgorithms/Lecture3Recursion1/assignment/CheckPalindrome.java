package dataStructuresAndAlgorithms.Lecture3Recursion1.assignment;

/*
Question : Check Palindrome (recursive)
Problem statement
Determine if a given string ‘S’ is a palindrome using recursion.
Return a Boolean value of true if it is a palindrome and false if it is not.

Note: You are not required to print anything, just implement the function. Example:
Input: s = "racecar"
Output: true
Explanation: "racecar" is a palindrome.
Detailed explanation ( Input/output format, Notes, Images )
Input Format:
The first and only line of the input contains string S.
Output format:
Return a boolean value True or False.
Sample Input 1:
abbba
Sample Output 1:
true
Explanation Of Sample Input 1 :
“abbba” is a palindrome
Sample Input 2:
abcd
Sample Output 2:
false
Explanation Of Sample Input 2 :
“abcd” is not a palindrome.
Constraints:
0 <= |S| <= 10^6
where |S| represents the length of string S.
 */
public class CheckPalindrome {
    public static void main(String[] args) {
        String str = "racecar";
        System.out.println(isPalindrome(str));
    }
    public static boolean isPalindrome(String str) {
        return isPalindrome(str,0,str.length()-1);
    }
    public static boolean isPalindrome(String str, int start, int end) {
        // Base case: If we've checked all the characters, or there is only one character left
        if (start >= end) {
            return true;
        }
        // Check if the characters at the current positions are equal
        if (str.charAt(start) != str.charAt(end)) {
            return false; // Not a palindrome if mismatch occurs
        }
        // Recursive call: Move towards the center
        return isPalindrome(str, start + 1, end - 1);
    }
}