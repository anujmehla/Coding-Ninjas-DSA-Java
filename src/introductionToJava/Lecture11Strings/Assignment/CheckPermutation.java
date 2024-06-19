package introductionToJava.Lecture11Strings.Assignment;

public class CheckPermutation {
    public static void main(String[] args) {
        String str1 = "sinrtg";
        String str2 = "string";
        System.out.println(isPermutation(str1, str2));
    }
    public static boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] charCount = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            charCount[str1.charAt(i)]++;
            charCount[str2.charAt(i)]--;
        }
        for (int i : charCount) {
            if (i!=0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isPermutationMyAttemptFailedOneTest(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        boolean isEqual = true;
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for (int i =0; i< ch1.length; i++) {
            boolean check = false;
            for (int j = 0; j < ch2.length; j++) {
                if (ch1[i]==ch2[j]) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                isEqual = false;
                break;
            }
        }
        return isEqual;
    }
}