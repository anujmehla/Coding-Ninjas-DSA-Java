package introductionToJava.Test1;

import java.util.Scanner;

/*
Problem statement
Print the following pattern for given number of rows.
Sample Input :
   5
Sample Output :
 5432*
 543*1
 54*21
 5*321
 *4321

 */
public class NumberStarPattern1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        for (int i = 1; i <= N; i++) {
            for (int j = N; j >= 1; j--) {
                if (j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(j);
                }
            }
            System.out.println();
        }
    }
}
