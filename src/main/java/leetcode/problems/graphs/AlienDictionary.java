package leetcode.problems.graphs;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
//        String[] words = new String[] {
//                "wrt","wrf","er","ett","rftt"
//        };
//        String[] words = new String[] {
//                "zy","zx"
//        };
        String[] words = new String[] {
                "ab","adc"
        };
        //["ab","adc"] -> "abcd"
        System.out.println(alienOrder(words));
    }

    public static String alienOrder(String[] words) {

        Map<Character, Set<Character>> map = new HashMap<>();

        for (int i =1; i< words.length;i++) {
            Optional<char[]> resOpt = compare(words[i-1], words[i]);
            if (resOpt.isPresent()) {
                char[] res = resOpt.get();
                Set<Character> neigh = map.getOrDefault(res[0], new HashSet<>());
                neigh.add(res[1]);
                map.put(res[0], neigh);
            }
        }




        Stack<Character> st = new Stack<>();
        Set<Character> visited = new HashSet<>();

        for (char key : map.keySet()) {
            if (!visited.contains(key))
                topologicalSort(key, map, visited, st);
        }
        StringBuilder result = new StringBuilder();
        Set<Character> unique = new HashSet<>(st);
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        for (int i =0; i< words.length;i++) {
            char[] chars = words[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char ch = chars[j];
                if(!unique.contains(ch)) {
                    result.append(ch);
                    unique.add(ch);
                }
            }
        }
        return result.toString();
    }

    private static void topologicalSort(char key, Map<Character, Set<Character>> map, Set<Character> visited, Stack<Character> st) {
        visited.add(key);
        Set<Character> neighs = map.getOrDefault(key, new HashSet<Character>());
        for (char neigh : neighs) {
            if (!visited.contains(neigh))
                topologicalSort(neigh, map, visited, st);
        }
        st.push(key);
    }

    //[“ab”,“acd”][“abc”,“bcd”,“qwert”,“ab”][“abc”,“ab”][“ab”,“abc”][“a”,“bc”,“bb”,“ba”]
    private static Optional<char[]> compare(String word1, String word2) {
        int n = Math.min(word1.length(), word2.length());

        for (int i = 0; i < n; i++) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            if ( ch1 != ch2) {
                return Optional.of(new char[] {ch1, ch2});
            }
        }

        return Optional.empty();
    }

}
