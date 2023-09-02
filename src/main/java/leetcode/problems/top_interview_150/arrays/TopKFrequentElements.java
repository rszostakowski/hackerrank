package leetcode.problems.top_interview_150.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        int[] ints = topKFrequent(nums, 2);
        System.out.println(ints);
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occur = new HashMap();

        for (int num: nums) {
            occur.put(num, occur.getOrDefault(num, 0)+1);
        }

        List<Integer> highestValues = occur.values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(k)
                .collect(Collectors.toList());

        int[] results = new int[k];
        int idx = 0;
        Set<Integer> already = new HashSet<>();
        for (int highval : highestValues) {
            for (int  i = 0; i < nums.length; i++) {
                int key = nums[i];
                int val = occur.get(key);
                if (val == highval && !already.contains(key)) {
                    results[idx++] = key;
                    already.add(key);
                    break;
                }
            }
        }

        return results;
    }

    // better solution from the comments section
    public List<Integer> topKFrequentFromComments(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    // interesting solution with priority queue
    public List<Integer> topKFrequentPriority(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}
