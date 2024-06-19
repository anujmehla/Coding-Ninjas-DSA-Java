package introductionToJava.Lecture12TwoDimensionalArrays;

public class RowWiseSum {
    public static void main(String[] args) {
        int[][] mat = {{1,2},{3,4},{5,6},{7,8}};
        rowWiseSum(mat);
    }
    public static void rowWiseSum(int[][] mat) {
        for (int i=0; i< mat.length; i++) {
            int sum = 0;
            for (int j=0; j<mat[i].length; j++) {
                sum+=mat[i][j];
            }
            System.out.print(sum+" ");
        }
        System.out.println();
    }
}
//in output, we need to print sum of each row, and print it
//space Complexity = O(1) as we're not using extra space
// time complexity = O(n^2)