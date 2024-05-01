package dataStructureAndAlgo.Lecture2OOPS.lecture.inheritance;

public class Vehicle {
    String color;
    private int maxSpeed;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void print() {
        System.out.println("Vehicle color : "+color);
        System.out.println("Vehicle speed : "+maxSpeed);
    }
}
