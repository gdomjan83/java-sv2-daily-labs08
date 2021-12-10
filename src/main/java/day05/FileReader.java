package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class FileReader {

    public String findSmallestDifference() {
        Path path = Paths.get("src/main/resources/" + getFileName());
        List<String> data = cleanData(importFile(path), getDisregardedLines());
        List<LineData> extractedData = extractData(data, getNamePosition(), getValue1Position(), getValue2Position());
        return getResultWithSmallestDifference(extractedData).getName();
    }

    public abstract String getFileName();

    public abstract List<Integer> getDisregardedLines();

    public abstract Position getNamePosition();

    public abstract Position getValue1Position();

    public abstract  Position getValue2Position();

    private List<String> importFile(Path path) {
        try {
            return new ArrayList<String>(Files.readAllLines(path));
        } catch (IOException ioe){
            throw new IllegalArgumentException("Cannot read file.", ioe);
        }
    }

    private List<String> cleanData(List<String> rawData, List<Integer> disregardLines) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < rawData.size(); i++) {
            if (!disregardLines.contains(i)) {
                data.add(rawData.get(i));
            }
        }
        return data;
    }

    private List<LineData> extractData(List<String> data, Position positionName, Position positionValue1, Position positionValue2) {
        List<LineData> lineDataList = new ArrayList<>();
        for (String line : data) {
            String name = positionName.returnString(line);
            int value1 = positionValue1.returnInt(line);
            int value2 = positionValue2.returnInt(line);
            lineDataList.add(new LineData(name, value1, value2));
        }
        return lineDataList;
    }

    private LineData getResultWithSmallestDifference(List<LineData> data) {
        LineData result = data.get(0);
        for (LineData actual : data) {
            if (actual.getDifference() < result.getDifference()) {
                result = actual;
            }
        }
        return result;
    }
}

