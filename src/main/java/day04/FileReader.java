package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public int findSmallestTemperatureSpread(String fileName) {
        Path path = Paths.get("src/main/resources/" + fileName);
        List<String> data = cleanData(importFile(path));
        return iterateDataAndFindSmallestDay(data);
    }

    private List<String> importFile(Path path) {
        try {
            return new ArrayList<String>(Files.readAllLines(path));
        } catch (IOException ioe){
            throw new IllegalArgumentException("Cannot read file.", ioe);
        }
    }

    private List<String> cleanData(List<String> rawData) {
        List<String> data = new ArrayList<>();
        for (int i = 2; i < rawData.size() - 1; i++) {
            data.add(rawData.get(i));
        }
        return data;
    }

    private int iterateDataAndFindSmallestDay(List<String> data) {
        int smallestSpread = Integer.MAX_VALUE;
        int day = 0;
        for (int i = 0; i < data.size(); i++) {
            int spread = getMaxTemp(data.get(i)) - getMinTemp(data.get(i));
            if (spread < smallestSpread) {
                smallestSpread = spread;
                day = i + 1;
            }
        }
        return day;
    }

    private int getMaxTemp(String line) {
        return Integer.parseInt(line.substring(6, 8).trim());
    }

    private int getMinTemp(String line) {
        return Integer.parseInt(line.substring(12, 14).trim());
    }
}

