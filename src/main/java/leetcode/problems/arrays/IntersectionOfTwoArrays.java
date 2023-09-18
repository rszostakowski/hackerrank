package leetcode.problems.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        Set<Integer> set1 = new HashSet<>();
        set1.addAll(list1);

        List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        Set<Integer> set2 = new HashSet<>();
        set2.addAll(list2);

        set1.retainAll(set2);

        return set1.stream().mapToInt(Integer::intValue).toArray();
    }
}
