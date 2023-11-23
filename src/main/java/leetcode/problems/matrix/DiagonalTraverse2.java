package leetcode.problems.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DiagonalTraverse2 {

    public static void main(String[] args) {
        DiagonalTraverse2 diagonalTraverse2  = new DiagonalTraverse2();
        List<List<Integer>> nums = List.of(
                List.of(1,2,3),
                List.of(4,5,6),
                List.of(7,8,9)
        );
        //diagonalTraverse2.findDiagonalOrder(nums);

        List<List<Integer>> nums1 = List.of(
                List.of(1,2,3,4,5),
                List.of(6,7),
                List.of(8),
                List.of(9,10,11),
                List.of(12,13,14,15,16)
        );
        //diagonalTraverse2.findDiagonalOrder(nums1);

        List<List<Integer>> nums2 = List.of(
                List.of(1,2,3,4,5)
        );
        //diagonalTraverse2.findDiagonalOrder(nums2);

        List<List<Integer>> nums3 = List.of(
                List.of(6),
                List.of(8),
                List.of(6,1,6,16)
        );
        diagonalTraverse2.findDiagonalOrder(nums3);
    }
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> res = new LinkedList<>();

        int numOfRows = nums.size();
        int max = nums.get(0).size();
        for (int row = 0; row < numOfRows; row++) {
            int first = row;
            max = Math.max(nums.get(row).size(), max);
            for (int el = 0; el <= row; el++) {
                if (first < nums.size() && el < nums.get(first).size()){
                    Integer x = nums.get(first--).get(el);
                    res.add(x);
                    System.out.println(x);
                }
            }
        }

        for (int i = 1; i <= numOfRows; i++) {
            //System.out.println(nums.get(numOfRows - 1).get(col));
            int row = numOfRows-1;
            for (int col = i; col <= max; col++) {
                if (row < nums.size() && col < nums.get(row).size()) {
                    String idx = "" + row + col;
                    Integer x = nums.get(row).get(col);
                    res.add(x);
                    row--;
                    System.out.println(idx);
                    //System.out.println(nums.get().get(col));
                }
                row = Math.max(row, 0);
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }


    // beter solution
    public int[] findDiagonalOrder_best(List<List<Integer>> nums) {
        int m = nums.size(), maxSum = 0, size = 0, index = 0;
        List<Integer>[] map = new ArrayList[100001];
        for (int i = 0; i < m; i++) {
            size += nums.get(i).size();
            for (int j = 0; j < nums.get(i).size(); j++) {
                int sum = i + j;
                if (map[sum] == null) map[sum] = new ArrayList<>();
                map[sum].add(nums.get(i).get(j));
                maxSum = Math.max(maxSum, sum);
            }
        }
        int[] res = new int[size];
        for (int i = 0; i <= maxSum; i++) {
            List<Integer> cur = map[i];
            for (int j = cur.size() - 1; j >= 0; j--) {
                res[index++] = cur.get(j);
            }
        }
        return res;
    }
}
// 00
// 10 01
// 20 11 02
// 30 21 12 03
// 31 22 13
// 32 23
// 33

// 00
// 10 01
// 20 11 02
// 21 12
// 22


// 30 21 12 03