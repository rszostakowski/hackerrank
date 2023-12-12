package contents.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static contents.adventOfCode.Day10Part1.saveMatrices;

public class Day11 {
    public static void main(String[] args) {
        String filePath = "C:\\dev\\projekty\\hackerrank\\src\\main\\java\\contents\\adventOfCode\\input11.txt";
        char[][] input = getInput(filePath);
        List<Integer> rowsToAdd = new ArrayList<>();
        List<Integer> colsToAdd = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            boolean found = false;
            for (int j = 0; j < input[0].length; j++) {
                if(input[i][j] == '#'){
                    found = true;
                    break;
                }
            }
            if (!found) {
                rowsToAdd.add(i);
                //input = addRow(input, i);
            }
        }

        for (int i = 0; i < input.length; i++) {
            boolean found = false;
            for (int j = 0; j < input[0].length; j++) {
                if(input[j][i] == '#'){
                    found = true;
                    break;
                }
            }
            if (!found) {
                colsToAdd.add(i);
                //input = addColumn(input, i);
            }
        }

        saveMatrices(input,"C:\\dev\\projekty\\hackerrank\\src\\main\\java\\contents\\adventOfCode\\input11extended.txt");
        int idx =1;
        Map<Integer, Point11> points = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == '#') {
                    points.put(idx++, new Point11(i, j));
                }
            }
        }

        int[] ints = points.keySet().stream().mapToInt(p -> p).toArray();
        List<List<Integer>> combinations = generateUniquePairs(ints);

        // Print the combinations
        long sum = 0;
        for (List<Integer> combination : combinations) {
            Integer p1Idx = combination.get(0);
            Point11 p1 = points.get(p1Idx);
            Integer p2Idx = combination.get(1);
            Point11 p2 = points.get(p2Idx);
            if (p1Idx == 1 && p2Idx == 7) {
                if(getDist(p1, p2, colsToAdd, rowsToAdd) != 15){
                    new RuntimeException("1");
                }
            }
            if (p1Idx == 3 && p2Idx == 6) {
                if(getDist(p1, p2, colsToAdd, rowsToAdd) != 17){
                    //throw new RuntimeException("2");
                }
            }
            if (p1Idx == 8 && p2Idx == 9) {
                if(getDist(p1, p2, colsToAdd, rowsToAdd) != 5){
                    //throw new RuntimeException("3");
                }
            }
            if (p1Idx == 5 && p2Idx == 9) {
                if(getDist(p1, p2, colsToAdd, rowsToAdd) != 9){
                    //throw new RuntimeException();
                }
            }
            sum += getDist(p1, p2, colsToAdd, rowsToAdd);
            System.out.println(combination);
        }

        System.out.println(sum);
    }

    public static List<List<Integer>> generateUniquePairs(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        generateUniquePairsHelper(numbers, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generateUniquePairsHelper(int[] numbers, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == 2) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            current.add(numbers[i]);
            generateUniquePairsHelper(numbers, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }


    static long getDist(Point11 p1, Point11 p2, List<Integer> colsToAdd, List<Integer> rowsToAdd) {

        int addX = (int) rowsToAdd .stream().filter(row -> (p1.x < row && row < p2.x) || (p2.x < row && row < p1.x)).count();
        int addY = (int) colsToAdd.stream().filter(col -> (p1.y < col && col < p2.y) || (p2.y < col && col < p1.y)).count();
        long xChange = Math.abs(p2.x - p1.x) + addX * (1000000L-1);
        long yChange = Math.abs(p2.y - p1.y) + addY * (1000000L-1);
        return xChange + yChange;
    }

    static class Point11 {
        int x;
        int y;

        public Point11(int i, int j) {
            x = i;
            y = j;
        }
    }
    private static char[][] getInput(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            return lines.stream()
                    .map(String::toCharArray)
                    .toArray(char[][]::new);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        return null;
    }

}
