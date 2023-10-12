package leetcode.problems.math;

public class NumberComplement {
    public int findComplement(int num) {
        String bin = Integer.toBinaryString(num);
        char[] binChars = bin.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< binChars.length; i++) {
            if (binChars[i] == '1') {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }

        //System.out.println(sb.toString());
        return Integer.parseInt(sb.toString(), 2);
    }
}
