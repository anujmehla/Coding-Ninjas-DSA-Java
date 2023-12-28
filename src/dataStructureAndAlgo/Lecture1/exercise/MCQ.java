package dataStructureAndAlgo.Lecture1.exercise;

class Test {
    int price;
    static int count;

    public Test(int price) {
        this.price = price;
        count++;
    }
}
public class MCQ {
    public static void main(String[] args) {
        System.out.print(Test.count+" ");
        Test t1= new Test(500);
        Test t2 = new Test(600);
        System.out.println(Test.count);
    }
}
