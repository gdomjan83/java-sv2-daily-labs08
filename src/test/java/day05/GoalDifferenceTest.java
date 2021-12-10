package day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoalDifferenceTest {

    GoalDifference goalDifference = new GoalDifference();

    @Test
    void testFootballSmallestTempSpread() {
        String result = goalDifference.findSmallestDifference();
        assertEquals("Aston_Villa", result);
    }
}