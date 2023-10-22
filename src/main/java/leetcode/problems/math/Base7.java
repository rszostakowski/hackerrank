package leetcode.problems.math;

public class Base7 {
    public String convertToBase7(int num) {
        StringBuilder reminders  = new StringBuilder();

        if (num == 0) {
            return "0";
        }
        boolean isNeg = false;
        if (num < 0) {
            num = Math.abs(num);
            isNeg = true;
        }

        while (num > 0) {
            System.out.println(num);
            int rem = num % 7;
            reminders.append(rem);
            num = num /7;
        }
        if (isNeg) {
            reminders.append("-");
        }
        return reminders.reverse().toString();
    }
}
