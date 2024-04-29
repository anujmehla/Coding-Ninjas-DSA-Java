package dataStructureAndAlgo.Lecture1OOPS.lecture.Fraction;

public class Fraction {
    private int numerator;
    private int denominator;

    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {

        }
        this.denominator = denominator;
        simplify();
    }

    public void add(Fraction f) {
        this.numerator = this.numerator * f.denominator + this.denominator* f.numerator;
        this.denominator = this.denominator * f.denominator;
        this.simplify();
    }

    public static Fraction add(Fraction f1, Fraction f2) {
        int newNum = f1.numerator * f2.denominator + f2.numerator + f1.denominator;
        int newDen = f1.denominator * f2.denominator;
        Fraction f = new Fraction(newNum,newDen);
        return f;
    }
    private void simplify() {
        //great common divisor
        int gcd = 1;
        int smaller = Math.min(numerator,denominator);
        for (int i = 1; i <= smaller; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                gcd = i;
            }
        }
        numerator /= gcd;
        denominator /= gcd;
    }

    public void multiply(Fraction f) {
        numerator *= f.numerator;
        denominator *= f.denominator;
    }

    public void print() {
        if (denominator == 1) {
            System.out.println(numerator);
        } else {
            System.out.println(numerator+"/"+denominator);
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        this.simplify();
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            return;
        }
        this.denominator = denominator;
        this.simplify();
    }

}
