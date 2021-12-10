package day05;

public class Position {
    private int startPosition;
    private int endPosition;

    public Position(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public String returnString(String line) {
        return line.substring(startPosition, endPosition).trim();
    }

    public int returnInt(String line) {
        return Integer.parseInt(line.substring(startPosition, endPosition).trim());
    }
}
