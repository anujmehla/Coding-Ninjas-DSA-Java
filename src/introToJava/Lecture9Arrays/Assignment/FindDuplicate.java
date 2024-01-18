package introToJava.Lecture9Arrays.Assignment;

import java.util.*;

public class FindDuplicate {
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
            System.out.println(duplicateNumber(array));
            numberOfQueries--;
        }
    }
    public static int duplicateNumber(int[] arr) {
        int duplicateNumber = 0;
//        Map<Integer,Integer> countMap = new HashMap<>();
//        for (int element : arr) {
//            countMap.put(element,countMap.getOrDefault(element,0)+1);
//        }
//        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
//            if (entry.getValue()==2) {
//                duplicateNumber = entry.getKey();
//            }
//        }
        Set<Integer> seen = new HashSet<>();
        for (int element : arr) {
            if (!seen.add(element)) {
                duplicateNumber= element;
            }
        }
        return duplicateNumber;
    }
    public static void print(int[] array) {
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i]+", ");
        }
        System.out.println();
    }
}
