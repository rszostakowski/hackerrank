package leetcode.problems.math;

public class ValidPerfectSquare {

    public static void main(String[] args) {
        isPerfectSquareNewton(16);
    }
    // again not perfect solution
    public boolean isPerfectSquare(int num) {
        if (num == 1 || num == 4 || num == 9 || num == 16  || num == 25 || num == 36 || num == 49)
            return true;

        int starting = num / 8;

        for (int i = 8; i < starting; i++) {

            long multiplied = (long) i * i;
            if (multiplied == num)
                return true;
            if (multiplied > num){
                return false;
            }
        }

        return false;
    }

    // best solution
    //https://leetcode.com/problems/valid-perfect-square/solutions/130010/python-4-methods-with-time-testing/
    public boolean isPerfectSquareBest(int num) {
        long left = 1, right = num;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (mid * mid == num) return true; // check if mid is perfect square
            if (mid * mid < num) { // mid is small -> go right to increase mid
                left = mid + 1;
            } else {
                right = mid - 1; // mid is large -> to left to decrease mid
            }
        }
        return false;
    }

    //https://www.geeksforgeeks.org/find-root-of-a-number-using-newtons-method/
    public static boolean isPerfectSquareNewton(int num) {
        int root = num;
        while (root*root > num) {
            root = (root + num/root) / 2;
        }
        return root*root == num;
    }


    // using formula Square number is 1+3+5+ ... +(2n-1) = n^2
    public static boolean isPerfectSquareMath(int num) {
        int  i = 1;
        while (num>0){
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
