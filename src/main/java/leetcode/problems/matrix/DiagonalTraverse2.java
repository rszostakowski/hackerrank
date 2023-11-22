package leetcode.problems.matrix;

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
        diagonalTraverse2.findDiagonalOrder(nums);
    }
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> res = new LinkedList<>();

        int numOfRows = nums.size();
        for (int row = 0; row < numOfRows; row++) {
            int first = row;
            for (int el = 0; el <= row; el++) {
                System.out.println(nums.get(first--).get(el));
            }
        }
        int col = 1;
        for (int row = numOfRows-1; row >= 0; row--) {
//https://leetcode.com/problems/diagonal-traverse-ii/
            //System.out.println(nums.get(numOfRows - 1).get(col));
            String idx = "" + row + col;
            col++;
            System.out.println(idx);
            //System.out.println(nums.get().get(col));


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
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}



// 30 21 12 03