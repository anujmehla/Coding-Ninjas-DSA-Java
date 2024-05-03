package dataStructureAndAlgo.Lecture7OOPS.assignment;

import java.util.Arrays;

/*
Question : Pair sum in array
Problem statement
You have been given an integer array/list(ARR) and a number 'num'.
Find and return the total number of pairs in the array/list which sum to 'num'.

Note:
Given array/list can contain duplicate elements.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= N <= 10^4
0 <= num <= 10^9

Time Limit: 1 sec
Sample Input 1:
1
9
1 3 6 2 5 4 3 2 4
7
Sample Output 1:
7
Sample Input 2:
2
9
1 3 6 2 5 4 3 2 4
12
6
2 8 10 5 -2 5
10
Sample Output 2:
0
2


 Explanation for Input 2:
Since there doesn't exist any pair with sum equal to 12 for the first query, we print 0.

For the second query, we have 2 pairs in total that sum up to 10. They are, (2, 8) and (5, 5).
 */
public class PairSumInArray {
    public static void main(String[] args) {
        int[] arr = {1,3,6,2,5,4,3,2,2,4,5};
        System.out.println(pairSum(arr, 8));
    }
    //my solution
    //time complexity = O(n^2)
    public static int pairSum(int[] arr, int num) {
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == num) {
                    count++;
                }
            }
        }
        return count;
    }
    //their solution
    /*
    Time Complexity : O(n * log(n))
    Space Complexity : O(1)
    Where 'n' is the size of the Array/List
    */
    // this is two pointer approach
    public static int pairSum1(int[] arr, int num) {
        Arrays.sort(arr);

        int startIndex = 0;
        int endIndex = (arr.length - 1);
        int numPair = 0;

        while (startIndex < endIndex) {
            if (arr[startIndex] + arr[endIndex] < num) {
                startIndex++;
            } else if (arr[startIndex] + arr[endIndex] > num) {
                endIndex--;
            } else {
                int elementAtStart = arr[startIndex];
                int elementAtEnd = arr[endIndex];

                if (elementAtStart == elementAtEnd) {
                    int totalElementsFromStartToEnd = (endIndex - startIndex)+1;
                    numPair += (totalElementsFromStartToEnd * (totalElementsFromStartToEnd-1)/2);

                    return numPair;
                }
                int tempStartIndex = startIndex+1;
                int tempEndIndex = endIndex-1;

                while (tempStartIndex <= tempEndIndex && arr[tempStartIndex] == elementAtStart) {
                    tempStartIndex++;
                }
                while (tempEndIndex >= tempStartIndex && arr[tempEndIndex] == elementAtEnd) {
                    tempEndIndex--;
                }

                int totalElementsFromStart = (tempStartIndex - startIndex);
                int totalElementsFromEnd = (endIndex - tempEndIndex);

                numPair += (totalElementsFromStart * totalElementsFromEnd);

                startIndex = tempStartIndex;
                endIndex = tempEndIndex;
            }
        }
        return numPair;
    }
}
