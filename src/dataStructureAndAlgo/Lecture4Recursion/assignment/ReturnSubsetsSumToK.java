package dataStructureAndAlgo.Lecture4Recursion.assignment;

/*
Question : Return subsets sum to K
Problem statement
Given an array A of size n and an integer K, return all subsets of A which sum to K.

Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.


Note :
The order of subsets are not important.


Detailed explanation ( Input/output format, Notes, Images )
Input format :
Line 1 : Integer n, Size of input array
Line 2 : Array elements separated by space
Line 3 : K
Constraints :
1 <= n <= 20

Sample Input :
9
5 12 3 17 1 18 15 3 17
6
Sample Output :
3 3
5 1
 */
public class ReturnSubsetsSumToK {
    public static void main(String[] args) {
        int[] input = {5,12,3,17,1,18,15,3,17};
        int k = 6;
        int[][] result = subsetsSumK(input,k);
        print(result);
    }
    public static int[][] subsetsSumK(int input[],int k) {
        //write your code here


        return new int[][]{{},{}};
    }



    public static void print(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
