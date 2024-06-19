package dataStructuresAndAlgorithms.Lecture3Recursion1;

public class NumberOfDigits {
    public static void main(String[] args) {
        int n = 12345;
        System.out.println(countDigits(n));
    }
    public static int countDigits(int n) {
        if (n==0) {
            return 0;
        }
        return countDigits(n/10)+1;
    }
}
//input  = 123
//output = 3 (as there are 3 digits 1,2,3)