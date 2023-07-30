package leetcode.problems.top_interview_150.two_pointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> cache = new HashMap();

        for (int i = 0; i < numbers.length; i++) {
            int lookingFor = target - numbers[i];

            if (cache.containsKey(lookingFor)) {
                return new int[] { cache.get(lookingFor), i+1 };
            } else {
                cache.put(numbers[i], i+1);
            }
        }

        throw new RuntimeException();
    }
}
