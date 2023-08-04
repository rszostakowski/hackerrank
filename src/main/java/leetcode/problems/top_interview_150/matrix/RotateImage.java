package leetcode.problems.top_interview_150.matrix;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate(matrix);
    }

    public static void rotateMy(int[][] matrix) {
        int n = matrix.length;

        int[][] destinationArray = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                destinationArray[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i <n ; i++) {
            for (int j = n-1; j >= 0; j--) {
                matrix[i][n-j-1] = destinationArray[j][i];
            }
        }
    }

    //The idea was firstly transpose the matrix and then flip it symmetrically. For instance,
    public static void rotate(int[][] matrix) {

            for(int i = 0; i<matrix.length; i++){
                for(int j = i; j<matrix[0].length; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            for(int i =0 ; i<matrix.length; i++){
                for(int j = 0; j<matrix.length/2; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix.length-1-j];
                    matrix[i][matrix.length-1-j] = temp;
                }
            }

    }
}
