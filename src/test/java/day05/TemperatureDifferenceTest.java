package day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperatureDifferenceTest {

    TemperatureDifference tempDiff = new TemperatureDifference();

    @Test
    void testWeatherSmallestTempSpread() {
        String result = tempDiff.findSmallestDifference();
        assertEquals("14", result);
    }
}
