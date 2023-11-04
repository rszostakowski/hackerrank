package leetcode.problems.contests.biweekly_contest_116;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) {
        Ex1 ex1 = new Ex1();
        List<Integer> nums = new LinkedList<>();
        nums.add(1);
        nums.add(2);
        nums.add(1);
        System.out.println(ex1.solution(nums));
    }

    private int solution(List<Integer> nums) {
        int n = nums.size();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                List<Integer> integers = nums.subList(i, j + 1);
                System.out.println(integers);
                HashSet<Integer> set = new HashSet<>(integers);
                sum = sum + (int) Math.pow(set.size(), 2);
            }
        }
        return sum;
    }
}
