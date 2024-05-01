package dataStructureAndAlgo.Lecture2OOPS.lecture.superKeyword;

public class VehicleUse {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.setColor("Red");
        v.maxSpeed = 80;
        v.print();

        Car c = new Car();
        c.setColor("Black");
        c.maxSpeed = 100;
        c.numDoors = 4;
        c.print();

    }
}
