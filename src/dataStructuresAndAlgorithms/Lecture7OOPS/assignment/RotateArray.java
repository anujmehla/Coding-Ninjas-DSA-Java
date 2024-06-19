package dataStructuresAndAlgorithms.Lecture7OOPS.assignment;

/*
Question : Rotate Array
Problem statement
You have been given a random integer array/list(ARR) of size N.
Write a function that rotates the given array/list by D elements(towards the left).

 Note:
Change in the input array/list itself.You don't need to return or print the elements.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= t <= 10^4
0 <= N <= 10^6
0 <= D <= N
Time Limit: 1 sec
Sample Input 1:
1
7
1 2 3 4 5 6 7
2
Sample Output 1:
3 4 5 6 7 1 2
Sample Input 2:
2
7
1 2 3 4 5 6 7
0
4
1 2 3 4
2
Sample Output 2:
1 2 3 4 5 6 7
3 4 1 2
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        print(arr);
        rotate2(arr,2); // 3 4 5 6 7 1 2
        System.out.println();
        print(arr);
    }

    //my solution // 2 test cases failed due to time limit exceeded
    public static void rotate(int[] arr, int d) {
        int temp = 0;
        while (d > 0) {
            temp = arr[0];
            for (int i = 0; i < arr.length-1; i++) {
                arr[i] = arr[i+1];
            }
            arr[arr.length-1] = temp;
            d--;
        }
    }
    //better approach => passed all test cases
    public static void rotate1(int[] arr, int d) {
        int[] temp = new int[d];
        //first d values
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        //values changed
        for (int i = 0; i < arr.length-d; i++) {
            arr[i] = arr[i+d];
        }
        //remaining values
        for (int i = 0; i < temp.length; i++) {
            arr[i+arr.length-d] = temp[i];
        }
    }

    //best approach => reverse the complete array and then again reverse n-d array and last d array again
    public static void rotate2(int[] arr, int d) {
        reverse(arr,0, arr.length);
        reverse(arr,0, arr.length-d);
        reverse(arr,arr.length-d, arr.length);
    }

    public static void reverse(int[] array, int startIndex, int endIndex) {
        for (int i = startIndex, j = endIndex - 1; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }


    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
