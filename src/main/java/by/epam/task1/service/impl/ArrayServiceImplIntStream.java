package by.epam.task1.service.impl;

import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;
import by.epam.task1.service.ArrayServiceIntStream;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayServiceImplIntStream implements ArrayServiceIntStream {
    static final Logger logger = LogManager.getLogger();
    final int SWAP_VALUE = 999;
    @Override
    public int findMaxIntStream(CustomArray customArray) {
        int max = IntStream.of(customArray.getArray()).max().getAsInt();
        logger.log(Level.INFO, "The maximum by IntStream is " + max);
        return max;
    }

    @Override
    public int findMinIntStream(CustomArray customArray) {
        int min = IntStream.of(customArray.getArray()).min().getAsInt();
        logger.log(Level.INFO, "The minimum by IntStream is " + min);
        return min;
    }
    @Override
    public int findSumIntStream(CustomArray customArray) throws CustomArrayException {
        if(customArray == null){
            throw new CustomArrayException("The array is empty");
        }
        int sum = IntStream.of(customArray.getArray()).sum();
        logger.log(Level.INFO, "The sum by IntStream is " + sum);
        return sum;
    }

    @Override
    public double findAverageIntStream(CustomArray customArray) throws CustomArrayException {
        if(customArray == null){
            throw new CustomArrayException("The array is empty");
        }
        double average = IntStream.of(customArray.getArray())
                .average()
                .getAsDouble();
        logger.log(Level.INFO, "The average by IntStream is " + average);
        return average;
    }

    @Override
    public void swapNegativeIntStream(CustomArray customArray) {
        int [] array = customArray.getArray();
        IntStream intStream = IntStream.of(array).filter(n -> n < 0).map(n -> SWAP_VALUE);
        logger.log(Level.INFO, "The swapped array by IntStream is " + intStream);
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
}
