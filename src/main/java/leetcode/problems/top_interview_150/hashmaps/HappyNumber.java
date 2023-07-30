package leetcode.problems.top_interview_150.hashmaps;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
    public static boolean isHappy(int n) {
        Set<Long> alreadyChecked = new HashSet();

        while (true) {
            long squered = 0;
            while (n > 0) {
                int number  = n % 10;
                squered += Math.pow(number, 2);
                n = n/10;
            }

            if (squered == 1) {
                return true;
            }

            if (alreadyChecked.contains(squered)) {
                return false;
            } else {
                alreadyChecked.add(squered);
            }

            System.out.println("squered: " + squered);
            n = (int) squered;
        }
    }
}
