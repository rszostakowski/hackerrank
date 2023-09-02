package leetcode.problems.heap;

import java.util.*;

import static java.util.Comparator.*;

public class KthLargestElementInStream {

    public static void main(String[] args) {
  //      ["KthLargest", "add", "add", "add", "add", "add"]
//[[3, []], [3], [5], [10], [9], [4]]
        KthLargestElementInStream pq = new KthLargestElementInStream(3, new int[] {4, 5, 8, 2});
        System.out.println(pq.add(3));
        System.out.println(pq.add(5));
        System.out.println(pq.add(10));
        System.out.println(pq.add(9));
        System.out.println(pq.add(4));
        //[null,4,5,5,8,8]
    }

    private final PriorityQueue<Integer> pq;
    private final int k;
    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<Integer>();
        Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(k)
                .forEach(pq::add);
    }

    public int add(int val) {
        if (pq.size() >= k) {
            Integer smallest = pq.peek();
            if (smallest < val) {
                pq.poll();
                pq.add(val);
                return pq.peek();
            }
            return smallest;
        } else {
            pq.add(val);
            return pq.peek();
        }
    }
}
