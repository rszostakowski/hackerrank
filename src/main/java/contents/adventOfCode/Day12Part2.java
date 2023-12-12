package contents.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Day12Part2 {
    public static void main(String[] args) {
        String filePath = "C:\\dev\\projekty\\hackerrank\\src\\main\\java\\contents\\adventOfCode\\input12.txt";
        String[] input = getInput(filePath);
        int sum = 0;
        for (String row : input) {
            System.out.println(row);
            String[] split = row.split(" ");
            String patternString = split[0];
            String pattern5times = "";
            List<Integer> nums5times = new LinkedList<>();
            List<Integer> nums = List.of(split[1].split(","))
                    .stream()
                    .map(Integer::parseInt).collect(Collectors.toList());

            for (int i = 0; i <5; i++) {
                pattern5times += patternString;
                nums5times.addAll(nums);
            }

            char[] pattern = pattern5times.toCharArray();


            List<char[]> res = new LinkedList<>();
            backtracking(res, pattern, nums5times, 0, nums5times.stream().mapToInt(e->e).sum());
            sum += res.size();
        }

        System.out.println(sum);
    }

    private static void backtracking(List<char[]> res, char[] pattern, List<Integer> nums, int startIndex, int sum) {
        System.out.println(pattern);
        if (!convertToSet(pattern).contains('?')) {
            System.out.println(pattern);
            if(patternMatches(pattern, nums)) {
                res.add(pattern);
                return;
            }
        }

        if (goodSoFar(pattern, startIndex, nums, sum)) {
            for (int i = startIndex; i < pattern.length; i++) {
                if (pattern[i] == '?') {
                    char[] p1 = Arrays.copyOf(pattern, pattern.length);
                    p1[i] = '.';
                    backtracking(res, p1, nums, i, sum);

                    char[] p2 = Arrays.copyOf(pattern, pattern.length);
                    p2[i] = '#';
                    backtracking(res, p2, nums, i, sum);
                }
            }
        }
    }

    private static boolean goodSoFar(char[] pattern, int endingIdx, List<Integer> nums, int sum) {
        int counter = 0;
        int counterInRow = 0;
        for (char c : pattern) {
            if  (c == '?' || c == '#') {
                counter++;
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
