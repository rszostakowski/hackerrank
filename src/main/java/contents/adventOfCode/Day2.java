package contents.adventOfCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day2 {

    public static void main(String[] args) {
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
                    if (Character.isDigit(ch)) {
                        partial = Character.getNumericValue(ch);
                        break;
                    }
                    i++;
                }
                int j = n-1;
                while (j >= 0) {
                    char ch = line.charAt(j);
                    if (Character.isDigit(ch)) {
                        partial = partial *10  +  Character.getNumericValue(ch);
                        break;
                    }
                    j--;
                }
                System.out.println(partial);
                sum += partial;
            }
            System.out.println(sum);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

}
