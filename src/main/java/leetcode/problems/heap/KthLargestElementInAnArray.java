package leetcode.problems.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        // min heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.stream(nums).forEach(el -> {
            pq.add(el);
            if (pq.size() > k) {
                pq.poll();
            }
        });

        return pq.peek();
    }
}
