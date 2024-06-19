package introductionToJava.Lecture11Strings;

public class CheckPalindrome {
    public static void main(String[] args) {
        String str = "abxba";
        System.out.println(isPalindrome(str));
        String str2 = "abda";
        System.out.println(isPalindrome(str2));
    }
    public static boolean isPalindrome(String str) {
        //one way of doing it
//        String reverseString = "";
//        for (int i = 0; i < str.length(); i++) {
//            reverseString = str.charAt(i)+reverseString;
//        }
//        if (reverseString.equals(str)) {
//            return true;
//        }
//        return false;
        // another more optimized way
//        for (int i=0; i<str.length()/2; i++) {
//            if (str.charAt(i)!=str.charAt(str.length()-i-1)){
//                return false;
//            }
//        }
        //third way using while loop
        int i=0;
        int j=str.length()-1;
        while (str.length()/2!=i) {
            if (str.charAt(i)!=str.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
