package dataStructureAndAlgo.Lecture8LinkedList1.lecture;

import java.util.ArrayList;

public class RemoveConsecutiveDuplicates {
    public static void main(String[] args) {
        int[] arr = {10,10,20,20,20,30,40,50};
        printArray(arr);
        ArrayList<Integer> result = removeConsecutiveDuplicates(arr);
        System.out.println();
        print(result);
    }
    public static ArrayList<Integer> removeConsecutiveDuplicates(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                result.add(arr[i]);
            }
        }
        return result;
    }
    public static void print(ArrayList<Integer> arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
