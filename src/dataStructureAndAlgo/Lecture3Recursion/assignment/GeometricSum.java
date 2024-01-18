package dataStructureAndAlgo.Lecture3Recursion.assignment;

/*
Question : Geometric Sum
Problem statement
Given k, find the geometric sum i.e.

1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k)
Note :
using recursion.
Detailed explanation ( Input/output format, Notes, Images )
Input format :
Integer k
Output format :
Geometric sum (upto 5 decimal places)
Constraints :
0 <= k <= 1000
Sample Input 1 :
3
Sample Output 1 :
1.87500
Sample Input 2 :
4
Sample Output 2 :
1.93750
Explanation for Sample Input 1:
1+ 1/(2^1) + 1/(2^2) + 1/(2^3) = 1.87500
 */

public class GeometricSum {
    public static void main(String[] args) {
        System.out.println(findGeometricSum2(3));
    }
    //my solution
    public static double findGeometricSum(int k) {
        if (k==0) {
            return 1;
        }
        double ans = findGeometricSum(k-1);
        ans += 1/(Math.pow(2,k));
        return ans;
    }
    //their solution
    public static double findGeometricSum2(int k) {
        if (k==0) {
            return 1;
        }
        return findGeometricSum2(k-1)+1/Math.pow(2,k);
    }
}
