package dataStructureAndAlgo.Lecture3Recursion1;

public class PrintNumbers {
    public static void main(String[] args) {
        int n = 1;
        print(n);
    }
    public static void print(int n) {
        if (n==0) {
            return;
        }
        print(n-1);
        System.out.print(n+" ");
    }
}
//input n = 6
//output = 1,2,3,4,5,6