package dataStructureAndAlgo.Lecture6;

abstract class A {
    int i;
    abstract void display();
}
class B extends A {
    int j;
    void display() {
        System.out.println(j);
    }
}
public class Main {
    public static void main(String[] args) {
        B obj = new B();
        obj.j = 2;
        obj.display();
    }
}
