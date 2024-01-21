package dataStructureAndAlgo.Lecure8.lecture;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        System.out.println(list1.size());
        list1.add(15);
        list1.add(20);
        list1.add(25);
        System.out.println(list1.get(1));
        list1.add(1,1);
        System.out.println("Size is : "+list1.size());
        System.out.println(list1.get(1));
//        list1.remove(0);
        list1.set(0,5);
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i)+" ");
        }
        System.out.println("\nprinted using for each loop");
        for (int element : list1){
            System.out.print(element+" ");
        }

    }
}
