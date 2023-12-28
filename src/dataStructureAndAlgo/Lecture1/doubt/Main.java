package dataStructureAndAlgo.Lecture1.doubt;

class Car {
    private int seats;
    private int speed;

    public Car(int seats, int speed) {
        this.seats = seats;
        this.speed = speed;
        System.out.println("This is a car");
    }
}
class Audi extends Car {
    Audi(int x, int y) {
        super(x,y);
        System.out.println("This Is Para Audi");
    }
    void Audi() {
        System.out.println("This Is Def Audi");
    }
}

class Main {
    public static void main(String[] args) {
        Audi a = new Audi(5,7);
        a.Audi();
    }
}
