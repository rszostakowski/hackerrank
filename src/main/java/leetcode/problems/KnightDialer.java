package leetcode.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnightDialer {
    public static void main(String[] args) {
        knightDialer(2);
        knightDialer(3);
        knightDialer(4);
    }
    public static int knightDialer(int n) {
        // ending - counter
        Map<Integer, Integer> endingCounter = new HashMap<>();
        endingCounter.put(1 , 2);  // 61 81
        endingCounter.put(2 , 2);
        endingCounter.put(3 , 2);
        endingCounter.put(4 , 2);
        endingCounter.put(5 , 0);
        endingCounter.put(6 , 3);
        endingCounter.put(7 , 3);
        endingCounter.put(8 , 2);
        endingCounter.put(9 , 2);
        endingCounter.put(0 , 2);
        // 61 -> 616 618  81 -> 816 818
        // 16 -> 161 167 160    06 -> 061, 067 060

        // [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60,
        // 61, 67, 72, 76, 81, 83, 92, 94]
        // from to
        Map<Integer, Integer> fromToNumOfOptions = new HashMap<>();
        fromToNumOfOptions.put(1 , 2); // 16, 18
        fromToNumOfOptions.put(2 , 2);
        fromToNumOfOptions.put(3 , 2);
        fromToNumOfOptions.put(4 , 3);
        fromToNumOfOptions.put(5 , 0);
        fromToNumOfOptions.put(6 , 3);
        fromToNumOfOptions.put(7 , 2);
        fromToNumOfOptions.put(8 , 2);
        fromToNumOfOptions.put(9 , 2);
        fromToNumOfOptions.put(0 , 2);

        for (int i= 1; i <=n; i++) {
            for (int j = 0; j <10; j++) {
                endingCounter.put(j, endingCounter.get(j)* endingCounter.get(j));
            }
        }

        int sum = 0;
        for (int j = 0; j <10; j++) {
            sum +=endingCounter.get(j);
        }
        System.out.println("n: " + n + " sum: "  + sum);
        return sum;
    }
}
