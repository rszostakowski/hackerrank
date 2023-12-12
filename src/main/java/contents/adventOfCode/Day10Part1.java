package contents.adventOfCode;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

import static contents.adventOfCode.Day10Part2.startEating;

public class Day10Part1 {
    static Set<Character> validCharacters = new HashSet<>(Arrays.asList('I', 'S', '|', '-', 'F', 'J', '7', 'L'));
    @Test
    public void checkingCanDoMove(){
        String filePath = "C:\\dev\\projekty\\hackerrank\\src\\main\\java\\contents\\adventOfCode\\input101.txt";
        char[][] input = getInput(filePath);
        Assert.assertTrue(canDoMove(input, 2, 1, 1,1, input.length, input[0].length));
        Assert.assertFalse(canDoMove(input, 0, 1, 1,1, input.length, input[0].length));
    }
    static Map<Character, List<Direction>> moves = createPossibleMovesMap();

    public static void main(String[] args) {
        String filePath = "C:\\dev\\projekty\\hackerrank\\src\\main\\java\\contents\\adventOfCode\\input101.txt";
        //String filePath = "C:\\dev\\projekty\\hackerrank\\src\\main\\java\\contents\\adventOfCode\\input9example.txt";
        char[][] input = getInput(filePath);
        Point startingPoint = findS(input);
        Set<List<Point>> loop = findLoop(input, startingPoint);


        char[][] newTable = new char[input.length][input[0].length];
        for (int i = 0; i < newTable.length; i++) {
            for (int j = 0; j < newTable[0].length; j++) {
                newTable[i][j] = input[i][j];
            }
        }
        for (List<Point> points: loop) {
            System.out.println("List has: " + points.size() + " points.");
            System.out.println("Set has: " + new HashSet<>(points).size() + " points.");
            for (Point point: points) {
                newTable[point.x][point.y] = '#';
            }
            saveMatrices(newTable,"C:\\dev\\projekty\\hackerrank\\src\\main\\java\\contents\\adventOfCode\\input10saved4.txt");
        }
        for (List<Point> points: loop) {
            startEating(newTable, 0,0);
            System.out.println(countTrappedTiles(points, newTable));
        }
    }

    private static int countTrappedTiles(List<Point> points, char[][] input) {
        int count = 0;


        List<Point2D.Double> polygon = new ArrayList<>();

        for (int i = 0; i < points.size(); i++) {
            polygon.add(new Point2D.Double(points.get(i).x, points.get(i).y));
        }

        // Sort the points
        polygon.sort(Comparator.comparing(Point2D.Double::getX).thenComparing(Point2D.Double::getY));

        Area polygonArea = createPolygonArea(polygon);
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] !='#' && input[i][j] !='x') {
                    System.out.println(i +","+j);
                    if (isPointInsidePolygon(new Point2D.Double(i, j), polygonArea)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static boolean isPointInsidePolygon(Point2D.Double testPoint, Area polygonArea) {
        return polygonArea.contains(testPoint);
    }
    private static Area createPolygonArea(List<Point2D.Double> polygonPoints) {
        Path2D.Double path = new Path2D.Double();
        path.moveTo(polygonPoints.get(0).getX(), polygonPoints.get(0).getY());

        for (int i = 1; i < polygonPoints.size(); i++) {
            Point2D.Double point = polygonPoints.get(i);
            path.lineTo(point.getX(), point.getY());
        }

        path.closePath();
        return new Area(path);
    }

    private static Set<List<Point>> findLoop(char[][] input, Point startingPoint) {
        Set<List<Point>> bothPaths = new HashSet<>();
        backtracking(bothPaths, input, startingPoint);
        return bothPaths;
    }
    private static void backtracking(Set<List<Point>> bothPaths, char[][] input, Point startingPoint) {
        int rowsN = input.length;
        int colsN = input[0].length;

        Deque<List<Point>> stack = new LinkedList<>();
        Set<Point> visitedSet = new HashSet<>();

        List<Point> initialPath = new LinkedList<>();
        initialPath.add(startingPoint);
        stack.push(initialPath);

        while (!stack.isEmpty()) {
            List<Point> currentPath = stack.pop();

            Point currentPoint = currentPath.get(currentPath.size() - 1);
            int row = currentPoint.x;
            int col = currentPoint.y;

            if (row >= 0 && row < rowsN && col >= 0 && col < colsN) {
                char current = input[row][col];

                if (visitedSet.size() > 10 && row == startingPoint.x && col == startingPoint.y) {
                    bothPaths.add(new LinkedList<>(visitedSet));
                    continue;
                }

                if (visitedSet.contains(currentPoint)) {
                    continue; // Skip already visited points
                }

                visitedSet.add(currentPoint);
                List<Direction> possibleMoves = moves.get(current);
                for (Direction move : possibleMoves) {
                    int newRow = row, newCol = col;

                    switch (move) {
                        case NORTH:
                            newRow--;
                            break;
                        case SOUTH:
                            newRow++;
                            break;
                        case WEST:
                            newCol--;
                            break;
                        case EAST:
                            newCol++;
                            break;
                    }

                    if (newRow >= 0 && newRow < rowsN && newCol >= 0 && newCol < colsN) {
                        char next = input[newRow][newCol];
                        if (isValidMove(current, next)) {
                            List<Point> newPath = new LinkedList<>(currentPath);
                            newPath.add(new Point(newRow, newCol));
                            stack.push(newPath);
                        }
                    }
                }
            }
        }
    }


    private static boolean canDoMove(char[][] input, int row, int col, int prevR, int prevCol, int rowsN, int colsN) {
        if (row < rowsN
                && row >= 0
                && col >= 0
                && col < colsN
                && prevR < rowsN
                && prevR >= 0
                && prevCol >= 0
                && prevCol < colsN) {
            if (row == prevR && col == prevCol) {
                return true;
            }
            return isValidMove(input[prevR][prevCol], input[row][col]);
        }

        return false;
    }

    public static boolean isValidMove(char from, char to) {

        // Check if the characters are in the set

        if (!validCharacters.contains(from) || !validCharacters.contains(to)) {
            return false;
        }

        // Get the possible moves for the 'from' character
        List<Direction> possibleMovesForFrom = moves.get(from);

        // Check if the 'to' character is in the list of possible moves
        for (Direction direction : possibleMovesForFrom) {
            switch (direction) {
                case NORTH:
                    if (to == 'S' || to == '7' || to == 'F' || to == '|') {
                        return true;
                    }
                    break;
                case SOUTH:
                    if (to == 'S' || to == 'L' || to == '|' || to == 'J') {
                        return true;
                    }
                    break;
                case EAST:
                    if (to == 'S' || to == 'J' || to == '-' || to == '7') {
                        return true;
                    }
                    break;
                case WEST:
                    if (to == 'S' || to == 'L' || to == '-' || to == 'F') {
                        return true;
                    }
                    break;
            }
        }

        return false;
    }

    private static Point findS(char[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 'S') {
                    return new Point(i, j);
                }
            }
        }
        return null;
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

    static class Point {
        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        int x;
        int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        public Point(int i, int j) {
            x = i;
            y = j;
        }
    }

    public static Map<Character, List<Direction>> createPossibleMovesMap() {
        Map<Character, List<Direction>> possibleMoves = new HashMap<>();

        // Adding possible moves for each character
        addMove(possibleMoves, '|', Direction.NORTH, Direction.SOUTH);
        addMove(possibleMoves, '-', Direction.EAST, Direction.WEST);
        addMove(possibleMoves, 'L', Direction.NORTH, Direction.EAST);
        addMove(possibleMoves, 'J', Direction.NORTH, Direction.WEST);
        addMove(possibleMoves, '7', Direction.SOUTH, Direction.WEST);
        addMove(possibleMoves, 'F', Direction.SOUTH, Direction.EAST);
        addMove(possibleMoves, 'S', Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST);

        return possibleMoves;
    }

    public enum Direction {
        NORTH,
        SOUTH,
        WEST,
        EAST
    }
    private static void addMove(Map<Character, List<Direction>> movesMap, char pipe, Direction... directions) {
        List<Direction> moves = Arrays.asList(directions);
        movesMap.put(pipe, moves);
    }

    public static void saveMatrices(char[][] matrix1, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            saveMatrix(writer, matrix1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveMatrix(BufferedWriter writer, char[][] matrix) throws IOException {
        for (char[] row : matrix) {
            writer.write(row);
            writer.newLine();  // Move to the next line after writing each row
        }
    }
}
