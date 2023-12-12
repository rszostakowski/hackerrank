package contents.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Day2Part1 {
    public static void main(String[] args) {
        String filePath = "C:\\dev\\projekty\\hackerrank\\src\\main\\java\\contents\\adventOfCode\\input21.txt";
        List<Game> input = getInput(filePath);
        int sum = input.stream().filter(Game::isValid).mapToInt(Game::getGameId).sum();
        System.out.println(sum);
        int product = input.stream().mapToInt(Game::getPower).sum();
        System.out.println(product);
    }

    private static List<Game> getInput(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            return lines.stream()
                    .map(GameUtils::parseGame)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        return null;
    }
}