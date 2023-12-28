package Lecture11Strings.Assignment;

public class RemoveCharacter {
    public static void main(String[] args) {
        String str = "aabccbaa";
        char ch = 'a';
        System.out.println(removeAllOccurrencesOfChar(str, ch));
    }
    public static String removeAllOccurrencesOfChar(String str, char ch) {
        int n = str.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != ch) {
                ans+=str.charAt(i);
            }
        }
        return ans;
    }
    public static String removeAllOccurrencesOfCharMyAttempt(String str, char ch) {
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i]!=ch) {
                sb.append(charArray[i]);
            }
        }
        return sb.toString();
    }
}
//input  = aabccbaa, char = a
//output = bccb