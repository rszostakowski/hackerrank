package leetcode.problems.top_interview_150.arrays;

public class ZigzagConversion6 {

    public static String convert(String s, int numRows) {
        if (numRows ==1) {
            return s;
        }
        String result = "";
        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            String row = getRow(s, rowIdx, rowIdx, numRows, false);
            System.out.println(row);
            result += row;
        }

        return result;
    }

    public static String getRow(String s, int startingPoint, int currentPoint, int numRows, boolean isShorter) {
        if (currentPoint >= s.length()) {
            return "";
        }

        char current = s.charAt(currentPoint);

        int longer = (numRows - 1) * 2;
        int shorter = (numRows -1 - startingPoint) *2;
        int shortest = startingPoint *2;
        if (startingPoint != 0 && startingPoint != (numRows -1)) {
            int dist = 0;
            if (isShorter) {
                dist = currentPoint + shortest;
            } else {
                dist = currentPoint + shorter;
            }
            return current + getRow(s, startingPoint, dist , numRows, !isShorter);

        }
        return current + getRow(s, startingPoint, currentPoint + longer, numRows, false);

    }
/*  https://leetcode.com/problems/zigzag-conversion/solutions/3821798/video-step-by-step-visualization-and-explanation/

 The key to solving this problem is to understand that we assign characters to rows by oscillating between the top and bottom rows.
 In other words, if we traversed the string and looked at which row each character belonged to (let’s say numRows is 3),
the pattern would be 1 2 3 2 1 2 3 2 1..

    class Solution(object):
    def convert(self, s, numRows):
            if numRows == 1 or numRows >= len(s):
            return s

    rows = [[] for row in range(numRows)]
    index = 0
    step = -1
            for char in s:
    rows[index].append(char)
            if index == 0:
    step = 1
    elif index == numRows - 1:
    step = -1
    index += step

        for i in range(numRows):
    rows[i] = ''.join(rows[i])
        return ''.join(rows)
 */

    public static void main(String[] args) {
        //convert("A", 1);
        convert("PAYPALISHIRING", 4);
    }
}
