package leetcode.problems.binary_search;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int total = m * n;

        int left = 0;
        int right = total;
        int count = 0;

        while (left <= right && count < 20) {
            int mid = (left + right)/2;

            int rowMid = mid / n;
            int colMid = mid - n * rowMid;
            int midVal = matrix[rowMid][colMid];

            if (midVal == target) {
                return true;
            }

            if (midVal < target) {
                left = mid ;
            } else {
                right = mid;
            }
            count++;
        }

        return false;
    }


    // alternative approach very interesting
    //https://leetcode.com/problems/search-a-2d-matrix/solutions/1895837/c-binary-search-tree-explained-with-img/
    public boolean searchMatrixAlternative(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
