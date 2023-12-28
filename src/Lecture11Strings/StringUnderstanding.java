package Lecture11Strings;

public class StringUnderstanding {
    public static void main(String[] args) {
        String str = "abc";
        String str2 = new String("abc");
//        String str2= "abc";
//        if (str2==str) {
//            System.out.println("references are equal");
//        } else {
//            System.out.println("references are not equal");
//        }
//        if (str2.equals(str)) {
//            System.out.println("content is equal");
//        } else {
//            System.out.println("Content not equal");
//        }
        String str3 = "";
        System.out.println("str3 = " + str3);
        System.out.println(str3.contains(str3));

    }
}
