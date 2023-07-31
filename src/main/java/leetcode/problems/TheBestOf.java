package leetcode.problems;

import leetcode.problems.list_nodes.AddTwoNumbers2;
import leetcode.problems.top_interview_150.linked_list.ListNode;
import leetcode.problems.top_interview_150.linked_list.Node;

import java.util.*;

public class TheBestOf {

    // Method promoted by FAANG
    static String intToRoman(int num) {
        String ones[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String hrns[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String ths[]={"","M","MM","MMM"};

        return ths[num/1000] + hrns[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
    }


    // bitwise manipulation
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

    // binary search insert
    public int searchInsertAlt(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid-1;
            else start = mid+1;
        }

        return start;
    }

    // we do not have to look for every word we just need to sort it and compare first with the last one!!
    public String longestCommonPrefix2(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }


    // AMAZING SOLUTION TO ZIGZAG PROBLEM: https://leetcode.com/problems/zigzag-conversion/solutions/3821798/video-step-by-step-visualization-and-explanation/

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    // Found a triplet with zero sum
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Skip duplicate elements for j
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    // Skip duplicate elements for k
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    // Move the pointers
                    j++;
                    k--;
                } else if (sum < 0) {
                    // Sum is less than zero, increment j to increase the sum
                    j++;
                } else {
                    // Sum is greater than zero, decrement k to decrease the sum
                    k--;
                }
            }
        }
        return ans;
    }

    public static int lengthOfLongestSubstring(String s) {

        Set<Character> unique = new HashSet<>();

        int left = 0;
        int right = 0;

        int max = 0;
        while (right < s.length()) {
            char charRight = s.charAt(right);
            if (unique.contains(charRight)) {
                unique.remove(s.charAt(left));
                left++;
            } else {
                unique.add(charRight);
                max = Math.max(max, right - left + 1);
                right++;
            }
        }
        return max;
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt((int[] row) -> row[0]).thenComparing(row -> row[1]));

        Stack<int[]> st = new Stack();

        st.push(intervals[0]);

        for (int i=1; i < intervals.length; i++) {
            int[] last = st.pop();

            if (last[1] >= intervals[i][0] ) {
                if (last[1] < intervals[i][1]) {
                    last[1] = intervals[i][1];
                }
                st.push(last);
            } else {
                st.push(last);
                st.push(intervals[i]);
            }


        }

        return st.toArray(new int[st.size()][]);
    }

    //https://leetcode.com/problems/minimum-size-subarray-sum/submissions/?envType=study-plan-v2&envId=top-interview-150
    // Given an array of positive integers nums and a positive integer target, return the minimal length of a
    //subarray
    // whose sum is greater than or equal to target. If there is no such subarray, return 0 instead
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int smallest = Integer.MAX_VALUE;
        int s = 0;
        for (int i=0; i < n; i++) {
            s += nums[i];
            while (s>= target ) {
                System.out.println(s);
                smallest = Math.min(smallest,  i - left + 1);
                s -= nums[left];
                left++;
            }
        }

        return smallest == Integer.MAX_VALUE ? 0: smallest;
    }

    /*
        bool isIsomorphic(string s, string t) {
        int m1[256] = {0}, m2[256] = {0}, n = s.size();
        for (int i = 0; i < n; ++i) {
            if (m1[s[i]] != m2[t[i]]) return false;
            m1[s[i]] = i + 1;
            m2[t[i]] = i + 1;
        }
        return true;
    }
     */

    // great explanation of the problem https://leetcode.com/problems/word-pattern/solutions/73402/8-lines-simple-java/

    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    /*
    int isPowerOfTwo (int x)
    {
        return ((x != 0) && !(x & (x - 1)));
    }
    */

    // nice solution but it seems to be o(n^2) but
    // The inner loop is based on a conditional that does not occur n times in an average case so you would not consider it a nested loop.
    // https://leetcode.com/problems/longest-consecutive-sequence/description/
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        int best = 0;
        for(int n : set) {
            if(!set.contains(n - 1)) {  // only check for one direction
                int m = n + 1;
                while(set.contains(m)) { // this is a nice treak!
                    m++;
                }
                best = Math.max(best, m - n);
            }
        }
        return best;
    }

    // Floyd’s Cycle-Finding Algorithm - this is coooool! TODO add it

    // Floyd’s Cycle-Finding Algorithm - this is coooool! https://leetcode.com/problems/linked-list-cycle/description/
    //Floyd’s Cycle-Finding Algorithm // fast slow approach // 2 pointers // "tortoise and the hare algorithm"
    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while(true) {
            if (fast == null || fast.next == null) {
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
    }

    // the best solution from the internet - which DOES not use HASHMAP
    // https://leetcode.com/problems/copy-list-with-random-pointer/solutions/43491/a-solution-with-constant-space-complexity-o-1-and-linear-time-complexity-o-n/
    public Node copyRandomList2(Node head) {
        Node iter = head, next;

        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while (iter != null) {
            next = iter.next;

            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = next;

            iter = next;
        }

        // Second round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        iter = head;
        Node pseudoHead = new Node(0);
        Node copy, copyIter = pseudoHead;

        while (iter != null) {
            next = iter.next.next;

            // extract the copy
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;

            // restore the original list
            iter.next = next;

            iter = next;
        }

        return pseudoHead.next;
    }
}









































