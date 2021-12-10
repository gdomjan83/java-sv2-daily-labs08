package day05;

public class LineData {
    private String name;
    private int value1;
    private int value2;

    public LineData(String name, int value1, int value2) {
        this.name = name;
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getName() {
        return name;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }
}
