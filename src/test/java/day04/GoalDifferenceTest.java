package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoalDifferenceTest {

    GoalDifference goalDifference = new GoalDifference();

    @Test
    void testFileImportFail() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> goalDifference.findSmallestGoalDifference("football.daat"));
        assertEquals("Cannot read file.", iae.getMessage());
    }

    @Test
    void testSmallestTempSpread() {
        String result = goalDifference.findSmallestGoalDifference("football.dat");
        assertEquals("Aston_Villa", result);
    }

}