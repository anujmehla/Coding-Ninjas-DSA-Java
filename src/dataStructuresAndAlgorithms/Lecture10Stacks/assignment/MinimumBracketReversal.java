package dataStructuresAndAlgorithms.Lecture10Stacks.assignment;

import java.util.Stack;

/*
Question : Minimum bracket Reversal
Problem statement
For a given expression in the form of a string, find the minimum number of brackets that can be reversed in order to
make the expression balanced. The expression will only contain curly brackets.

If the expression can't be balanced, return -1.

Example:
Expression: {{{{
If we reverse the second and the fourth opening brackets, the whole expression will get balanced.
Since we have to reverse two brackets to make the expression balanced, the expected output will be 2.

Expression: {{{
In this example, even if we reverse the last opening bracket, we would be left with the first opening bracket and
hence will not be able to make the expression balanced and the output will be -1.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= N <= 10^6
Where N is the length of the expression.

Time Limit: 1sec
Sample Input 1:
{{{
Sample Output 1:
-1
Sample Input 2:
{{{{}}
Sample Output 2:
1
 */
public class MinimumBracketReversal {
    public static void main(String[] args) {
        String input = "}{";
        System.out.println(countBracketReversals(input));
    }

    public static int countBracketReversals(String input) {
        if (input.length() % 2 != 0) {
            return -1;
        }
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        int open = 0;
        int close = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '{') {
                stack.push(input.charAt(i));
                open++;
            }
            if (input.charAt(i) == '}') {
                if (!stack.isEmpty())
                stack.pop();
                close++;
            }
        }
        ans = Math.abs(open-close)/2;
        return ans;
    }

    public static int countBracketReversals2(String input) {
        int len = input.length();
        if (len == 0)
        {
            return 0;
        }
        if (len % 2 != 0)
        {
            return -1; // Only even number of brackets can be balanced
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++)
        {
            char currentChar = input.charAt(i);
            if (currentChar == '{')
            {
                stack.push(currentChar);
            }
            else
            {
                // Pop if there is a balanced pair
                if (!stack.isEmpty() && stack.peek() == '{')
                {
                    stack.pop();
                }
                else
                {
                    stack.push(currentChar);
                }
            }
        }
        int count = 0;
        // Only unbalanced brackets are there in stack now
        while (!stack.isEmpty())
        {
            char char1 = stack.pop();
            char char2 = stack.pop();
        /*
        When char1 = } and char2 = {, then we need to reverse both of them
        so count will increase by 2
        */
            if (char1 != char2)
            {
                count += 2;
            }
            else
            {
                count += 1;
            }
        }
        return count;
    }
}
