package introductionToJava.Lecture9Arrays.Exercise;

public class ArrangeNumbersInArray {
    public static void main(String[] args) {
        int n = 7;
        int[] arr = new int[n];
        arrange(arr,n);
        print(arr);
    }
    public static void arrange(int[] arr, int n) {
        int pointerA = 0;
        int pointerB = n-1;
        int element = 1;
        while (pointerA<pointerB) {
            arr[pointerA++] = element++;
            arr[pointerB--] = element++;
        }
        if (n%2==1) {
            arr[pointerA] = element;
        }
    }
    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
//output = 135642