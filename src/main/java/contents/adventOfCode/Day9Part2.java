package contents.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Day9Part2 {

    public static void main(String[] args) {
        String filePath = "C:\\dev\\projekty\\hackerrank\\src\\main\\java\\contents\\adventOfCode\\input9.txt";
        //String filePath = "C:\\dev\\projekty\\hackerrank\\src\\main\\java\\contents\\adventOfCode\\input9example.txt";
        List<int[]> input = getInput(filePath);

        long sum = input.stream().map(Day9Part2::extrapolate).mapToInt(el -> el).sum();
        System.out.println(sum);
    }

    private static int extrapolate(int[] arr) {
        List<int[]> diffs = new LinkedList<>();
        diffs.add(arr);
        int[] steps = arr;
        while(steps.length >1 && Arrays.stream(steps).sum() != 0) {
            int[] diff = new int[steps.length-1];
            for (int i = 1; i<steps.length; i++) {
                diff[i-1] = steps[i] - steps[i-1];
            }
            diffs.add(diff);
            steps = diff;
        }

        int current = 0;
        for (int i = diffs.size()-1; i >= 0; i--) {
            current = diffs.get(i)[0] - current;
            //System.out.println(current);
        }
        //System.out.println(current);
        return current;
    }

    private static List<int[]> getInput(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            return lines.stream()
                    .map(Day9Part2::convertStringToIntArray)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        return null;
    }

    private static int[] convertStringToIntArray(String input) {
        String[] numberStrings = input.split("\\s+");

        int[] result = new int[numberStrings.length];

        for (int i = 0; i < numberStrings.length; i++) {
            result[i] = Integer.parseInt(numberStrings[i]);
        }

        return result;
    }
}
