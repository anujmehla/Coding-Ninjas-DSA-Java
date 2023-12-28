package Lecture10SearchingAndSorting.Excercise;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1,3,4,7,11};
        int[] arr2 = {2,4,6,13};
        int[] arr3 = merge(arr1, arr2);
        print(arr3);

    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int ans[] = new int[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                ans[k] = arr1[i];
                k++;
                i++;
            } else {
                ans[k] = arr2[j];
                j++;
                k++;
            }
        }
        while (i < arr1.length) {
            ans[k] = arr1[i];
            k++;
            i++;
        }
        while (j < arr2.length) {
            ans[k] = arr2[j];
            k++;
            j++;
        }

        return ans;
    }
    public static void print(int[] arr) {
        for (int element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }
}
