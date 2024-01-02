package dataStructureAndAlgo.Lecture3Recursion;

/*
Question : All Indices of Number
Given an array of length N and an integer x, you need to find all the indexes where x is present in the input array.
Save all the indexes in the output array (in increasing order).
Do this recursively. Indexing in the array starts from 0.
Hint:
Try making a helper function with the required arguments and call the helper function from the allIndexes function.
Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Line 3 : Integer x
Output Format :
Return all the indexes in the output array (in increasing order).
Constraints :
1 <= N <= 10^3
Sample Input :
5
9 8 10 8 8
8
Sample Output :
1 3 4
 */
public class AllIndicesOfNumber {
    public static void main(String[] args) {
        int input[] = {9,8,10,8,8};
        int x = 8;
        int[] ans =allIndexes(input,x);
        print(ans);
    }
    public static int[] allIndexes(int[] input, int x) {
        return allIndexes(input,x,0);
    }
    public static int[] allIndexes(int[] input, int x, int startIndex) {
        if (startIndex==input.length) {
            return new int[0];
        }
        int[] smallOutput = allIndexes(input,x,startIndex+1);
        if (input[startIndex] == x) {
            int[] output = new int[smallOutput.length + 1];
            output[0] = startIndex;
            for (int i = 0; i < smallOutput.length; i++) {
                output[i + 1] = smallOutput[i];
            }
            return output;
        } else {
            return smallOutput;
        }
    }
    private static void print(int[] input) {
        for (int i : input) {
            System.out.print(i+" ");
        }
    }
}