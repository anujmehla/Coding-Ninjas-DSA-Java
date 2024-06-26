package dataStructuresAndAlgorithms.Lecture3Recursion1;

/*
Question : Last Index of Number
Given an array of length N and an integer x, you need to find and return the last index of integer x present in the array. Return -1 if it is not present in the array.
Last index means - if x is present multiple times in the array, return the index at which x comes last in the array.
You should start traversing your array from 0, not from (N - 1).
Do this recursively. Indexing in the array starts from 0.
Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Line 3 : Integer x
Output Format :
last index or -1
Constraints :
1 <= N <= 10^3
Sample Input :
4
9 8 10 8
8
Sample Output :
3
 */
public class LastIndexOfNumber {
    public static void main(String[] args) {
        int[] input = {9,8,10,8};
        int x = 8;
        System.out.println(lastIndex2(input, x));
    }
    public static int lastIndex(int[] input, int x) {
        return lastIndex(input,x,input.length-1);
    }
    //my solution
    private static int lastIndex(int[] input, int x, int lastIndex) {
        if (lastIndex==0) {
            return -1;
        }
        if (input[lastIndex] == x) {
            return lastIndex;
        }
        return lastIndex(input,x,lastIndex-1);
    }
    //their solution
    public static int lastIndex2(int[] input, int x) {
        return lastIndex2(input,x,0);
    }
    public static int lastIndex2(int[] input, int x, int startIndex) {
        if (startIndex==input.length) {
            return -1;
        }
        int smallAns = lastIndex2(input,x,startIndex+1);
        if (smallAns != -1) {
            return smallAns;
        }
        if (input[startIndex] == x) {
            return startIndex;
        } else {
            return -1;
        }
    }
}