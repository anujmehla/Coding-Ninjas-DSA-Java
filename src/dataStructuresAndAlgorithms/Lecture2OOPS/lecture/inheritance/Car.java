package dataStructuresAndAlgorithms.Lecture2OOPS.lecture.inheritance;

public class Car extends Vehicle {
//    String color;
//    int maxSpeed;

    int numGears;
    boolean isConvertible;


    public void print() {
        System.out.println("Car color : " + color);
//        System.out.println("Car speed : " + maxSpeed);
        System.out.println("Car speed : " + getMaxSpeed());
        System.out.println("Car numGears : "+numGears);
        System.out.println("Car isConvertible : "+isConvertible);
    }
}
