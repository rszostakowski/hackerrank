package contents.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Day8 {

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

        String step = "AAA";
        int i = 0;
        int counter = 0;

        int prev = 0;
        while(true){
            char ch = chars[i];
            if (ch == 'L'){
                step = dirs.get(step).left;
            } else {
                step = dirs.get(step).right;
            }

            if (step.equals("ZZZ")) {
                counter += i;
                counter++;
                System.out.println("counter: " + counter);
                System.out.println("diff: " + (counter - prev));
                prev = counter;
            }

            i++;
            if (i == chars.length) {
                i = 0;
                counter += (chars.length);
            }
        }
    }

}
