package dataStructureAndAlgo.Lecture3Recursion1;

public class Factorial {
    public static void main(String[] args) {
        int num = 3;
        System.out.println(fact(num));

    }
    public static int fact(int num) {
        //base case
        if (num == 0) {
            return 1;
        }
        num*=fact(num-1);

        return num;
    }
}
