package introToJava.Lecture2GettingStartedWithJava;

public class Add2Num {
    public static void main(String[] args) {

        //these data types for storing integer values
        byte b = 123;
        short s = 123;
        int i = 10;
        long l = 12345;

        int j = 15;

        //these data types for storing double values
        float f = 1;
        double d = 1.23;

        //uninitialized variable
        float m; //here we've declared a variable but didn't add any value to it.
        //in java, accessing a variable which doesn't store anything cause errors.
        //error : variable might not have been initialized.
//        System.out.println(m);


        boolean boo = false;


        int sum =  i+j;
        System.out.println("Sum of two numbers is : " + sum);

    }
}
/*
different data types based on the size of the integer
byte
short for 2 bytes
int for 4 bytes
long for 8 bytes

for decimal values
float for 4 bytes
double for 8 bytes

for storing characters
char, it takes 2 bytes

for storing boolean values
boolean it takes

when we declare a variable that memory based on datatype will be reserved.

 */
