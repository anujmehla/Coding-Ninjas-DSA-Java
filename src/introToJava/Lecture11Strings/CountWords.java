package introToJava.Lecture11Strings;

public class CountWords {
    public static void main(String[] args) {
        String words = "coding ninjas!";
        int numberOfWords = countWords(words);
        System.out.println(numberOfWords);
    }
    public static int countWords(String str) {
        String[] args = str.split(" ");
        return args.length;
    }
}
// coding ninjas
//output 2
