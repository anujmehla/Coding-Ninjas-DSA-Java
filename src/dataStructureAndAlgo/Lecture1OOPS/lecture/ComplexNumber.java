package dataStructureAndAlgo.Lecture1OOPS.lecture;

public class ComplexNumber {
    private int real;
    private int imaginary;
    char imaginaryUnit;

    ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
        imaginaryUnit = '+';
    }

    public void print() {
        System.out.println(real+""+ imaginaryUnit +imaginary+"i");
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


    //the solution to this function was not provided : not working as it is supposed to do
    public ComplexNumber conjugate() {
        if (imaginaryUnit == '+') {
            System.out.println("++++++++++++++case");
            ComplexNumber c = new ComplexNumber(this.real, this.imaginary);
            c.imaginary = '-';
            return c;
        } else {
            System.out.println("--------------case");
            ComplexNumber c = new ComplexNumber(this.real, this.imaginary);
            c.imaginary = '+';
            return c;
        }
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
}
