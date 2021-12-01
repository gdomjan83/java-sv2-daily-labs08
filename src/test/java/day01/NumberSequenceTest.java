package day01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberSequenceTest {

    @Test
    void testList() {
        NumberSequence ns = new NumberSequence(Arrays.asList(3, 6, 10, 2, 1));

        List<Integer> result = ns.closeToAverage(4);
        List<Integer> expected = Arrays.asList(3, 6, 2, 1);
        assertEquals(expected, result);
    }

    @Test
    void testNumberConstructor() {
        NumberSequence ns = new NumberSequence(1, 10, 5);

        assertEquals(5, ns.getNumbers().size());
    }

}