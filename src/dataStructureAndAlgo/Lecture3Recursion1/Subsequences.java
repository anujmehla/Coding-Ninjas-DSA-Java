package dataStructureAndAlgo.Lecture3Recursion1;

/*
Question : A string is given, you need to find it's all subsequences
subsequence is different from subString
String str = "xyz"
subsequence = {"", x, y, z, yz, xy, xz, xyz}

 */
public class Subsequences {
    public static void main(String[] args) {
        String str = "xyz";
        String[] ans = findSubsequences(str);
        print(ans);
        System.out.println("\n Length of Answer Array is : "+ans.length);
    }
    public static String[] findSubsequences(String str) {
        //base case
        if (str.isEmpty()) {
            return new String[]{""};
        }

        String[] smallAns = findSubsequences(str.substring(1));
        String[] ans = new String[2*smallAns.length];

        for (int i = 0; i < smallAns.length; i++) {
            ans[i] = smallAns[i];
        }
        for (int i = 0; i < smallAns.length; i++) {
            ans[i+ smallAns.length] = str.charAt(0) + smallAns[i];
        }
        return ans;
    }
    public static void print(String[] str) {
        for (String s : str) {
            System.out.print(s+" ");
        }
    }
}
