package dataStructuresAndAlgorithms.Lecture1OOPS.lecture.polynomial;

public class Polynomial {
    //   DynamicArray coefficient;

    //approach : we will use array to store the polynomial,
    // indices of array will act as degree and its value as coefficient
    int[] degCoeff;

    Polynomial() {
        degCoeff = new int[10];
    }

    public void setCoefficient(int degree, int coefficient) {
        if (degree > degCoeff.length - 1) {

            int[] temp = degCoeff;
            degCoeff = new int[degree + 1];
            for (int i = 0; i < temp.length; i++) {
                degCoeff[i] = temp[i];
            }
        }
        degCoeff[degree] = coefficient;
    }

    public int getCoefficient(int degree) {
        if (degree < this.degCoeff.length) {
            return degCoeff[degree];
        } else {
            return 0;
        }
    }

    public int degree() {
        return 0;
    }

    public void print() {
        for (int i = 0; i < degCoeff.length; i++) {
            if (degCoeff[i] != 0) {
                System.out.println(degCoeff[i] + "x" + i + " ");
            }
        }
    }

    // adds two polynomials and returns a new polynomial which has result
    public Polynomial add(Polynomial p) {
        Polynomial ans = new Polynomial();
        int plen1 = this.degCoeff.length;
        int plen2 = p.degCoeff.length;
        int len = Math.min(plen1, plen2);

        int i;
        for (i = 0; i < len; i++) {
            ans.setCoefficient(i, this.degCoeff[i] + p.degCoeff[i]);
        }
        while (i < plen1) {
            ans.setCoefficient(i, this.degCoeff[i]);
            i++;
        }
        while (i < plen2) {
            ans.setCoefficient(i, p.degCoeff[i]);
            i++;
        }
        return ans;
    }

    public Polynomial substract(Polynomial p) {
        int plen1 = this.degCoeff.length;
        int plen2 = p.degCoeff.length;
        int len = Math.min(plen1, plen2);
        Polynomial ans = new Polynomial();
        int i;
        for (i = 0; i < len; i++) {
            ans.setCoefficient(i, this.degCoeff[i] - p.degCoeff[i]);
        }
        while (i < plen1) {
            ans.setCoefficient(i, this.degCoeff[i]);
            i++;
        }
        while (i < plen2) {
            ans.setCoefficient(i, -p.degCoeff[i]);
            i++;
        }
        return ans;

    }

    public Polynomial multiply(Polynomial p) {
        Polynomial ans = new Polynomial();
        for (int i = 0; i < this.degCoeff.length; i++) {
            for (int j = 0; j < p.degCoeff.length; j += 1) {
                int termdeg = i + j;
                int termCoeff = this.degCoeff[i] * p.degCoeff[j];
                int oldCoeff = ans.getCoefficient(termdeg);
                ans.setCoefficient(termdeg, termCoeff + oldCoeff);
            }
        }
        return ans;

    }

    public int evaluate(int x) {
        return 0;
    }

    public static Polynomial add(Polynomial p1, Polynomial p2) {
        return null;
    }
}
