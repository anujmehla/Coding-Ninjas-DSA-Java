package dataStructureAndAlgo.Lecture3Recursion.doubt;

public class CheckSorted {
    public static void main(String[] args) {
        int[] input = {2,1,3,6,9};
        System.out.println(checkSorted2(input));
    }
    public static boolean checkSorted(int[] input) {
        if (input.length<=1) {
            return true;
        }
        int smallInput[] = new int[input.length-1];
        for (int i=1; i< input.length; i++) {
            smallInput[i-1] = input[i];
        }
        boolean smallAns = checkSorted(smallInput);
        if (!smallAns==true) {
            return false;
        }
        if (input[0] <= input[1]) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkSorted2(int[] input) {
      if(input.length<=1) {
          return true;
      }
      if (input[0]>input[1]) {
          return false;
      }
      int[] smallInput = new int[input.length-1];
      for (int i=1; i< input.length; i++) {
          smallInput[i-1]=input[i];
      }
      return checkSorted2(smallInput);
    }
}
