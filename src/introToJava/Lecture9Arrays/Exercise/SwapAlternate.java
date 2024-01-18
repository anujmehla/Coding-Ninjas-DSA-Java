package introToJava.Lecture9Arrays.Exercise;

import java.util.Scanner;

public class SwapAlternate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of queries");
        int numberOfQueries = input.nextInt();

        while (numberOfQueries>0) {
            System.out.println("Enter number of elements of an array");
            int numberOfElementsInTheArray = input.nextInt();
            int[] array = new int[numberOfElementsInTheArray];
            System.out.println("Enter the elements in the array.");
            for (int i=0; i<numberOfElementsInTheArray; i++) {
                array[i]=input.nextInt();
            }
            print(array);
            swapAlternate(array);
            print(array);
            numberOfQueries--;
        }
    }
    public static void swapAlternate(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (i%2!=0) {
                int temp2 = arr[i];
                int temp1 = arr[i-1];
                arr[i-1]=temp2;
                arr[i]=temp1;
            }
        }
    }
    public static void print(int[] input) {
        for (int i : input) {
            System.out.print(i+", ");
        }
        System.out.println();
    }
}

