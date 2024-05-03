package dataStructureAndAlgo.Lecture7OOPS.lecture.generics;

public class PairUse {
    public static void main(String[] args) {
        Pair p = new Pair<String,Integer>("1",2);
        p.setFirst("sadfsd");
        System.out.println(p.getFirst());
        System.out.println(p.getSecond());
        int a = 10;
        int b = 20;
        int c = 30;
        Pair<Integer,Integer> p23 = new Pair<>(a,b);
        Pair<Pair<Integer,Integer>,Integer> p2 = new Pair<>(p23,c);
        System.out.println(p2.getSecond());//c
        System.out.println(p2.getFirst().getFirst());//a
        System.out.println(p2.getFirst().getSecond());//b
    }
}
