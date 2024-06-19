package dataStructuresAndAlgorithms.Lecture4Recursion2.lecture;

/*
Question : Merge Sort Code
You are given the starting 'l' and the ending 'r' positions of the array 'ARR'.


You must sort the elements between 'l' and 'r'.


Note:
Change in the input array itself. So no need to return or print anything.
Example:
Input: ‘N’ = 7,
'ARR' = [2, 13, 4, 1, 3, 6, 28]

Output: [1 2 3 4 6 13 28]

Explanation: After applying 'merge sort' on the input array, the output is [1 2 3 4 6 13 28].
Input format :
The first line contains an integer <em>**'N'**</em> representing the size of the array/list.

The second line contains 'N' single space-separated integers representing the elements in the array/list.
Output format :
You don't need to return anything. In the output, you will see the array after you do the modification.
Sample Input 1:
7
2 13 4 1 3 6 28
Sample Output 1:
1 2 3 4 6 13 28
Explanation of Sample Output 1:
After applying 'merge sort' on the input array, the output is [1 2 3 4 6 13 28].
Sample Input 2:
5
9 3 6 2 0
Sample Output 2:
0 2 3 6 9
Explanation of Sample Output 2:
After applying 'merge sort' on the input array, the output is [0 2 3 6 9].
Constraints :
1 <= N <= 10^3
0 <= ARR[i] <= 10^9
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2,13,4,1,3,6,28};
        print(arr);
        mergeSort(arr,0, arr.length-1);
        print(arr);
    }
    public static void mergeSort(int[] arr,int sI, int eI) {
        if (sI>=eI) {
            return;
        }
        int mid = (sI+eI)/2;
        //part1
        mergeSort(arr,sI,mid);
        //part2
        mergeSort(arr,mid+1,eI);
        merge(arr, sI, eI);
    }
    private static void merge(int[] input, int sI, int eI) {
        int mid = (sI+eI)/2;
        int[] ans = new int[eI-sI+1];
        int i = sI;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= eI) {
            if (input[i]<input[j]) {
                ans[k] = input[i];
                i++;
                k++;
            } else {
                ans[k] = input[j];
                k++;
                j++;
            }
        }
        while (i <= mid) {
            ans[k] = input[i];
            i++;
            k++;
        }
        while (j <= eI) {
            ans[k] = input[j];
            k++;
            j++;
        }
        for (int index = 0; index < ans.length; index++) {
            input[sI + index] = ans[index];
        }
    }
    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
