package introToJava.Lecture10SearchingAndSorting.Excercise;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {2,13,4,1,3,6,28};
        print(arr);
        bubbleSort(arr,arr.length);
        print(arr);
    }
    public static void bubbleSort(int arr[], int n) {
        for(int i=0; i< arr.length; i++) {
            for (int j=0; j< arr.length-1; j++) {
                if (arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void print(int arr[]) {
        for (int element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }
}
