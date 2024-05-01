package dataStructureAndAlgo.Lecture2OOPS.lecture.inheritance;

public class VehicleUse {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.color = "Black";
        v.print();

        Car c = new Car();
        c.numGears = 5;
        c.color = "Black";
        c.setMaxSpeed(180);
        c.print();

    }
}
