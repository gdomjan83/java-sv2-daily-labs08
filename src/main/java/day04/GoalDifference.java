package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GoalDifference {

    public String findSmallestGoalDifference(String fileName) {
        Path path = Paths.get("src/main/resources/" + fileName);
        List<String> data = cleanData(importFile(path));
        return iterateDataAndFindSmallestDifference(data);
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
        for (int i = 1; i < rawData.size(); i++) {
            if (rawData.get(i).charAt(3) != '-') {
                data.add(rawData.get(i));
            }
        }
        return data;
    }

    private String iterateDataAndFindSmallestDifference(List<String> data) {
        int smallestDifference = Integer.MAX_VALUE;
        int teamNumber = 0;
        for (int i = 0; i < data.size(); i++) {
            int difference = getGoalsScored(data.get(i)) - getGoalsSuffered(data.get(i));
            if (difference < smallestDifference) {
                smallestDifference = difference;
                teamNumber = i;
            }
        }
        return data.get(teamNumber).substring(7, 23).trim();
    }


    private int getGoalsSuffered(String line) {
        return Integer.parseInt(line.substring(51, 53).trim());
    }

    private int getGoalsScored(String line) {
        return Integer.parseInt(line.substring(43, 45).trim());
    }

    public static void main(String[] args) {
        System.out.println(new GoalDifference().findSmallestGoalDifference("football.dat"));;
    }
}

