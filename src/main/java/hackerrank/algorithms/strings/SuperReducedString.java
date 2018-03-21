package hackerrank.algorithms.strings;
import java.util.Scanner;

public class SuperReducedString {

    static String super_reduced_string(String notReduced) {
        char[] chars = notReduced.toCharArray();
        for (int k = 1; k < notReduced.length(); k++) {
            if (chars[k-1] == chars[k]) {
                String truncated = notReduced.substring(0, k - 1) +
                        notReduced.substring(k + 1, notReduced.length());
                return super_reduced_string(truncated);
            }
        }
        return notReduced.length() == 0 ? "Empty String": notReduced;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
