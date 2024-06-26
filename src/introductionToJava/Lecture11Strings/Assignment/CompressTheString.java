package introductionToJava.Lecture11Strings.Assignment;

public class CompressTheString {
    public static void main(String[] args) {
        String str = "aaabbccdsa";
        System.out.println(getCompressedString(str));
    }
    public static String getCompressedString(String str) {
        int n = str.length();
        if(n==0){ //for empty string
            return str;
        }
        String output = ""+str.charAt(0);
        int currentCharacterCount = 1;
        for(int i=1;i<n;i++){
            if(str.charAt(i)==str.charAt(i-1)){
                currentCharacterCount++;
            }else{
                if(currentCharacterCount>1){
                    output = output + currentCharacterCount;
                    currentCharacterCount=1; //reset it to 1
                }
                output += str.charAt(i);
            }
        }
        //to print the character count of last element
        if(currentCharacterCount>1){
            output += currentCharacterCount;
        }
        return output;
    }
}
