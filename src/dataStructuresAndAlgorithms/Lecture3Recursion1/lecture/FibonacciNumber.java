package dataStructuresAndAlgorithms.Lecture3Recursion1.lecture;

public class FibonacciNumber {
    public static void main(String[] args) {
        int n=3;
        System.out.println(fib(50));
    }
    public static int fib(int n) {
        if (n==0 || n==1) {
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
}
