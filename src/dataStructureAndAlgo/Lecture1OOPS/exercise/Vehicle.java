package dataStructureAndAlgo.Lecture1OOPS.exercise;

class VehicleOrg {
    String colour;
//    String Colour;
    private int number;
    void set(int number) {
        number = number;
    }
    int get() {
        return number;
    }
}
public class Vehicle extends VehicleOrg{
    public static void main(String[] args) {
        VehicleOrg vo = new VehicleOrg();
        vo.colour = "white";
        vo.set(1010);
        System.out.println(vo.colour+" "+ vo.get());
    }
}
