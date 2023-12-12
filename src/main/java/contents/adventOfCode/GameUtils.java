package contents.adventOfCode;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameUtils {
    public static void main(String[] args) {
        String input = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";

        Game game = parseGame(input);

        // Print the game details
        System.out.println("Game ID: " + game.getGameId());
        for (int i = 0; i < game.getGameSets().size(); i++) {
            System.out.println("Game Set " + (i + 1) + ": " + game.getGameSets().get(i));
        }
    }

    public static Game parseGame(String input) {
        // Parse game ID
        Pattern gameIdPattern = Pattern.compile("Game (\\d+):");
        Matcher gameIdMatcher = gameIdPattern.matcher(input);

        if (gameIdMatcher.find()) {
            int gameId = Integer.parseInt(gameIdMatcher.group(1));
            Game game = new Game(gameId);

            // Split input by semicolon
            input = input.split(":")[1];
            String[] sets = input.split(";");

            int idx = 1;
            for (String set : sets) {
                set = set.trim(); // Remove leading/trailing whitespaces

                GameSet gs = new GameSet();
                if (!set.isEmpty()) {
                    Pattern pattern = Pattern.compile("(\\d+)\\s(\\w+)");
                    Matcher matcher = pattern.matcher(set);

                    while (matcher.find()) {
                        int number = Integer.parseInt(matcher.group(1));
                        String color = matcher.group(2);

                        if (color.equals("blue")) {
                            gs.setBlue(number);
                        } else if (color.equals("red")) {
                            gs.setRed(number);
                        }else if (color.equals("green")) {
                            gs.setGreen(number);
                        }
                    }

                    game.addGameSet(gs);
                }
            }

            return game;
        } else {
            throw new IllegalArgumentException("Invalid input format for the game.");
        }
    }
}

class Game {
    private int gameId;
    private List<GameSet> gameSets = new LinkedList<>();

    public Game(int gameId) {
        this.gameId = gameId;
    }

    public int getGameId() {
        return gameId;
    }

    public List<GameSet> getGameSets() {
        return gameSets;
    }

    public void addGameSet(GameSet gs) {
        gameSets.add(gs);
    }

    public boolean isValid() {
        return gameSets.stream().allMatch(gs -> gs.getBlue() <= 14 && gs.getGreen() <= 13 && gs.getRed() <= 12);
    }

    public int getPower() {
        int red = 0;
        int blue = 0;
        int green = 0;
        for (GameSet gs : gameSets) {
            red = Math.max(gs.getRed(), red);
            blue = Math.max(gs.getBlue(), blue);
            green = Math.max(gs.getGreen(), green);
        }

        int product = red * blue * green;
        if (product == 0)
            throw new RuntimeException("Error");
        //System.out.println(product);
        return product;
    }
}

class GameSet {
    private int blue;
    private int red;
    private int green;

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    @Override
    public String toString() {
        return "int blue = " + blue + ", int red = " + red + ", int green = " + green + ";";
    }
}
