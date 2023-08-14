package leetcode.problems.top_interview_150.bit_manipulation;

public class AddBinary {
    public static void main(String[] args) {
        String x = "011011";
        String y = "1010111";

        System.out.println(addBinary(x, y));
    }
    public static String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            } else if (sum == 0 || sum == 1) {
                result.append(sum);
                carry = 0;
            }
            if (sum == 2) {
                result.append("0");
                carry = 1;
            } else {
                result.append("1");
                carry = 1;
            }

            i--;
            j--;
        }
        if (carry == 1) {
            result.append("1");
        }

        return result.reverse().toString();
    }

    // solution from the internet
    static String add_Binary(String x, String y)
    {

        int num1 = Integer.parseInt(x, 2);
        // converting binary string into integer(decimal
        // number)

        int num2 = Integer.parseInt(y, 2);
        // converting binary string into integer(decimal
        // number)

        int sum = num1 + num2;
        // Adding those two decimal numbers and storing in
        // sum

        String result = Integer.toBinaryString(sum);
        // Converting that resultant decimal into binary
        // string

        return result;
    }
}
