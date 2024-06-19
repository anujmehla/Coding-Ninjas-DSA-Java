package introductionToJava.Lecture11Strings;

public class ReverseString {
    public static void main(String[] args) {
        String str = "abcde";
        System.out.println(reverseString(str));
    }
    public static String reverseString(String str) {
        //one way of doing it
//        char[] charArray = str.toCharArray();
//        StringBuilder sb = new StringBuilder();
//        for (int i= charArray.length-1; i>=0; i--) {
//            sb.append(charArray[i]);
//        }
//        return sb.toString();
        //another way
//        String reverseString = "";
//        for (int i =str.length()-1; i>=0; i--) {
//            reverseString +=str.charAt(i);
//        }
//        return reverseString;
        // now we have to reverse the String but the catch is we've to move from 0 to str.length
        String reverseString = "";
        for (int i=0; i<str.length(); i++) {
            reverseString = str.charAt(i) + reverseString;
        }
        return reverseString;
    }
}
