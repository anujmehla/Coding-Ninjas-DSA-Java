package dataStructuresAndAlgorithms.Lecture3Recursion1;

public class RemoveX {
    public static void main(String[] args) {
        String str = "xxxxx";
        System.out.println(removeX(str));
    }
    public static String removeX(String str) {
        if (str.isEmpty()) {
            return str;
        }
        String ans = "";
        if (str.charAt(0) != 'x') {
            ans = ans + str.charAt(0);
        }
        String smallAns = removeX(str.substring(1));
        return ans+smallAns;
    }
}
