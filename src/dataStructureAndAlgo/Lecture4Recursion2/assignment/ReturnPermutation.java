package dataStructureAndAlgo.Lecture4Recursion2.assignment;

/*
Question : Return Permutations - String
Problem statement
Given a string S, find and return all the possible permutations of the input string.

Note 1 : The order of permutations is not important. Note 2 : If original string contains duplicate characters,
permutations will also be duplicates.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input :
abc
Sample Output :
abc
acb
bac
bca
cab
cba
 */
public class ReturnPermutation {
    public static void main(String[] args) {
        String input = "abc";
        String[] output = permutationOfString(input);
        for (String s : output) {
            System.out.print(s+" ");
        }
    }
    public static String[] permutationOfString(String input) {
        if(input.length() == 0){
            return new String[1];
        }
        if(input.length() == 1){
            String[] arr = new String[1];
            arr[0] = input;
            return arr;

        }
        char c = input.charAt(0);
        String[] temp = permutationOfString(input.substring(1));
        String[] output = new String[temp.length * input.length()];
        int k = 0;
        for(int i =0; i< temp.length; i++){
            String newstr = temp[i];
            for(int j=0; j<newstr.length();j++){
                output[k] = newstr.substring(0,j)+c+newstr.substring(j);
                k = k + 1;
            }
            output[k] = newstr + c;
            k = k + 1;

        }
        return output;
    }

    //their solution
    public static String[] permutationOfString1(String input) {
        if (input.length() == 0) {
            String output[] = {""};
            return output;
        }
        String[] smallerOutput = permutationOfString1(input.substring(1));

        String[] output = new String[input.length()*smallerOutput.length];

        int k = 0;
        for (int i = 0; i < smallerOutput.length; i++) {
            String currentString = smallerOutput[i];
            for (int j = 0; j <= currentString.length(); j++) {
                output[k] = currentString.substring(0,j)+input.charAt(0)+currentString.substring(j);
                k++;
            }
        }
        return output;
    }
}
