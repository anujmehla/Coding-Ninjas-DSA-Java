package Lecture11Strings.Assignment;

public class RemoveConsecutiveDuplicates {
    public static void main(String[] args) {
        String str = "aaaadaa";
        System.out.println(removeConsecutiveDuplicates(str));
    }
    public static String removeConsecutiveDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for (int i=1; i<str.length(); i++) {
            if (str.charAt(i)!=str.charAt(i-1)) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    public static String removeConsecutiveDuplicates1(String str) {
        str+=" ";
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<str.length()-1; i++) {
            if (str.charAt(i)!=str.charAt(i+1)) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
//input  = aaaaa
//output = a