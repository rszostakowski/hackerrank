package leetcode.problems.math;

public class AddDigits {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        int sum = 0;
        while(num>0) {
            sum += num % 10;
            num = num / 10;
        }
        return addDigits(sum);
    }
}
