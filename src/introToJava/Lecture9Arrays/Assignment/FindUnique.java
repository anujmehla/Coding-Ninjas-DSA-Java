package introToJava.Lecture9Arrays.Assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindUnique {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of queries");
        int numberOfQueries = input.nextInt();

        while (numberOfQueries>0) {
            System.out.println("Enter the size of the list");
            int numberOfElementsInTheArray = input.nextInt();
            int[] array = new int[numberOfElementsInTheArray];
            System.out.println("Enter the elements of the array");
            for (int i=0; i<numberOfElementsInTheArray; i++) {
                array[i] = input.nextInt();
            }
            print(array);
            System.out.println(findUnique(array));
            numberOfQueries--;
        }
    }
    public static int findUnique(int[] arr) {
        int uniqueElement = 0;
//        for (int element : arr) {
//            uniqueElement ^= element;
//        }
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int element : arr) {
            countMap.put(element,countMap.getOrDefault(element,0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return uniqueElement;
    }

    public static void print(int[] array) {
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i]+", ");
        }
        System.out.println();
    }
}
/*
using xor we can solve this problem
for two similar bits xor ^ returns 0
for two different bits   ^ returns 1
Two more important operations
1. XOR of a number with itself is zero.
2. XOR of a number with 0 is the number itself.
*/