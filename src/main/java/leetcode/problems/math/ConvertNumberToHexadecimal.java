package leetcode.problems.math;

//https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/
//https://leetcode.com/problems/convert-a-number-to-hexadecimal/solutions/824192/java-100-time-with-detailed-explanation/
public class ConvertNumberToHexadecimal {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] hex =
                new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder strBuilder = new StringBuilder();
        int count = 0;

        //We create a while loop to read 4 bits each time. Since it's a 32-bit Integer, we can only execute this while loop 8 times.
        // We also want to exit the while loop if the num is 0.
        while (count < 8 && num != 0) {
            //We can use & operation. 15 in binary is 1111. If we do num & 15, it will give you the last four bits.
            //num & 15 will give you the number in range [0...15], we can use this to map to the hexChar array.
            //0 -> 0 ....9 -> 9....10 -> a....15 -> f
            //After each loop, we need to remove the last 4 bits. num = num >> 4, and also increment the loopCount by 1.
            strBuilder.append(hex[num & 15]);
            num = num >> 4;
            count++;
        }
        return strBuilder.reverse().toString();
    }
}
