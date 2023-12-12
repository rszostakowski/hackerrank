package leetcode.problems.contests.biweekly_contest_119;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ex1 {
    public static void main(String[] args) {
        Ex1 ex = new Ex1();
        int[] nums1 = {4,3,2,3,1};
        int[] nums2 = {2,2,5,2,3,6};
        int[] intersectionValues = ex.findIntersectionValues(nums1, nums2);
        System.out.println(Arrays.toString(intersectionValues));
    }

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> s2 = convertArrayToSet(nums2);
        Set<Integer> s1 = convertArrayToSet(nums1);

        int counter1 =0;
        for (int i = 0; i < nums1.length; i++) {
            if (s2.contains(nums1[i])) {
                counter1++;
            }
        }

        int counter2 = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (s1.contains(nums2[i])) {
                counter2++;
            }
        }
        return new int[]{counter1, counter2};
    }

    private static Set<Integer> convertArrayToSet(int[] array) {
        Set<Integer> set = new HashSet<>();

        for (int num : array) {
            set.add(num);
        }

        return set;
    }
}
