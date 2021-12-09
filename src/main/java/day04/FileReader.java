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
        List<String> data = cleanWeatherData(importFile(path));
        return findDay(data);
    }

    public String findSmallestGoalDifference(String fileName) {
        Path path = Paths.get("src/main/resources/" + fileName);
        List<String> data = cleanFootballData(importFile(path));
        return findTeam(data);
    }

    private List<String> importFile(Path path) {
        try {
            return new ArrayList<String>(Files.readAllLines(path));
        } catch (IOException ioe){
            throw new IllegalArgumentException("Cannot read file.", ioe);
        }
    }

    private List<String> cleanWeatherData(List<String> rawData) {
        List<String> data = new ArrayList<>();
        for (int i = 2; i < rawData.size() - 1; i++) {
            data.add(rawData.get(i));
        }
        return data;
    }

    private List<String> cleanFootballData(List<String> rawData) {
        List<String> data = new ArrayList<>();
        for (int i = 1; i < rawData.size(); i++) {
            if (rawData.get(i).charAt(3) != '-') {
                data.add(rawData.get(i));
            }
        }
        return data;
    }

    private int findDay(List<String> data) {
        int smallestSpread = Integer.MAX_VALUE;
        int day = 0;
        for (int i = 0; i < data.size(); i++) {
            int spread = getValueFromString(data.get(i), 6, 8) - getValueFromString(data.get(i), 12, 14);
            if (spread < smallestSpread) {
                smallestSpread = spread;
                day = i + 1;
            }
        }
        return day;
    }

    private String findTeam(List<String> data) {
        int smallestDifference = Integer.MAX_VALUE;
        int teamNumber = 0;
        for (int i = 0; i < data.size(); i++) {
            int difference = Math.abs(getValueFromString(data.get(i), 43, 45) - getValueFromString(data.get(i), 50, 52));
            if (difference < smallestDifference) {
                smallestDifference = difference;
                teamNumber = i;
            }
        }
        return data.get(teamNumber).substring(7, 23).trim();
    }

    private int getValueFromString(String line, int startPositon, int endPosition) {
        return Integer.parseInt(line.substring(startPositon, endPosition).trim());
    }
}

