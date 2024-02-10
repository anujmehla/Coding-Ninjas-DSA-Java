package dataStructureAndAlgo.Lecture10Stacks.assignment;

import java.util.Stack;

/*
Question : check redundant brackets
Problem statement
For a given expression in the form of a string, find if there exist any redundant brackets or not.
It is given that the expression contains only rounded brackets or parenthesis and the input expression will always be
balanced.

A pair of the bracket is said to be redundant when a sub-expression is surrounded by unnecessary or needless brackets.

Example:
Expression: (a+b)+c
Since there are no needless brackets, hence, the output must be 'false'.

Expression: ((a+b))
The expression can be reduced to (a+b). Hence the expression has redundant brackets and the output will be 'true'.
Note:
You will not get a partial score for this problem. You will get marks only if all the test cases are passed.
Return "false" if no brackets are present in the input.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
0 <= N <= 10^6
Where N is the length of the expression.

Time Limit: 1 second
Sample Input 1:
a+(b)+c
Sample Output 1:
true
Explanation:
The expression can be reduced to a+b+c. Hence, the brackets are redundant.
Sample Input 2:
(a+b)
Sample Output 2:
false
 */
public class CheckRedundantBrackets {
    public static void main(String[] args) {
        String input = "(x+y*(a-b))";
        System.out.println(checkRedundantBrackets2(input));
    }
    // my solution
    // approach is to : find the number of elements between the two brackets. If elements <= 1 means it's redundant.
    public static boolean checkRedundantBrackets(String expression) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c : expression.toCharArray()) {
            if (c != ')') {
                stack.push(c);
            } else {
                while (stack.peek() != '(') {
                    count++;
                    stack.pop();
                    System.out.println(count);
                }
                stack.pop();//removing (
                if (count <= 1) {
                    return true;
                } else {
                    count =0;
                }
            }
        }
        return false;
    }
    //their solution
    private static boolean find(char ch) {
        if (ch == '+' || ch == '-' || ch == '/') {
            return true;
        }
        return false;
    }
    public static boolean checkRedundantBrackets2(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); ++i) {
            if (expression.charAt(i) == '(' || find(expression.charAt(i))) {
                stack.push(expression.charAt(i));
            } else if (expression.charAt(i) == ')') {
                boolean hasOperator = false;
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                    hasOperator = true;
                }
                if (!hasOperator) {
                    return true;
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        return false;
    }
}
