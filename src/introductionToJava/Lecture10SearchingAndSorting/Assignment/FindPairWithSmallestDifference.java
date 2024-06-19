package introductionToJava.Lecture10SearchingAndSorting.Assignment;

public class FindPairWithSmallestDifference {
    public static void main(String[] args) {
        int[] a = {10,20,30};
        int[] b = {17,15};
        int c = smallestDifferencePair(a,a.length,b, b.length);
        System.out.println(c);
    }
    public static int smallestDifferencePair(int[] arr1, int n, int[] arr2, int m) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int diff = arr1[i]-arr2[j];
                if (diff<0) {
                    diff*=-1;
                }
                if (diff < min) {
                    min = diff;
                }
            }
        }
        return min;
    }
}
