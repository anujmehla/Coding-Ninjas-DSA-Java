package dataStructureAndAlgo.Lecture3Recursion1;

public class SumOfArray {
    public static void main(String[] args) {
        int[] input = {9,8,9};
        System.out.println(sum(input));
    }
    //my attempt
    public static int sum1(int[] input) {
        if (input.length<=0) {
            return 0;
        }
        int[] smallAns = new int[input.length-1];
        for (int i=1; i< input.length; i++) {
            smallAns[i-1]=input[i];
        }
        return sum1(smallAns)+input[0];
    }
    public static int sum(int input[], int startIndex) {
        if (startIndex == input.length) {
            return 0;
        }
        return input[startIndex]+sum(input,startIndex+1);
    }
    public static int sum(int[] input) {
        return sum(input,0);
    }
}
