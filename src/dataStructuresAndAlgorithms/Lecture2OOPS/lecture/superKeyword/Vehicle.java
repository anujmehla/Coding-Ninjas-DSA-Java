package dataStructuresAndAlgorithms.Lecture2OOPS.lecture.superKeyword;

public class Vehicle {
    private String color;
    protected int maxSpeed;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void print() {
        System.out.println("Vehicle "+" color "+color+" maxSpeed "+maxSpeed);
    }
}
