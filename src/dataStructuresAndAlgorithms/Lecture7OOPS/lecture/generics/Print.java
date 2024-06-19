package dataStructuresAndAlgorithms.Lecture7OOPS.lecture.generics;

public class Print {
    //this is how to create a generic method
    //<T extends Object> this is how we apply boundation on the object
    public static <T extends Object> void printArray(T a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("a["+i+"] = " + a[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer[] ab = {1,2};
        printArray(ab);
    }
}
