package introToJava.Lecture10SearchingAndSorting.Excercise;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {2,13,4,1,3,6,28};
        print(arr);
        insertionSort(arr, arr.length);
        print(arr);
    }
    public static void insertionSort(int[] arr, int size) {
       for(int i=1; i< arr.length; i++) {
           int j=i-1;
           int temp = arr[i];
           while (j>=0 && arr[j]>temp) {
               arr[j+1] = arr[j];
               j--;
           }
           arr[j+1] = temp;
       }
    }
    public static void print(int[] arr) {
        for (int element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }
}
