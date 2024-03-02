package dataStructureAndAlgo.Lecture4Recursion2.assignment;

/*
Question : Return Subset of an array
Problem statement
Given an integer array (of length n), find and return all the subsets of input array.

NOTE: Subsets are of length varying from 0 to n, that contain elements of the array.
But the order of elements should remain same as in the input array.

Note :
The order of subsets are not important.


Detailed explanation ( Input/output format, Notes, Images )
Input format :

Line 1 : Size of array

Line 2 : Array elements (separated by space)

Expected Time Complexity: O(2^N), where N is the size of given array
Sample Input:
3
15 20 12
Sample Output:
[] (this just represents an empty array, don't worry about the square brackets)
12
20
20 12
15
15 12
15 20
15 20 12
 */
public class ReturnSubsetOfAnArray {
    public static void main(String[] args) {
        int[] input = {15,20,12};
        int[][] result = subsets(input);
        print(result);
    }
    public static int[][] subsets(int[] input) {
        //write your code here
        return subsetsHelper(input,0);
    }
    private static int[][] subsetsHelper(int[] input, int start) {
        if (start == input.length) {
            // Base case: return an array with an empty subset
            return new int[1][0];
        }

        // Recursive call for the rest of the array
        int[][] smallOutput = subsetsHelper(input, start + 1);
        int[][] output = new int[smallOutput.length * 2][];

        // Copy subsets without current element
        for (int i = 0; i < smallOutput.length; i++) {
            output[i] = new int[smallOutput[i].length];
            System.arraycopy(smallOutput[i], 0, output[i], 0, smallOutput[i].length);
        }

        // Copy subsets with current element
        for (int i = 0; i < smallOutput.length; i++) {
            output[i + smallOutput.length] = new int[smallOutput[i].length + 1];
            output[i + smallOutput.length][0] = input[start];
            System.arraycopy(smallOutput[i], 0, output[i + smallOutput.length], 1, smallOutput[i].length);
        }
        return output;
    }

    //their solution
    public static int[][] subsetsHelper1(int[] input, int startIndex) {
        if (startIndex == input.length) {
            int[][] output = new int[1][0];
            return output;
        }
        int[][] smallerOutput = subsetsHelper1(input, startIndex+1);
        int[][] output = new int[2* smallerOutput.length][];

        int k = 0;
        for (int i = 0; i < smallerOutput.length; i++) {
            output[k] = new int[smallerOutput[i].length];
            for (int j = 0; j < smallerOutput[i].length; j++) {
                output[k][j] = smallerOutput[i][j];
            }
            k++;
        }
        for (int i = 0; i < smallerOutput.length; i++) {
            output[k] = new int[smallerOutput[i].length+1];
            output[k][0] = input[startIndex];
            for (int j = 0; j < smallerOutput[i].length; j++) {
                output[k][j] = smallerOutput[i][j-1];
            }
            k++;
        }
        return output;
    }
    public static int[][] subsets1(int input[]) {
        return subsetsHelper1(input,0);
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
