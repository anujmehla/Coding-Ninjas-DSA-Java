package dataStructureAndAlgo.Lecture3Recursion;

public class CalculatePower {
    public static void main(String[] args) {
        int x = 3;
        int n = 4;
        System.out.println(power(x, n));
    }
    public static int power(int x, int n) {
        if (x==0 && n==0)
            return 1;
        if (n==0) {
            return 1;
        }
        if (x==0) {
            return 0;
        }

        return x * power(x, n - 1);
    }
}
//output expected = 81