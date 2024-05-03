package dataStructureAndAlgo.Lecture7OOPS.assignment;

import java.util.Arrays;

/*
Question : Triplet Sum
Problem statement
You have been given a random integer array/list(ARR) and a number X.
Find and return the triplet(s) in the array/list which sum to X.

Note :
Given array/list can contain duplicate elements.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^2
0 <= N <= 10^3
0 <= X <= 10^9

Time Limit: 1 sec
Sample Input 1:
1
7
1 2 3 4 5 6 7
12
Sample Output 1:
5
Sample Input 2:
2
7
1 2 3 4 5 6 7
19
9
2 -5 8 -6 0 5 10 11 -3
10
Sample Output 2:
0
5


 Explanation for Input 2:
Since there doesn't exist any triplet with sum equal to 19 for the first query, we print 0.

For the second query, we have 5 triplets in total that sum up to 10.
They are, (2, 8, 0), (2, 11, -3), (-5, 5, 10), (8, 5, -3) and (-6, 5, 11)
 */
public class TripletSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(tripletSum(arr, 12));
    }
    // my solution
    // time complexity is O(n^3), time limit exceeds
    public static int tripletSum(int[] arr, int num) {
        int count = 0;
        for (int i = 0; i < arr.length-2; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == num) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    //some other solution
    public static int tripletSum1(int[] arr, int num) {
        Arrays.sort(arr);
        int n = arr.length;

        int numTriplets = 0;

        for (int i=0; i<n; i++) {
            int pairSum = num - arr[i];
            int numPairs = 0;

            int start = i + 1;
            int stop = n - 1;

            while (start < stop) {
                if (arr[start] + arr[stop] < pairSum) {
                    start++;
                } else if (arr[start] + arr[stop] > pairSum) {
                    stop--;
                } else {
                    if (arr[start] == arr[stop]) {
                        int totalCount = (stop - start) + 1;
                        numPairs += (totalCount * (totalCount - 1) / 2);
                        break;
                    }

                    int tempI = start + 1;
                    int tempJ = stop - 1;

                    while (tempI <= tempJ && arr[start] == arr[tempI]) {
                        tempI++;
                    }

                    while (tempI <= tempJ && arr[stop] == arr[tempJ]) {
                        tempJ--;
                    }

                    int totalElementFromStart = (tempI - start);
                    int totalElementFromEnd = stop - tempJ;

                    numPairs += (totalElementFromStart * totalElementFromEnd);

                    start = tempI;
                    stop = tempJ;
                }
            }
            numTriplets += numPairs;
        }
        return numTriplets;
    }

    //their solution
    //time complexity = O(n^2)
    //space complexity = O(n)
    // where n is the size of the array/list
    public static int tripletSum2(int[] arr, int num) {
        Arrays.sort(arr);
        int n = arr.length;

        int numTriplets = 0;

        for (int i = 0; i < n; i++) {
            int pairSumFor = num - arr[i];
            int numPairs = pairSum(arr,(i+1),(n-1),pairSumFor);
            numTriplets += numPairs;
        }
        return numTriplets;
    }

    private static int pairSum(int[] arr, int startIndex, int endIndex, int num) {
        int numPair = 0;
        while (startIndex < endIndex) {
            if (arr[startIndex] + arr[endIndex] < numPair) {
                startIndex++;
            } else if (arr[startIndex] + arr[endIndex] > num) {
                endIndex--;
            } else {
                int elementAtStart = arr[startIndex];
                int elementAtEnd = arr[endIndex];

                if (elementAtStart == elementAtEnd) {
                    int totalElementsFromStartToEnd = (endIndex - startIndex) + 1;
                    numPair += (totalElementsFromStartToEnd)* (totalElementsFromStartToEnd-1)/2;

                    return numPair;
                }
                int tempStartIndex = startIndex+1;
                int tempEndIndex = endIndex - 1;

                while (tempStartIndex <= tempEndIndex && arr[tempStartIndex] == elementAtStart) {
                    tempStartIndex += 1;
                }
                while (tempEndIndex >= tempStartIndex && arr[tempEndIndex] == elementAtEnd) {
                    tempEndIndex -=1;
                }
                int totalElementsFromStart = (tempStartIndex -startIndex);
                int totalElementFromEnd = (endIndex - tempEndIndex);

                num += (totalElementsFromStart * totalElementFromEnd);

                startIndex = tempStartIndex;
                endIndex = tempEndIndex;
            }
        }
        return numPair;
    }
}
