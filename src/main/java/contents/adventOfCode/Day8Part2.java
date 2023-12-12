package contents.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day8Part2 {

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
        int i = 0;
        int counter = 0;
        while(true){
            char ch = chars[i];
            steps = moveAll(steps, dirs, ch);

            if (allElementsEndWithZ(steps)) {
                counter += i;
                counter++;
                System.out.println(counter);
            }

            i++;
            if (i == chars.length) {
                i = 0;
                counter += (chars.length);
            }
        }
    }

    private static List<String> moveAll(List<String> steps, Map<String, Direction> dirs, char ch) {
        List<String> nextSteps = new LinkedList();
        for (String step: steps) {
            if (ch == 'L'){
                nextSteps.add(dirs.get(step).left);
            } else {
                nextSteps.add(dirs.get(step).right);
            }
        }

        return nextSteps;
    }

    private static boolean allElementsEndWithZ(List<String> steps) {
        return steps.stream().allMatch(from -> from.charAt(2)== 'Z');
    }

}
