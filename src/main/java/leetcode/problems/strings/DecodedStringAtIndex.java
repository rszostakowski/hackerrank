package leetcode.problems.strings;

public class DecodedStringAtIndex {

    public static void main(String[] args) {
        DecodedStringAtIndex decodedStringAtIndex = new DecodedStringAtIndex();
       // String s = "abc";
        //int k = 1;
        //String s = "leet2code3";
        //int k = 10;
        //String s = "y959q969u3hb22odq595";
        //int k = 222280369;
        //String s = "a2b3c4d5e6f7g8h9";
        //int k = 10;
        String s = "ha22";
        int k = 5;
        System.out.println(decodedStringAtIndex.decodeAtIndex(s, k));
    }
    public String decodeAtIndexMemoryException(String s, int k) {
        StringBuilder current = new StringBuilder();
        char[] sChars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            char ch = sChars[i];
            if (Character.isLetter(ch)) {
                current.append(ch);
                if (current.length() == k) {
                    return Character.toString(ch);
                }
            } else {
                int number = Character.getNumericValue(ch) -1;
                String increment = current.toString();
                for (int j = 0; j < number; j++) {
                    current.append(increment);
                    if (current.length() >= k) {
                        return Character.toString(current.charAt(k-1));
                    }
                }
            }
        }

        return "";
    }

    public String decodeAtIndex(String s, int k) {
        long size = 0; // To store the size of the current string

        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                size++;
                if (size == k) {
                    return Character.toString(ch);
                }
            } else {
                int digit = Character.getNumericValue(ch);
                long newSize = size * digit;
                if (newSize >= k) {
                    // We found the correct part of the string
                    // Recurse to find the character within this part
                    return decodeAtIndex(s, (int)((k - 1) % size + 1));
                }
                size = newSize;
            }
        }

        return "";
    }
}
