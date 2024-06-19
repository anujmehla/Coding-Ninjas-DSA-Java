package introductionToJava.Lecture11Strings.Assignment;

public class ReverseEachWord {
    public static void main(String[] args) {
        String input = "Hello I am Aadil";
        System.out.println(reverseEachWord(input));
    }
    //this is not working
    public static String reverseEachWord(String input) {
        char[] charArray = input.toCharArray();
        int ptrA = 0, ptrB = 0, i = 0;
        int len = charArray.length;

        while (true) {
            if (i == len || charArray[i] == ' ') {
                ptrB = i-1;

                while (ptrA < ptrB) {
                    //swap characters using a temporary variable
                    char temp = charArray[ptrA];
                    charArray[ptrA] = charArray[ptrB];
                    charArray[ptrB] = temp;
                    ptrA++;
                    ptrB--;
                }
                ptrA = i+1;
                ptrB = ptrA;
            }
            if (len == 1) {
                break;
            }
            i++;
        }
        return new String(charArray);
    }
    public static String reverseEachWordMyApproach(String str) {
        String[] strings = str.split(" ");
        String newString = "";
        for (int j = strings.length-1; j>=0; j--) {
            char[] ch = strings[j].toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = ch.length-1; i >= 0; i--) {
                sb.append(ch[i]);
            }
            sb.append(" ");
            newString = sb.toString() + newString ;
        }
        return newString;
    }
}
//input = Hello I am Aadil
//output = olleH I ma lidaA

