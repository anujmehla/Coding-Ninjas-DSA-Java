package dataStructuresAndAlgorithms.Lecture3Recursion1;

public class CheckNumberInArray {
    public static void main(String[] args) {
        int[] input = {9,8,10};
        int x = 8;
        System.out.println(checkNumber(input, x));
    }
    //my attempt
    public static boolean checkNumber1(int[] input, int x) {
        if (input.length==0) {
            return false;
        }
        if (input[0]==x) {
            return true;
        } else{
            int[] smallAns = new int[input.length-1];
            for (int i=1; i< input.length; i++) {
                smallAns[i-1]=input[i];
            }
             boolean ans =checkNumber1(smallAns,x);
            if (ans) {
                return true;
            }
        }
        return false;
    }
    //solution to this question
    public static boolean checkNumber(int[] input, int x) {
        return checkNumber(input,x,0);
    }
    public static boolean checkNumber(int[] input, int x, int startIndex) {
        if (input.length==startIndex) {
            return false;
        }
        if (input[startIndex]==x) {
            return true;
        }
        return checkNumber(input,x,startIndex+1);
    }
}