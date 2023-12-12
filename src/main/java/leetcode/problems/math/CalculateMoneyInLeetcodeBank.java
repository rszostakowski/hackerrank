package leetcode.problems.math;

public class CalculateMoneyInLeetcodeBank {

    public static void main(String[] args) {
        totalMoney(10);
    }
    public static int totalMoney(int n) {
        int div = n/7;
        int rest = n % 7;
        return 28 * div + div*(div - 1)/2*7 + div*rest + rest * (rest+1)/2;
    }

}
