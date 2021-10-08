package by.epam.task1.service.impl;

import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;
import by.epam.task1.service.ArrayServiceIntStream;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayServiceIntStreamImpl implements by.epam.task1.service.ArrayServiceIntStream {
    static final Logger logger = LogManager.getLogger();
    @Override
    public OptionalInt findMaxIntStream(CustomArray customArray) {
        OptionalInt max = IntStream.of(customArray.getArray())
                .max();
        logger.log(Level.INFO, "The maximum by IntStream is " + max);
        return max;
    }
    @Override
    public OptionalInt findMinIntStream(CustomArray customArray) {
        OptionalInt min = IntStream.of(customArray.getArray()).min();
        logger.log(Level.INFO, "The minimum by IntStream is " + min);
        return min;
    }
    @Override
    public int findSumIntStream(CustomArray customArray) throws CustomArrayException {
        int sum = IntStream.of(customArray.getArray()).sum();
        logger.log(Level.INFO, "The sum by IntStream is " + sum);
        return sum;
    }

    @Override
    public OptionalDouble findAverageIntStream(CustomArray customArray) throws CustomArrayException {
        OptionalDouble average = IntStream.of(customArray.getArray())
                .average();
        logger.log(Level.INFO, "The average by IntStream is " + average);
        return average;
    }

    @Override
    public void swapNegativeIntStream(CustomArray customArray) {
        final int SWAP_NEGATIVE_VALUE = 999;
        int [] array = customArray.getArray();
        array = IntStream.of(array)
                .map( i -> i < 0 ? SWAP_NEGATIVE_VALUE : i)
                .toArray();
        logger.log(Level.INFO, "The swapped array by IntStream is " + Arrays.toString(array));
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
    public void sortCustomArrayIntStream(CustomArray customArray){
       int[] array = IntStream.of(customArray.getArray()).sorted().toArray();
       logger.log(Level.INFO, "The sorted array by IntStream is " + Arrays.toString(array));
    }
}
