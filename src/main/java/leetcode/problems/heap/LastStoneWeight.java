package leetcode.problems.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());

    public int lastStoneWeight(int[] stones) {
        Arrays.stream(stones)
                .forEach(pq::add);

        while(pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            if (first != second) {
                int left = Math.abs(first - second);
                //System.out.println("destrying: " + first + " and: " + second + " Adding back: " + left);
                pq.add(left);
            }
        }

        if (pq.size() == 1) {
            return pq.peek();
        }
        return 0;
    }

}
