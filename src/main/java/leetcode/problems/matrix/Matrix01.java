package leetcode.problems.matrix;

import java.util.Arrays;

public class Matrix01 {

    public static void main(String[] args) {
        int[][] matr = {{0,0,0} , {0,1,0}, {0,0,0}};
        updateMatrix(matr);
    }
    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (mat[i][j] == 0)
                    res[i][j] = 0;
                //int closestRow = findClosestInRow(mat, i, j);
                //int closestCol = findClosestInColumn(mat, i, j);
                //mat[i][j] = Math.min(closestRow, closestCol);
            }
        }
        display(res);
        return mat;
    }

    private static void display(int[][] res) {
        for (int[] row : res) {
            System.out.println(Arrays.toString(row));
        }

    }

    private int findClosestInColumn(int[][] mat, int rowIdx, int colIdx) {
        int[] row = mat[rowIdx];

        int min = Integer.MAX_VALUE;
        for (int i = colIdx-1 ; i >= 0; i--) {
            if (row[i] == 0) {

            }
        }

        return 0;
    }

    private int findClosestInRow(int[][] mat, int i, int j) {
        return 0;
    }
}
