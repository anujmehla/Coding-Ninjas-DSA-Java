package dataStructuresAndAlgorithms.Lecture3Recursion1.assignment;

/*
Given an integer N, count and return the number of zeros that are present in the given integer using recursion.
Input Format :
Integer N
Output Format :
Number of zeros in N
Constraints :
0 <= N <= 10^9
Sample Input 1 :
0
Sample Output 1 :
1
Sample Input 2 :
00010204
Sample Output 2 :
2
Explanation for Sample Output 2 :
Even though "00010204" has 5 zeros, the output would still be 2 because when you convert it to an integer,
it becomes 10204.
Sample Input 3 :
708000
Sample Output 3 :
4

 */
public class CountZero {
    public static void main(String[] args) {
        int input = 10204;
//        System.out.println(0/10);
        System.out.println(countZerosRec(input));
    }
    public static int countZerosRec(int input) {
        if (input<10) {
            if (input==0) {
                return 1;
            } else
                return 0;
        }
        if (input % 10 == 0) {
            return countZerosRec(input / 10) + 1;
        } else {
            return countZerosRec(input/10);
        }
    }

    //my wrong logic
    public static int countZeroRec1(int input) {
        //base case
        if (input/10==0) {
            return 0;
        }
        int smallAns = countZeroRec1(input/10);
        if (smallAns%10==0) {
            smallAns++;
        }
        return smallAns;
    }
}

