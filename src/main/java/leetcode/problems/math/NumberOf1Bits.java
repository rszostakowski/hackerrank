package leetcode.problems.math;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        return countOnes(Integer.toBinaryString(n));
    }

    private int countOnes(String bin) {
        char[] chars = bin.toCharArray();
        int sum = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (chars[i] == '1') {
                sum++;
            }
        }
        return sum;
    }
}
