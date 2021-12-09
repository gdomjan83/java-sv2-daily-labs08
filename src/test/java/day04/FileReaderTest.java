package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileReaderTest {

    FileReader fileReader = new FileReader();
    FileReader goalDifference = new FileReader();

    @Test
    void testWeatherFileImportFail() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> fileReader.findSmallestTemperatureSpread("weather.daat"));
        assertEquals("Cannot read file.", iae.getMessage());
    }

    @Test
    void testWeatherSmallestTempSpread() {
        int result = fileReader.findSmallestTemperatureSpread("weather.dat");
        assertEquals(14, result);
    }

    @Test
    void testFootballFileImportFail() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> goalDifference.findSmallestGoalDifference("football.daat"));
        assertEquals("Cannot read file.", iae.getMessage());
    }

    @Test
    void testFootballSmallestTempSpread() {
        String result = goalDifference.findSmallestGoalDifference("football.dat");
        assertEquals("Aston_Villa", result);
    }
}
