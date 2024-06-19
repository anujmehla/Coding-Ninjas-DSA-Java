package introductionToJava.Lecture11Strings;

public class ReverseEachWord {
    public static void main(String[] args) {
        String str = "abc def ghi";
        System.out.println(reverseEachWord(str));
    }
    public static String reverseEachWord(String str) {
        String ans = "";
        int currentWordStart = 0;
        int i = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i)==' ') {
                //reverse current word
                int currentWordEnd = i-1;
                String reversedWord = "";
                for (int j = currentWordStart; j <= currentWordEnd; j++) {
                    reversedWord = str.charAt(j) + reversedWord;
                }
                //Add it final string(ans)
                ans += reversedWord +" ";
                currentWordStart = i+1;
            }
        }
        //as last word was missing because it doesn't have that extra space at the end, so, we'll take care of it here.
        int currentWordEnd = i-1;
        String reversedWord = "";
        for (int j = currentWordStart; j <= currentWordEnd; j++) {
            reversedWord = str.charAt(j) + reversedWord;
        }
        //Add it final string(ans)
        ans += reversedWord;
        currentWordStart = i+1;
        return ans;
    }
}
// input = "abc def ghi"
//output = "cba fed ihg"
