package leetcode.problems.sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate217 {

    // The best!
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public boolean containsDuplicate4(int[] nums) {
        Map<Integer, Long> occ = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Set<Long> uniqueValues = new HashSet<>(occ.values());
        if (uniqueValues.size() ==1 && uniqueValues.contains(1l)) {
            return false;
        }
        return true;
    }

    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate3(int[] nums) {
        Set<Integer> unique = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        if (unique.size() == nums.length) {
            return false;
        }
        System.out.println(unique);
        return true;
    }
}
