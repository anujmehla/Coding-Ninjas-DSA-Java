package TwoDimensionalArray.excercies;

public class FindLargestRowOrColumn {
    public static void main(String[] args) {
        int[][] mat = {{6,9},{8,5},{9,2}};
        findLargest(mat);
    }
    public static void findLargest(int[][] mat) {
        int largest = 0;
        int[] rowArray = new int[mat.length];
        int[] columnArray = new int[mat[0].length];
        int[] oneArray = new int[rowArray.length+ columnArray.length];
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sum+= mat[i][j];
            }
            rowArray[i] = sum;
        }
        System.out.println("row sums");
        for (int i : rowArray) {
            System.out.print(i+" ");
            if (i>largest) {
                largest = i;
            }
        }
        for (int i=0; i<mat[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < mat.length; j++) {
                sum+= mat[j][i];
            }
            columnArray[i]=sum;
        }
        System.out.println("\ncolumn sums");
        for (int i : columnArray) {
            System.out.print(i+" ");
        }
    }
}
//expected output = column 0 23