package dataStructureAndAlgo.Lecture6TimeandSpaceComplexityAnalysis.assignment;

import java.util.HashMap;
import java.util.Map;

/*
Question : Duplicate in array
Problem statement
You have been given an integer array/list(ARR) of size N which contains numbers from 0 to (N - 2).
Each number is present at least once.
That is, if N = 5, the array/list constitutes values ranging from 0 to 3, and among these,
there is a single integer value that is present twice.
You need to find and return that duplicate number present in the array.

Note :
Duplicate number is always present in the given array/list.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= N <= 10^6

Time Limit: 1 sec
Sample Input 1:
1
9
0 7 2 5 4 7 1 3 6
Sample Output 1:
7
Sample Input 2:
2
5
0 2 1 3 1
7
0 3 1 5 4 3 2
Sample Output 2:
1
3
 */
public class DuplicateInArray {
    public static void main(String[] args) {
        int[] arr = {0,7,2,5,4,7,1,3,6};
        System.out.println(findDuplicate(arr));
    }
    /*
    Time complexity = O(n)
    Space complexity = O(1)
    where 'n' is the size of the arraylist
     */
    public static int findDuplicate(int[] arr) {
        int sumOfElements = 0;
        for (int i = 0; i < arr.length; i++) {
            sumOfElements = sumOfElements+arr[i];
        }
        int sumOfNMinusTwoNaturalNumbers = ((arr.length-2)*(arr.length-1)/2);
        return sumOfElements - sumOfNMinusTwoNaturalNumbers;
    }
}
