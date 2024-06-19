package introductionToJava.Test1AfterLecture7;

import java.util.Scanner;

/*
Problem statement
You are given two numbers, ‘X’ and ‘Y’. Your task is to find the greatest common divisor of the given two numbers.

The Greatest Common Divisor of any two integers is the largest number that divides both integers.

For Example:
You are given ‘X’ as 20 and ‘Y’ as 15. The greatest common divisor, which divides both 15 and 20, is 5.
Hence, the answer is 5.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= X, Y <= 10^9
Sample Input 1:
2
20 15
8 32
Sample Output 1:
5
8
Explanation:
For the first test case, the greatest common divisor which divides both 15 and 20 is 5. Hence, the answer is 5.

For the second test case, the greatest common divisor which divides both 8 and 32 is 8. Hence, the answer is 8.
Sample Input 2:
2
98 56
36 60
Sample Output 2:
14
12
 */
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        for (int t = 0; t < T; t++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();

            int gcd = findGCD(X, Y);
            System.out.println(gcd);
        }
        sc.close();
    }
    // Function to calculate the GCD of two numbers using the Euclidean algorithm
    public static int findGCD(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
