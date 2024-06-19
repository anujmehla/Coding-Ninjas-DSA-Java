package introductionToJava.Lecture12TwoDimensionalArrays.assignment;

public class PrintLikeAWave {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        wavePrint(matrix);
    }
    public static void wavePrint(int mat[][]) {
        for (int i=0; i<mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {

            }
        }
    }
}

/*
output shall be a sine wave
1,5,9, 10,6,2, 3,7,11, 12,8,4
 */