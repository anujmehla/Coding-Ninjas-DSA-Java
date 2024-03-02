package dataStructureAndAlgo.Lecture3Recursion1;


/*
Question : A string is given, you need to find it's all subsequences
subsequence is different from subString
String str = "xyz"
subsequence = {"", x, y, z, yz, xy, xz, xyz}

 */
public class PrintSubsequences {

    public static void main(String[] args) {
        printSubsequences("xyz");
    }
    public static void printSubsequences(String input) {
        printSubsequences(input,"");
    }
    public static void printSubsequences(String input, String outputSoFar) {
        if (input.isEmpty()) {
            System.out.println(outputSoFar);
            return;
        }
        // we choose not to include the first character
        printSubsequences(input.substring(1),outputSoFar);
        // we choose to include first character
        printSubsequences(input.substring(1),outputSoFar+input.charAt(0));
    }
}
