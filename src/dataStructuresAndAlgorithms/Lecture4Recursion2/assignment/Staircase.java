package dataStructuresAndAlgorithms.Lecture4Recursion2.assignment;

/*
Question : Staircase
Problem statement
A child is running up a staircase with N steps, and can hop either 1 step, 2 steps or 3 steps at a time.
Implement a method to count how many possible ways the child can run up to the stairs.
You need to return number of possible ways W.

Detailed explanation ( Input/output format, Notes, Images )
Input format :
Integer N
Output Format :
Integer W
Constraints :
1 <= N <= 30
Sample Input 1 :
4
Sample Output 1 :
7
Sample Input 2 :
5
Sample Output 2 :
13
 */
public class Staircase {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(staircase1(4));
    }
    public static int staircase(int n) {
        if (n<0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }
        return staircase(n-1)+staircase(n-2)+staircase(n-3);
    }
    //their solution
    public static int staircase1(int n) {
        if (n<0) {
            return 0;
        }
        if (n==0) {
            return 1;
        }
        return staircase1(n-1)+staircase1(n-2)+staircase1(n-3);
    }
}