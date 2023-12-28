package Lecture10SearchingAndSorting.Excercise;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter the size of the array");
//        int n = input.nextInt();
//        int array[] = new int[n];
//        System.out.println("Enter the elements of the array");
//        for (int i = 0; i < n; i++) {
//            array[i]= input.nextInt();
//        }
        int[] array = {1,3,7,9,11,12,45};
        print(array);
        System.out.println(search(array, 3));
    }
    public static int search(int nums[], int target) {
        int start = 0;
        int end = nums.length;

        while (start<end) {
            int midpoint = (start+end)/2;
            if (target==nums[midpoint]) {
                return midpoint;
            } else if (target>nums[midpoint]) {
                start = midpoint+1;
            } else {
                end = midpoint-1;
            }
        }

        return -1;
    }
    public static void print(int[] arr) {
        for (int element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }
}
//need to write algorithm whose time complexity is O(LogN)
//time limit is one second
//sample array = {1,3,7,9,11,12,45}
//target = 3
//output = 1