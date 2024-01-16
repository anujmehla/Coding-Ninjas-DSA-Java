package dataStructureAndAlgo.Lecture6;

interface Aa {
    public void method();
}
class One {
    public void method() {
        System.out.println("Class one method");
    }
}
class Two extends One implements Aa {
    public void method() {
        System.out.println("Class Two method");
    }
}
public class Solution {
    public static void main(String[] args) {
        Aa a = new Two();
        a.method();

    }
}
