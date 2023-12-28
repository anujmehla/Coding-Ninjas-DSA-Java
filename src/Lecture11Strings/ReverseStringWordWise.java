package Lecture11Strings;

public class ReverseStringWordWise {
    public static void main(String[] args) {
        String input = "Welcome to coding Ninjas";
        System.out.println(reverseWordWise(input));
    }
    public static String reverseWordWise(String input) {
        String[] strArray = input.split(" ");
        StringBuffer sb = new StringBuffer("");
        for (int i=strArray.length-1; i>=0; i--) {
            sb.append(strArray[i]+' ');
        }
        return sb.toString();
    }
}
//expected output : Ninjas Coding to Welcome