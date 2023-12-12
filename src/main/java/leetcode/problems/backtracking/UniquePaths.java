package leetcode.problems.backtracking;

public class UniquePaths {
    private static long[][] cache = new long[100][100];

    /*
    Since the robot can only move right and down, when it arrives at a point,
    it either arrives from left or above. If we use dp[i][j] for
     the number of unique paths to arrive at the point (i, j),
     then the state equation is dp[i][j] = dp[i][j - 1] + dp[i - 1][j].
     Moreover, we have the base cases dp[0][j] = dp[i][0] = 1 for all valid i and j.

     There is mathematical solution here: https://leetcode.com/problems/unique-paths/solutions/1581998/c-python-5-simple-solutions-w-explanation-optimization-from-brute-force-to-dp-to-math/
     */

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        //System.out.println("3,1: " + up.uniquePaths(3, 1));

        ///
        System.out.println("1,1: " + up.uniquePaths(1, 1));
        System.out.println("1,2: " + up.uniquePaths(1, 2));
        System.out.println("1,4: " + up.uniquePaths(1, 4));
        System.out.println("1,5: " + up.uniquePaths(1, 5));
        System.out.println("2,5: " + up.uniquePaths(2, 5));
        System.out.println("2,1: " + up.uniquePaths(2, 1));
        System.out.println("2,2: " + up.uniquePaths(2, 2));
        System.out.println("2,3: " + up.uniquePaths(2, 3));
        System.out.println("2,4: " + up.uniquePaths(2, 4));
        System.out.println("2,5: " + up.uniquePaths(2, 5));
        System.out.println("2,6: " + up.uniquePaths(2, 6));
        System.out.println("3,1: " + up.uniquePaths(3, 1));
        System.out.println("3,2: " + up.uniquePaths(3, 2));
        System.out.println("3,3: " + up.uniquePaths(3, 3));
        System.out.println("3,4: " + up.uniquePaths(3, 4));
        System.out.println("3,5: " + up.uniquePaths(3, 5));
        System.out.println("3,6: " + up.uniquePaths(3, 6));
        System.out.println("4,1: " + up.uniquePaths(4, 1));
        System.out.println("4,2: " + up.uniquePaths(4, 2));
        System.out.println("4,3: " + up.uniquePaths(4, 3)+ " anali: " + combination(4, 3));
        System.out.println("4,4: " + up.uniquePaths(4, 4)+ " anali: " + combination(4, 4));
        System.out.println("4,5: " + up.uniquePaths(4, 5)+ " anali: " + combination(4, 5));
        System.out.println("4,6: " + up.uniquePaths(4, 6));
        System.out.println("5,1: " + up.uniquePaths(5, 1));
        System.out.println("5,2: " + up.uniquePaths(5, 2));
        System.out.println("5,3: " + up.uniquePaths(5, 3));
        System.out.println("5,4: " + up.uniquePaths(5, 4)+ " anali: " + combination(5, 4));
        System.out.println("5,5: " + up.uniquePaths(5, 5)+ " anali: " + combination(5, 5));
        System.out.println("5,6: " + up.uniquePaths(5, 6) + " anali: " + combination(5, 6));

        System.out.println("5,6: " + up.uniquePaths(5, 6) + " = 5,5: " + up.uniquePaths(5, 5) + " 4,6: " + up.uniquePaths(4, 6));
        System.out.println("4,5: " + up.uniquePaths(4, 5) + " = 4,4: " + up.uniquePaths(4, 4) + " 3,5: " + up.uniquePaths(3, 5));
    }

    private static long combination(int n, int k) {
        if (n == 1 || k == 1) {
            return 1;
        }
        long cached = cache[n][k];
        if (cached != 0) {
            return cached;
        }

        long result =  combination(n, k-1) + combination(n-1, k);
        cache[n][k]= result;
        return result;
    }

/*    private static long factorial(int k) {
        if (k == 1)
            return 1;

        if (cache[k] != 0) {
            return cache[k];
        }

        long res = k * factorial(k-1);
        cache[k] = res;
        return res;
    }*/

    public int uniquePaths(int m, int n) {

        return backtrack(0, 0, "", m, n);
    }

    int backtrack(int row, int col, String path, int rowsN, int colsN) {
        if (row<rowsN && row >= 0 && col >= 0  &&  col< colsN ) {
            if (row == (rowsN-1) && col == (colsN-1)) {
                //System.out.println(path);
                return 1;
            }

            // Define the relative coordinates for all neighbors
            int[] dx = {1, 0};
            int[] dy = {0, 1};

            path += "[" +  row + col + "],";
            int sum = 0;
            //System.out.println("row: " + row + " col: " + col);
            for (int k = 0; k < 2; k++) {
                int x = row + dx[k];
                int y = col + dy[k];

                sum += backtrack(x, y, path, rowsN, colsN);
            }

            return sum;
        }
        return 0;
    }
}
