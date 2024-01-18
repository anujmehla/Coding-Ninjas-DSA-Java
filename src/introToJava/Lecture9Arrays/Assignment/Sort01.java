package introToJava.Lecture9Arrays.Assignment;

public class Sort01 {
    public static void main(String[] args) {
        int[] arr = {0,1,1,0,1,0,1};
        sortZeroesAndOne(arr);
    }
    public static void sortZeroesAndOne(int[] arr) {
        // Initialize two pointers.
        // `left` will be at the start of the array and `right` will be at the end of the array.
        int left = 0, right = arr.length - 1;

        // Use a while loop to iterate until the two pointers meet.
        while (left < right) {
            // If the left pointer encounters a 0, just move to the next element.
            if (arr[left] == 0) {
                left++;
            }
            // If the right pointer encounters a 1, just move to the previous element.
            else if (arr[right] == 1) {
                right--;
            }
            // If there is a 1 at the left pointer and a 0 at the right pointer, swap them.
            else {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
        // Since the question specifies no need to return or print anything,
        // we don't need any return statement here.

    }
}
