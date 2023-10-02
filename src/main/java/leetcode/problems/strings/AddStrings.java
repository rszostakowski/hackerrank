package leetcode.problems.strings;

public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("99",  "1"));
    }
    public static String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();

        int smaller = n1 < n2? n1: n2;
        int bigger =  n1 < n2? n2: n1;
        String longer =  n1 < n2? num2: num1;

        boolean moved = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < smaller; i++) {
            int first = Character.getNumericValue(num1.charAt(n1 - i - 1));
            int second = Character.getNumericValue(num2.charAt(n2 - i - 1));
            int res = first + second;
            if (moved)
                res++;

            if (res > 9) {
                res = res%10;
                moved = true;
            } else {
                moved = false;
            }
            result.insert(0, res);
        }

        for (int i = bigger - smaller-1; i >=0 ; i--) {
            int res = Character.getNumericValue(longer.charAt(i));
            if (moved)
                res++;
            if (res > 9) {
                result.insert(0, 0);
                moved = true;
            } else {
                result.insert(0, res);
                moved = false;
            }
        }

        if (moved) {
            result.insert(0, 1);
        }
        return result.toString();
    }

    // the best solution
    public String addStrings_best(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}
