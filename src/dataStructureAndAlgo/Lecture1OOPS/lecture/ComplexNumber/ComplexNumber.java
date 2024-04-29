package dataStructureAndAlgo.Lecture1OOPS.lecture.ComplexNumber;

public class ComplexNumber {
    private int real;
    private int imaginary;
//    char imaginaryUnit; need not to handled separately

    ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void print() {
        System.out.println(this.toString());
    }

    public void add(ComplexNumber c) {
        this.real += c.real;
        this.imaginary += c.imaginary;
    }

    public static ComplexNumber add(ComplexNumber c1,ComplexNumber c2) {
        int newReal = c1.real + c2.real;
        int newImaginary = c1.imaginary + c2.imaginary;
        return new ComplexNumber(newReal,newImaginary);
    }

    public void multiply(ComplexNumber c) {
        int ansReal = this.real * c.real + -(this.imaginary * c.imaginary);
        int ansImaginary = this.real * c.imaginary + this.imaginary * c.real;
        this.real = ansReal;
        this.imaginary = ansImaginary;
    }

    public ComplexNumber conjugate() {
        return new ComplexNumber(this.real, -this.imaginary);
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getImaginary() {
        return imaginary;
    }

    public void setImaginary(int imaginary) {
        this.imaginary = imaginary;
    }
    @Override
    public String toString() {
        return real + (imaginary >= 0 ? "+" : "")+imaginary + "i";
    }
}
