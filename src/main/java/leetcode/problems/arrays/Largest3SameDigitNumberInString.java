package leetcode.problems.arrays;

public class Largest3SameDigitNumberInString {

    public static void main(String[] args) {
        largestGoodInteger("6777133339");
    }
    public static String largestGoodInteger(String num) {
        char[] chars = num.toCharArray();
        int sum = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 2; i < num.length(); i++) {
            if (chars[i-2] == chars[i-1] && chars[i-1] == chars[i]) {
                int val = Integer.parseInt(num.substring(i - 2, i +1));
                if (val > sum) {
                    sum = val;
                    idx = i;
                }
            }
        }

        return idx == -1 ? "":num.substring(idx-2, idx+1);
    }
}
