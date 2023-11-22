package leetcode.problems.matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RangeAddition2 {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] ops = {{2,2}, {3,3}};
        maxCount(m, n, ops);
    }
    public static int maxCount_outOfMemory(int m, int n, int[][] ops) {
        int[][] matrix = new int[m][n];

        for (int[] vector : ops) {
            for (int i=0; i < vector[0]; i++) {
                for (int j=0; j < vector[1]; j++) {
                    matrix[i][j]++;
                }
            }
        }

        Map<Integer, Integer> occur = new HashMap();

        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                int num = matrix[i][j];
                occur.put(num, occur.getOrDefault(num, 0) +1);
            }
        }

        int max = occur.keySet().stream().mapToInt(el -> el).max().orElseGet(() -> 1);
        return occur.get(max);
    }

    public int maxCount_toSlow(int m, int n, int[][] ops) {
        Set<Integer> verts = new HashSet<>();
        Set<Integer> hors = new HashSet<>();
        for (int[] vector: ops) {
            verts.add(vector[0]);
            hors.add(vector[1]);
        }

        int minV = verts.stream().mapToInt(el ->el).min().orElseGet(()-> m);
        int minH = hors.stream().mapToInt(el ->el).min().orElseGet(()-> n);
        return minV*minH;
    }

    public static int maxCount(int m, int n, int[][] ops) {
        int minH = m;
        int minV = n;

        for (int[] vector: ops) {
            minH = Math.min(minH, vector[0]);
            minV = Math.min(minV, vector[1]);
        }

        return minV*minH;
    }
}
