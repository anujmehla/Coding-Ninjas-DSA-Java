package dataStructureAndAlgo.Lecture3Recursion.doubt;

public class GuessTheOutput {
    public static void main(String[] args) {
        int num = 3;
        print(num);
    }
    public static void print(int n) {
        if (n<0) {
            return;
        }
        if (n==0) {
            System.out.println(n);
            return;
        }
        print(n--);//the issue lies here, the value of n is not decreasing
        System.out.print(n+" ");
    }
}
