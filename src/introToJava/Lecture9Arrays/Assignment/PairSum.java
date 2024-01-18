package introToJava.Lecture9Arrays.Assignment;

public class PairSum {
    public static void main(String[] args) {
        int[] arr = {2,8,10,5,-2,5};
        int x = 10;
        System.out.println(pairSum(arr, x));
    }
    public static int pairSum(int[] arr, int x) {
        int pair=0;
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i]+arr[j]==x) {
                    pair++;
                }
            }
        }
        return pair;
    }
}