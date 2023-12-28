package Lecture11Strings;

public class SubStrings {
    public static void main(String[] args) {
        String str = "pqrs";
//        System.out.println(str.substring(0,4));
        printSubStrings(str);
    }
    public static void printSubStrings(String str) {
//        for (int i=0; i<str.length(); i++) {
//            for (int j=i; j<str.length(); j++) {
//                System.out.print(str.substring(i,j+1)+", ");
//            }
//            System.out.println();
//        }

        //another approach
        for (int len = 1; len <= str.length(); len++) {
            // we have to print all strings with length as "len"
            for (int start = 0; start <= str.length()-len; start++) {
                int end = start + len -1;
                System.out.println(str.substring(start,end+1));
            }
            
        }
    }
}
//all substrings of pqrs are
//p,q,r,s
//pq,qr,rs
//pqr, qrs
//pqrs