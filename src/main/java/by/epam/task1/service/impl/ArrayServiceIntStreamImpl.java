package by.epam.task1.service.impl;

import by.epam.task1.entity.CustomArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ArrayServiceIntStreamImpl implements by.epam.task1.service.ArrayServiceIntStream {
    static final Logger logger = LogManager.getLogger();

    @Override
    public OptionalInt findMaxIntStream(CustomArray customArray) {
        OptionalInt max = OptionalInt.empty();
        if (customArray != null) {
            max = IntStream.of(customArray.getArray())
                    .max();
        }
        logger.log(Level.INFO, "The maximum by IntStream is " + max);
        return max;
    }

    @Override
    public OptionalInt findMinIntStream(CustomArray customArray) {
        OptionalInt min = OptionalInt.empty();
        if (customArray != null) {
            min = IntStream.of(customArray.getArray()).min();
        }
        logger.log(Level.INFO, "The minimum by IntStream is " + min);
        return min;
    }

    @Override
    public int findSumIntStream(CustomArray customArray) {
        int sum = IntStream.of(customArray.getArray()).sum();
        logger.log(Level.INFO, "The sum by IntStream is " + sum);
        return sum;
    }

    @Override
    public OptionalDouble findAverageIntStream(CustomArray customArray) {
        OptionalDouble average = IntStream.of(customArray.getArray())
                .average();
        logger.log(Level.INFO, "The average by IntStream is " + average);
        return average;
    }

    @Override
    public int[] swapNegativeIntStream(CustomArray customArray, int replaceValue) {
        int[] array = customArray.getArray();
        array = IntStream.of(array)
                .map(i -> i < 0 ? replaceValue : i)
                .toArray();
        logger.log(Level.INFO, "The swapped array by IntStream is " + Arrays.toString(array));
        return array;
    }

    @Override
    public long countPositiveIntStream(CustomArray customArray) {
        long counter = IntStream.of(customArray.getArray())
                .filter(n -> (n > 0))
                .count();
        logger.log(Level.INFO, "The number of positive elements by IntStream is " + counter);
        return counter;
    }

    @Override
    public long countNegativeIntStream(CustomArray customArray) {
        long counter = IntStream.of(customArray.getArray())
                .filter(n -> (n < 0))
                .count();
        logger.log(Level.INFO, "The number of negative elements by IntStream is " + counter);
        return counter;
    }

    @Override
    public int[] sortCustomArrayIntStream(CustomArray customArray) {
        int[] array = IntStream.of(customArray.getArray()).sorted().toArray();
        logger.log(Level.INFO, "The sorted array by IntStream is " + Arrays.toString(array));
        return array;
    }
}
