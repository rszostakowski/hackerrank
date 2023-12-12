package contents.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Day12 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String filePath = "C:\\dev\\projekty\\hackerrank\\src\\main\\java\\contents\\adventOfCode\\input12.txt";
        String[] input = getInput(filePath);
        int sum = 0;
        for (String row : input) {
            System.out.println(row);
            String[] split = row.split(" ");
            char[] pattern = split[0].toCharArray();
            List<Integer> nums = List.of(split[1].split(","))
                    .stream()
                    .map(Integer::parseInt).collect(Collectors.toList());

            List<char[]> res = new LinkedList<>();
            backtracking(res, pattern, nums, 0,
                    nums.stream().mapToInt(e->e).sum(),
                    nums.stream().mapToInt(e->e).max().getAsInt());
            sum += res.size();
        }

        System.out.println(sum);
        long endTime = System.currentTimeMillis();

        // Calculate and print the execution time
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " milliseconds");
    }

    private static void backtracking(List<char[]> res, char[] pattern, List<Integer> nums, int lastQuestionMark, int sum, int max) {
        if (goodSoFar(pattern, sum, max)) {
            int nextQuestionMark = findNextQuestionMark(pattern, lastQuestionMark);
            if (nextQuestionMark != -1) {
                char[] p1 = Arrays.copyOf(pattern, pattern.length);
                p1[nextQuestionMark] = '.';
                backtracking(res, p1, nums, nextQuestionMark, sum, max);

                char[] p2 = Arrays.copyOf(pattern, pattern.length);
                p2[nextQuestionMark] = '#';
                backtracking(res, p2, nums, nextQuestionMark, sum, max);
            } else {
                if(patternMatches(pattern, nums)) {
                    res.add(pattern);
                    return;
                }
            }

        }
    }
    private static int findNextQuestionMark(char[] charArray, int lastQuestionMark) {
        // Iterate through the char array to find the index of the next '?'
        for (int i = lastQuestionMark; i < charArray.length; i++) {
            if (charArray[i] == '?') {
                return i;
            }
        }
        // If no '?' is found, return -1
        return -1;
    }
    private static boolean goodSoFar(char[] pattern, int sum, int max) {
        int counter = 0;
        int counterInRow = 0;
        for (char c : pattern) {
            if  (c == '?' || c == '#') {
                counter++;
            }
            if (c == '#') {
                counterInRow++;
            } else {
                if (counterInRow > max) {
                    return false;
                }
                counterInRow =0;
            }
        }
        if (counter < sum) {
            return false;
        }
        return true;
    }

    private static boolean goodSoFar2(char[] pattern, int endingIdx, List<Integer> nums) {
        int counter = 0;
        int checkerdIdx = 0;
        for (int i = 0; i < endingIdx; i++) {
            char ch = pattern[i];
            if (ch == '?') {
                return false;
            }
            if (ch == '#') {
                counter++;
            } else if (counter != 0){
                if (counter != nums.get(checkerdIdx++)){
                    return false;
                }
                counter = 0;
            }
        }
        if(counter != 0) {
            if (counter != nums.get(checkerdIdx)){
                return false;
            }
        }

        return true;
    }

    private static boolean patternMatches(char[] pattern, List<Integer> nums) {
        List<Integer> res = new LinkedList<>();
        int counter = 0;
        for (int i = 0; i < pattern.length; i++) {
            char ch = pattern[i];
            if (ch == '#') {
                counter++;
            } else if (counter != 0){
                res.add(counter);
                counter = 0;
            }
        }
        if(counter != 0)
            res.add(counter);

        if (areListsEqual(res, nums)) {
            return true;
        }
        return false;
    }

    private static boolean areListsEqual(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }

        return areListsPartiallyEqual(list1, list2);
    }

    private static boolean areListsPartiallyEqual(List<Integer> list1, List<Integer> list2) {
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }

        return true;
    }
    private static Set<Character> convertToSet(char[] array) {
        Set<Character> set = new HashSet<>();
        for (char c : array) {
            set.add(c);
        }
        return set;
    }

    private static String[] getInput(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            return lines.stream()
                    .toArray(String[]::new);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        return null;
    }

}
