package contents.adventOfCode;

import org.testng.internal.collections.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day3 {

    static Map<Pair, List<Integer>> nums = new HashMap<>();
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\dev\\projekty\\hackerrank\\src\\main\\java\\contents\\adventOfCode\\input3.txt";


        List<String> strings = Files.readAllLines(Paths.get(filePath));
        int sum = 0;
        for (int i = 0; i< strings.size(); i++)
        {
            String str = strings.get(i);
            List<NumberInfo> integers = extractNumbers(str);
            for (NumberInfo num : integers) {
                if(getNeighChars(num, i, strings)){
                    sum+=num.number;
                }
            }
        }

        System.out.println(sum);

        int sum2 = 0;
        for (Pair pair: nums.keySet()) {
            List<Integer> integers = nums.get(pair);
            if (integers.size() == 2) {
                sum2 += integers.get(0) * integers.get(1);
            }
            if (integers.size() >2) {
                throw new RuntimeException("");
            }
        }
        System.out.println(sum2);
    }




    private static boolean getNeighChars(NumberInfo num, int currentRowIdx, List<String> strings) {
        String currentRow = strings.get(currentRowIdx);

        int start = Math.max(0, num.startingIndex-1);
        int end = Math.min(num.endingIndex+1, currentRow.length()-1);

        Set<Character> aligned = new HashSet<>();

        if (num.startingIndex != 0) {
            char ch = currentRow.charAt(num.startingIndex - 1);
            if (ch == '*') {
                Pair key = new Pair(currentRowIdx, num.startingIndex - 1);
                List<Integer> list = nums.getOrDefault(key, new LinkedList<>());
                list.add(num.number);
                nums.put(key, list);
            }
            aligned.add(ch);
        }
        if (num.endingIndex < currentRow.length()) {
            char ch = currentRow.charAt(num.endingIndex);
            aligned.add(ch);
            if (ch == '*') {
                Pair key = new Pair(currentRowIdx, num.endingIndex);
                List<Integer> list = nums.getOrDefault(key, new LinkedList<>());
                list.add(num.number);
                nums.put(key, list);
            }
        }
        if (currentRowIdx != 0) {
            String prevRow = strings.get(currentRowIdx-1).substring(start,end);
            char[] chars = prevRow.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                aligned.add(ch);
                if (ch == '*') {
                    Pair key = new Pair(currentRowIdx-1, start+i);
                    List<Integer> list = nums.getOrDefault(key, new LinkedList<>());
                    list.add(num.number);
                    nums.put(key, list);
                }
            }
        }
        if (currentRowIdx + 1 < strings.size()) {
            String nextRow = strings.get(currentRowIdx+1).substring(start,end);
            char[] chars = nextRow.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                aligned.add(ch);
                if (ch == '*') {
                    Pair key = new Pair(currentRowIdx+1, start+i);
                    List<Integer> list = nums.getOrDefault(key, new LinkedList<>());
                    list.add(num.number);
                    nums.put(key, list);
                }
            }
        }


        for (char ch: aligned) {
            if (Character.toString(ch).matches("[^a-zA-Z0-9.]")) {
                return true;
            }
        }
        System.out.println("num: " + num.number  + " excluded");
        return false;
    }


    private static int findLastDigitIndex(String input, String target) {
        int lastIndex = -1;
        int targetLength = target.length();

        for (int i = 0; i < input.length(); i++) {
            if (input.startsWith(target, i)) {
                lastIndex = i + targetLength - 1;
            }
        }

        return lastIndex;
    }


    private static int count(char[][] input) {
        int sum = 0;

        for (char[] line : input) {
            int startIdx = 0;
            int endIdx = 0;
            for (int i = 0; i < line.length; i++) {
                int cur = line[i];

            }
        }
        return 0;
    }

    public static List<NumberInfo> extractNumbers(String input) {
        // Define the regular expression pattern for integers
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);

        List<NumberInfo> numbers = new LinkedList<>();

        while (matcher.find()) {
            int startingIndex = matcher.start();
            int endingIndex = matcher.end();
            int number = Integer.parseInt(matcher.group());

            NumberInfo numberInfo = new NumberInfo(number, startingIndex, endingIndex);
            numbers.add(numberInfo);
        }

        return numbers;
    }

    static class NumberInfo {
        private final int number;
        private final int startingIndex;
        private final int endingIndex;

        public NumberInfo(int number, int startingIndex, int endingIndex) {
            this.number = number;
            this.startingIndex = startingIndex;
            this.endingIndex = endingIndex;
        }

        public int getNumber() {
            return number;
        }

        public int getStartingIndex() {
            return startingIndex;
        }

        public int getEndingIndex() {
            return endingIndex;
        }
    }
}
