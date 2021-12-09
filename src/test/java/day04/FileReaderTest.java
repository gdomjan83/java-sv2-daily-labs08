package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileReaderTest {

    FileReader fileReader = new FileReader();

    @Test
    void testFileImportFail() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> fileReader.findSmallestTemperatureSpread("weather.daat"));
        assertEquals("Cannot read file.", iae.getMessage());
    }

    @Test
    void testSmallestTempSpread() {
        int result = fileReader.findSmallestTemperatureSpread("weather.dat");
        assertEquals(14, result);
    }
}
