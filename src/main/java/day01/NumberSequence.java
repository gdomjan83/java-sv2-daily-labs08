package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSequence {
    private List<Integer> numbers = new ArrayList<>();

    public NumberSequence(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public NumberSequence(int firstNumber, int lastNumber, int numbersToGet) {
        Random rnd = new Random();
        for (int i = 0; i < numbersToGet; i++) {
            numbers.add(rnd.nextInt(firstNumber, lastNumber + 1));
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> closeToAverage(int value) {
        List<Integer> result = new ArrayList<>();
        double average = (double) addNumbers(numbers) / numbers.size();
        for (Integer num : numbers) {
            if (Math.abs(num - average) <= value) {
                result.add(num);
            }
        }
        return result;
    }

    private int addNumbers(List<Integer> numbers) {
        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }
        return sum;
    }
}
