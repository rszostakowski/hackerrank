package contents.adventOfCode;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static contents.adventOfCode.Day10Part1.saveMatrices;

public class Day10Part2 {

    public static void main(String[] args) {
        String filePath = "C:\\dev\\projekty\\hackerrank\\src\\main\\java\\contents\\adventOfCode\\input10saved5.txt";
        char[][] input = getInput(filePath);
        char[][] originalInput = getInput("C:\\dev\\projekty\\hackerrank\\src\\main\\java\\contents\\adventOfCode\\input101.txt");


        startEating(input, 0,0);
        int counter = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                char cur = input[i][j];
                if (cur != 'x' && cur != '#') {
                    counter++;
                }
            }
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                char cur = input[i][j];
                if (cur == '#') {
                    input[i][j]= originalInput[i][j];
                }
            }
        }
        saveMatrices(input,"C:\\dev\\projekty\\hackerrank\\src\\main\\java\\contents\\adventOfCode\\input10saved6.txt");
        System.out.println(counter);
    }

    public static void startEating(char[][] input, int row, int col) {
        if (row < input.length
                && row >= 0
                && col >= 0
                && col < input[0].length) {
            int cur = input[row][col];

            if(cur != '#' && cur != 'x') {
                input[row][col] = 'x';
                int[] dx = {1, 0, -1, 0};
                int[] dy = {0, 1, 0, -1};

                for (int i = 0; i < 4; i++) {
                    int newRow = row + dx[i];
                    int newCol = col + dy[i];
                    startEating(input, newRow, newCol);
                }
            }
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
