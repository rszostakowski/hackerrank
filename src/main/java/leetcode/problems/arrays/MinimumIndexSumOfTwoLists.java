package leetcode.problems.arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String , Integer> occur1 = new HashMap();
        Map<String , Integer> occur2 = new HashMap();

        int n1 = list1.length;
        int n2 = list2.length;

        for (int i = 0; i < n1; i++) {
            occur1.put(list1[i], i);
        }
        for (int i = 0; i < n2; i++) {
            occur2.put(list2[i], i);
        }


        if (n1< n2) {
            return getRes(occur1, occur2).toArray(new String[0]);
        }
        return getRes(occur2, occur1).toArray(new String[0]);
    }

    private List<String> getRes(Map<String, Integer> occur1, Map<String, Integer> occur2) {
        List<String> res = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for (String str: occur1.keySet()) {
            if (occur2.containsKey(str)) {
                int i1 = occur1.get(str);
                int i2 = occur2.get(str);
                int sum = i1  + i2;

                if (sum < min) {
                    min = sum;
                    res = new LinkedList<>();
                    res.add(str);
                } else if (sum == min) {
                    res.add(str);
                }
            }
        }
        return res;
    }
}
