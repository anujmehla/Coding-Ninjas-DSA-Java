package introductionToJava.Lecture9Arrays.Assignment;

public class IntersectionOfTwoArraysll {
    public static void main(String[] args) {
       int[] arr1 = {10,10};
       int[] arr2 = {10};
       intersection(arr1,arr2);
    }
    public static void intersection(int[] arr1, int[] arr2) {
        if (arr1.length==0 || arr2.length==0) {
            return;
        }
       for (int i=0; i < arr1.length; i++) {
           for (int j=0; j< arr2.length; j++) {
               if (arr1[i]==arr2[j]) {
                   System.out.print(arr1[i]+" ");
                   //if we're founding match, we're changing the element in the second array
                   arr2[j]=Integer.MIN_VALUE;
                   break;
               }
           }
       }
    }
    public static void print(int[] array) {
        for (int j : array) {
            System.out.print(j + ", ");
        }
        System.out.println();
    }
}
//array1 = 2 6 1 2
//array2 = 1 2 3 4 2
//expected output = 2 1 2
// test cases passed : 1,2,3
