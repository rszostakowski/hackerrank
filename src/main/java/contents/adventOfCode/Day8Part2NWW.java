package contents.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day8Part2NWW {

    public static void main(String[] args) {
        String filePath = "C:\\dev\\projekty\\hackerrank\\src\\main\\java\\contents\\adventOfCode\\input8.txt";

        String input = "LRRLRRLLRRRLRRLRLRRRLRRLRRRLRLLRRRLRRRLRLRRRLRRLRRLRLRLLLRRRLRRRLRRLRRLRLRRRLRRLLRRLRRLRLLRLRLRRLRLLRLRLRRRLRRLRLLRLRLLRRLRLRRLLLRLRRLRRRLLLRRLRLRRRLLRRLLLRRRLRRRLLLRRLLRLRRLRLRRLLLRLRRLLLLRRLLRRRLRRLRRLRLRLLRLRRRLLRRLLRRLRRLRRLRRLRLLRRLRRRLRLRLLLRRRLLRRRLRRLRRLLLLRRRR";
        //String input = "LLR";

        char[] chars = input.toCharArray();
        Map<String, Direction> dirs = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                Direction dir = new Direction(line);
                dirs.put(dir.from, dir);
            }

        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        List<String> steps = dirs.keySet().stream().filter(from -> from.charAt(2)== 'A').collect(Collectors.toList());
        int[] counters = new int[steps.size()];

        int idx = 0;
        for (String step: steps) {
            int i = 0;
            int counter = 0;

            while(true) {
                char ch = chars[i];
                if (ch == 'L'){
                    step = dirs.get(step).left;
                } else {
                    step = dirs.get(step).right;
                }

                if (step.charAt(2)== 'Z') {
                    counter += i;
                    counter++;
                    counters[idx] = counter;
                    break;
                }

                i++;
                if (i == chars.length) {
                    i = 0;
                    counter += (chars.length);
                }
            }
            idx++;
        }

        long res = calculateNWW(counters);
        System.out.println(res);
    }



    private static long calculateNWD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    private static long calculateNWW(long a, long b) {
        return (a * b) / calculateNWD(a, b);
    }


    private static long calculateNWW(int[] numbers) {
        long result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result = calculateNWW(result, numbers[i]);
        }
        return result;
    }

}
