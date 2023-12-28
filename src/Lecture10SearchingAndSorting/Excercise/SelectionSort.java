package Lecture10SearchingAndSorting.Excercise;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {8,6,2,5,1};
        print(arr);
        selectionSort(arr);
        print(arr);
    }
    public static void selectionSort(int[] arr) {
        for (int i=0; i< arr.length-1; i++) {
            //we have assumed that first element is the minimum
            int min = arr[i];
            int minIndex = i;
            for (int j=i+1; j< arr.length; j++) {
                if (arr[j]<min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex!=i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
    private static void print(int[] arr) {
        for (int element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }
}
