package introductionToJava.Lecture11Strings;

public class StringDemo {
    public static void main(String[] args) {
//        String str = "AabraKaDabraa";
//        char c = str.charAt(1);
//        System.out.println("c = " + c);
//        System.out.println(str.length());
//        char[] largeArray = new char[Integer.MAX_VALUE-999999909];
//        String string = new String(largeArray);
//        System.out.println(string.length());
//        String empty = "";
//        String notEmpty = " ";
//        System.out.println(empty.length());
//        System.out.println(notEmpty.length());
//        String a = "null";
//        String b = "not";
//        if (a==null) {
//            System.out.println("hello");
//        }
//        if (a.equals(b)) {
//            System.out.println("hello2");
//        }
//
//        String c = "abcd";
//        String d = "abcda";
//        System.out.println(c.compareTo(d));
//        String a = "coding";
//        String b = "ninjas";
//        if (a.contains("ing")) {
//            a+=b;
//        } else {
//            b+="ing";
//        }
//        System.out.println(b+a);
        String a = "coding";
        for (int i=2; i<5; i++) {
            System.out.print(a.substring(i-2,i+1));
        }
        //cod
        //odi
        //ding

    }
}
