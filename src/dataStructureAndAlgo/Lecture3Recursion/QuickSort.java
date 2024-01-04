package dataStructureAndAlgo.Lecture3Recursion;

/*
Question : Quick Sort

Problem statement
Given the 'start' and the 'end'' positions of the array 'input'.
Your task is to sort the elements between 'start' and 'end' using quick sort.


Note :
Make changes in the input array itself.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6
2 6 8 5 4 3
Sample Output 1 :
2 3 4 5 6 8
Sample Input 2 :
5
1 2 3 5 7
Sample Output 2 :
1 2 3 5 7
Constraints :
1 <= N <= 10^3
0 <= input[i] <= 10^9
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] input = {2,6,8,5,4,3};
        int[] input = {6,2,20,8,15,3,4};
        print(input);
        quickSort(input,0, input.length-1);
        print(input);
    }
    public static void quickSort(int[] input, int startIndex, int endIndex) {
        if (startIndex>=endIndex) {
            return;
        }
        int pivotPosition = partition(input,startIndex,endIndex);
        quickSort(input,startIndex,pivotPosition-1);
        quickSort(input,pivotPosition+1,endIndex);
    }
    private static int partition(int[] input, int startIndex, int endIndex) {
        int pivot = input[startIndex];
        int count = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            if (input[i]<pivot) {
                count++;
            }
        }
        int pivotPosition = startIndex+count;
        int temp; //for swapping purpose
        temp = input[pivotPosition];
        input[pivotPosition] = input[startIndex];
        input[startIndex] = temp;

        int i = startIndex;
        int j = endIndex;

        while (i<pivotPosition && j>pivotPosition) {

            while (input[i]<input[pivotPosition]) {
                i++;
            }
            while (input[j]>input[pivotPosition]) {
                j--;
            }

            int swap = input[i];
            input[i] = input[j];
            input[j] = swap;
        }
        return pivotPosition;
    }
    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}