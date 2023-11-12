package leetcode.problems.arrays;

import java.util.*;

public class RestoreTheArrayFromAdjacentPairs {
    public static void main(String[] args) {
        //int[][] adjacentPairs = {{4,-2},{1,4},{-3,1}};
        int[][] adjacentPairs = {{2,1},{3,4},{3,2}};
        //int[][] adjacentPairs = {{-3,-9},{-5,3},{2,-9},{6,-3},{6,1},{5,3},{8,5},{-5,1},{7,2}};
        System.out.println(Arrays.toString(restoreArray(adjacentPairs)));
    }
    public static int[] restoreArray(int[][] adjacentPairs) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(adjacentPairs[0][0]);
        deque.addLast(adjacentPairs[0][1]);

        Set<Integer> alreadyIn = new HashSet<>();
        alreadyIn.add(adjacentPairs[0][0]);
        alreadyIn.add(adjacentPairs[0][1]);

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i < adjacentPairs.length; i++){
            int[] arr = adjacentPairs[i];
            List<Integer> l1 = map.getOrDefault(arr[0], new LinkedList<>());
            l1.add(arr[1]);
            map.put(arr[0], l1);
            List<Integer> l2 = map.getOrDefault(arr[1], new LinkedList<>());
            l2.add(arr[0]);
            map.put(arr[1], l2);
        }

        while(map.size()!=0) {
            boolean firstFound = false;
            boolean secondFound = false;
            Integer first = deque.getFirst();
            Integer last = deque.getLast();

            List<Integer> firsts = map.get(first);
            if (firsts != null) {
                for (int i : firsts) {
                    if (!alreadyIn.contains(i)) {
                        alreadyIn.add(i);
                        deque.addFirst(i);
                        map.remove(first);
                        firstFound= true;
                        break;
                    }
                }
            }

            List<Integer> lasts = map.get(last);
            if (lasts != null) {
                for (int i : lasts) {
                    if (!alreadyIn.contains(i)) {
                        alreadyIn.add(i);
                        deque.addLast(i);
                        map.remove(last);
                        secondFound = true;
                        break;
                    }
                }
            }

            if (!firstFound && !secondFound) {
                break;
            }
        }

        return deque.stream().mapToInt(Integer::intValue).toArray();

    }
    public static int[] restoreArray_doesNotWork(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] arr : adjacentPairs) {
            List<Integer> l1 = map.getOrDefault(arr[0], new LinkedList<>());
            l1.add(arr[1]);
            map.put(arr[0], l1);
            List<Integer> l2 = map.getOrDefault(arr[1], new LinkedList<>());
            l2.add(arr[0]);
            map.put(arr[1], l2);
        }
        System.out.println("Hello");
        System.out.println(map);

        int node = Math.min(adjacentPairs[0][0], adjacentPairs[0][1]);
        Optional<Integer> nodeOpt = Optional.of(node);
        int prev = 0;
        List<Integer> res = new LinkedList();
        res.add(node);
        while(map.size()!=0) {
            if (!nodeOpt.isPresent()) {
                System.out.println("here");
            }
            prev = nodeOpt.get();
            List<Integer> links = map.get(prev);
            nodeOpt = firstNotLinked(links, res);
            if(nodeOpt.isPresent()) {
                System.out.println("links" + links);
                System.out.println("res" + res);
                res.add(nodeOpt.get());
                map.remove(prev);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private static Optional<Integer> firstNotLinked(List<Integer> links, List<Integer>  res) {
        if (links != null) {
            for (int i : links) {
                if (!res.contains(i)) {
                    return Optional.of(i);
                }
            }
        }
        return Optional.empty();
    }

    // the best solution
    //https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/solutions/4270723/java-iterative-clean-code-beats-77/
    //https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/solutions/1043033/java-python-3-locate-the-ends-then-follow-the-pairs-w-brief-explanation-and-analysis/
    //https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/solutions/1043371/java-bfs-or-dfs-code-intuition-visualisation/
    /*
    public int[] restoreArray(int[][] adjacentPairs) {
        var map = new HashMap<Integer, List<Integer>>();

        for (var pair : adjacentPairs) {
            map.putIfAbsent(pair[0], new ArrayList<>());
            map.putIfAbsent(pair[1], new ArrayList<>());

            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        var arr = new int[adjacentPairs.length + 1];

        for (var entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                arr[0] = entry.getKey();
                arr[1] = entry.getValue().get(0);
                break;
            }
        }
        for (var i=2; i < arr.length; i++) {
            var a = map.get(arr[i-1]);
            arr[i] = a.get(0) == arr[i-2] ? a.get(1) : a.get(0);
        }
        return arr;
    }
     */
}
