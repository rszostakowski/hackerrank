package contents.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Day1Part2 {
    static Map<String, Integer> nums = Map.of(
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9);

    public static void main(String[] args) {
        //getFirstWrittenNum("zoneight234");
        //getLastWrittenNum("eightwothree");
        String filePath = "C:\\dev\\projekty\\hackerrank\\src\\main\\java\\contents\\adventOfCode\\input.txt";


        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            String[] linesArray = lines.toArray(new String[0]);

            int sum = 0;
            for (String line : linesArray) {

                int i = 0;
                int n = line.length();
                int partial = 0;
                while (i <n) {
                    char ch = line.charAt(i);
                    if (Character.isDigit(ch) && ch != '0') {
                        partial = Character.getNumericValue(ch);
                        break;
                    }
                    i++;
                }
                String sub = line.substring(0, i);
                Optional<Integer> writtenNumOpt = getFirstWrittenNum(sub);
                if (writtenNumOpt.isPresent()){
                    partial = writtenNumOpt.get();
                }

                int j = n-1;
                int last = -1;
                while (j >= 0) {
                    char ch = line.charAt(j);
                    if (Character.isDigit(ch)) {
                        last = Character.getNumericValue(ch);
                        break;
                    }
                    j--;
                }
                String sub2 = line.substring(j+1);
                Optional<Integer> writtenLastNumOpt = getLastWrittenNum(sub2);
                if (writtenLastNumOpt.isPresent()){
                    last = writtenLastNumOpt.get();
                }

                partial = partial *10  + last ;
                System.out.println(partial);
                sum += partial;
            }
            System.out.println(sum);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    private static Optional<Integer> getFirstWrittenNum(String sub) {
        for (int i = 0; i < sub.length(); i++) {
            String partial = sub.substring(i);
            for (String num: nums.keySet()) {
                if (partial.startsWith(num)) {
                    return Optional.of(nums.get(num));
                }
            }
        }
        return Optional.empty();
    }

    private static Optional<Integer> getLastWrittenNum(String sub) {
        for (int i = sub.length()-3; i >=0; i--) {
            String partial = sub.substring(i);
            for (String num: nums.keySet()) {
                if (partial.startsWith(num)) {
                    return Optional.of(nums.get(num));
                }
            }
        }
        return Optional.empty();
    }

}
