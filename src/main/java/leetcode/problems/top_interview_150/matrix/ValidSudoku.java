package leetcode.problems.top_interview_150.matrix;

import java.util.*;

public class ValidSudoku {

    public static void main(String[] args) {
    }
    public static int minimumSeconds(List<Integer> nums) {

        Map<Integer, Integer> map = new HashMap();

        int n = nums.size();

        for (int i =0; i < n; i++) {
            int val = nums.get(i);
            map.put(val, map.getOrDefault(val, 0) +1);
        }

        int highestVal = 0;
        int highestKey = 0;
        for (Integer key: map.keySet()) {
            int val = map.get(key);
            if (val > highestVal) {
                highestVal = val;
                highestKey = key;
            }
        }
        System.out.println(highestVal);
        System.out.println(highestKey);


        int seconds = 0;
        for (int j =0; j < 10000; j++) {

            if (new HashSet<>(nums).size() == 1) {
                return seconds;
            }
            List<Integer> copiedList = new ArrayList<>(nums);
            for (int i =0; i < n; i++) {
                int val = copiedList.get(i);
                if (val != highestKey) {
                    int alt1 = copiedList.get((i - 1 + n) % n);
                    int alt2 = copiedList.get((i + 1) % n);

                    if (alt1 == highestKey) {
                        nums.set(i, alt1);
                    }else if (alt2 == highestKey) {
                        nums.set(i, alt2);
                    }
                    System.out.println("nums[i]: " + nums.get(i));

                }
            }
            seconds++;
        }
        return 0;
    }

    public boolean isValidSudoku(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        int submatrixSize = 3;
        for (int i = 0; i <= rows - submatrixSize; i+=3) {
            for (int j = 0; j <= cols - submatrixSize; j+=3) {
                Set<Character> set = new HashSet();
                for (int r = 0; r < submatrixSize; r++) {
                    for (int c = 0; c < submatrixSize; c++) {
                        char ch = board[i + r][j + c];
                        if (ch != '.' && set.contains(ch)) {
                            return false;
                        } else {
                            set.add(ch);
                        }
                    }
                }
            }
        }

        // check rows
        for (int i = 0; i < rows; i++) {
            Set<Character> setR = new HashSet();
            for (int j = 0; j < cols; j++) {
                char chR = board[i][j];
                if (chR != '.' && setR.contains(chR)) {
                    return false;
                } else {
                    setR.add(chR);
                }
            }
        }

        // check cols
        for (int i = 0; i < rows; i++) {
            Set<Character> setR = new HashSet();
            for (int j = 0; j < cols; j++) {
                char chR = board[j][i];
                if (chR != '.' && setR.contains(chR)) {
                    return false;
                } else {
                    setR.add(chR);
                }
            }
        }


        return true;
    }

}
