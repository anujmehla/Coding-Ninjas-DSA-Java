package dataStructureAndAlgo.test1;

/*
Question : Split Array
Problem statement
Given an integer array A of size N,
check if the input array can be divided in two groups G1 and G2 with following properties-

- Sum of both group elements are equal
- Group 1: All elements in the input, which are divisible by 5
- Group 2: All elements in the input, which are divisible by 3 (but not divisible by 5).
- Elements which are neither divisible by 5 nor by 3,
can be put in either group G1 or G2 to satisfy the equal sum property.
Group 1 and Group 2 are allowed to be unordered and all the elements in the Array A must belong to only one of the
groups.



Return true, if array can be split according to the above rules, else return false.

Note: You will get marks only if all the test cases are passed.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= N <= 50
Sample Input 1 :
2
1 2
Sample Output 1 :
false
Sample Input 2 :
3
1 4 3
Sample Output 2 :
true
 */
public class SplitArray {
    public static void main(String[] args) {
        int[] arr = {1,4,3};
        System.out.println(splitArray(arr));
    }

    public static boolean splitArray(int input[]) {
        int sumG1 = 0;
        int sumG2 = 0;

        // Preprocessing: Distribute elements divisible by 5 and by 3 (not by 5) to respective groups
        for (int value : input) {
            if (value % 5 == 0) {
                sumG1 += value;
            } else if (value % 3 == 0) {
                sumG2 += value;
            }
        }

        // Call the helper function to try placing the remaining elements
        return canSplitArray(input, 0, sumG1, sumG2);
    }
    private static boolean canSplitArray(int[] input, int index, int sumG1, int sumG2) {
        // Base case: If all elements have been considered, check for equal sums
        if (index == input.length) {
            return sumG1 == sumG2;
        }

        int value = input[index];

        // If the current element is divisible by 5 or 3, move to the next element
        if (value % 5 == 0 || value % 3 == 0) {
            return canSplitArray(input, index + 1, sumG1, sumG2);
        }

        // Try adding the current element to group G1 and see if a solution exists
        if (canSplitArray(input, index + 1, sumG1 + value, sumG2)) {
            return true;
        }

        // Try adding the current element to group G2 and see if a solution exists
        return canSplitArray(input, index + 1, sumG1, sumG2 + value);
    }

}
