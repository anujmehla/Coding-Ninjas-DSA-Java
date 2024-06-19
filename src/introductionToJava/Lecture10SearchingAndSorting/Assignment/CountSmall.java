package introductionToJava.Lecture10SearchingAndSorting.Assignment;

public class CountSmall {
    public static void main(String[] args) {
        int[] a = {4,5,6,7};
        int n = a.length;
        int[] b = {6,7};
        int m = b.length;
        int[] c = countS(n,m,a,b);
        print(c);
    }
    public static int[] countS(int n, int m, int[] a, int[] b) {
        for (int i = 0; i < n; i++) {
        int count = 0;
            for (int j = 0; j < m; j++) {
                if (a[i]>=b[j]) {
                    count++;
                }
            }
            a[i]=count;
        }
        return a;
    }
    public static void print(int[] c) {
        for (int i : c) {
            System.out.print(i+" ");
        }
    }
}
//output : 1,1,0
/*
explanation : for each element of array A, we need to find elements smaller or equal to it
 */