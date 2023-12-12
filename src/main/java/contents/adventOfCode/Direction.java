package contents.adventOfCode;

public class Direction {

    String from;
    String left;
    String right;

    public Direction(String s) {
        String[] parts = s.replaceAll("[()\\s]", "").split("=");

        if (parts.length == 2) {
            from = parts[0].trim();
            String[] values = parts[1].split(",");

            if (values.length == 2) {
                left = values[0].trim();
                right = values[1].trim();
            }
        }
    }
}
