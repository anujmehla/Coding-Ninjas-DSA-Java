package introToJava.TwoDimensionalArray.assignment;

public class TotalSumOnTheBoundariesAndDiagonals {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,10},{4,5,6,11},{7,8,9,12},{13,14,15,16}};
        totalSum(matrix);
    }
    //my first complicated code which satisfy all conditions
    public static void totalSum(int[][] mat) {
        int boundary = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                //for first and last row for boundary elements
                if ( i == 0 || i==mat.length-1) {
                    boundary += mat[i][j];
                } else {
                    //boundary remaining elements
                    if (j==0 || j==mat[i].length-1) {
                        boundary += mat[i][j];
                    }
                    // first diagonal elements
                    if (i==j) {
                        boundary += mat[i][j];
                    }
                    //second diagonal elements
                    else if (i+j == mat.length-1) {
//                        System.out.println("i : "+i+" j : "+j);
                        boundary += mat[i][j];
                    }
                }
            }
        }
        System.out.println(boundary);
    }
}
/*
input = 123
        456
        789

output = 45

explanation : boundary elements : 1,2,3,6,9,8,7,4
              first diagonal    : 1,5,9
              second diagonal   : 3,5,7
make sure no number added twice
 */