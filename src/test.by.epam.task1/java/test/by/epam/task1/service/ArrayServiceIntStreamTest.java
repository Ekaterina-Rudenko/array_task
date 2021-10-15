package test.by.epam.task1.service;

import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;
import by.epam.task1.service.ArrayServiceIntStream;
import by.epam.task1.service.impl.ArrayServiceIntStreamImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.OptionalInt;

public class ArrayServiceIntStreamTest {
    ArrayServiceIntStream serviceIntStream;
    CustomArray customArrayTest;
    final int REPLACE_VALUE_TEST = 11111111;

    @BeforeMethod
    public void setUp() {
        serviceIntStream = new ArrayServiceIntStreamImpl();
        customArrayTest = new CustomArray(new int[]{500, 300, -100, 2234, 678, 56, 22});
    }

    @Test
    public void findMaxStreamTest() {
        OptionalInt actual = serviceIntStream.findMaxIntStream(customArrayTest);
        OptionalInt expected = OptionalInt.of(2234);
        assertEquals(actual, expected);
    }

    @Test
    public void findMaxStreamEmptyArrayTest() {
        OptionalInt actual = serviceIntStream.findMaxIntStream(new CustomArray(new int[]{}));
        OptionalInt expected = OptionalInt.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void findMaxStreamNullTest() {
        OptionalInt actual = serviceIntStream.findMaxIntStream(null);
        OptionalInt expected = OptionalInt.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void findMinStreamTest() {
        OptionalInt actual = serviceIntStream.findMinIntStream(customArrayTest);
        OptionalInt expected = OptionalInt.of(-100);
        assertEquals(actual, expected);
    }

    @Test
    public void findMinStreamEmptyArrayTest() {
        OptionalInt actual = serviceIntStream.findMinIntStream(new CustomArray(new int[]{}));
        OptionalInt expected = OptionalInt.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void findMinStreamNullTest() {
        OptionalInt actual = serviceIntStream.findMinIntStream(null);
        OptionalInt expected = OptionalInt.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void findSumIntStreamTest() {
        int actual = serviceIntStream.findSumIntStream(customArrayTest);
        int expected = 3690;
        assertEquals(actual, expected);
    }

    @Test
    public void findSumIntStreamEmptyArrayTest() {
        int actual = serviceIntStream.findSumIntStream(new CustomArray(new int[]{}));
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void findAverageIntStreamTest() throws CustomArrayException {
        double actual = serviceIntStream.findAverageIntStream(customArrayTest).getAsDouble();
        double expected = 527.143;
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void countPositiveIntStreamTest() {
        long actual = serviceIntStream.countPositiveIntStream(customArrayTest);
        long expected = 6;
        assertEquals(actual, expected);
    }

    @Test
    public void countNegativeIntStreamTest() {
        long actual = serviceIntStream.countNegativeIntStream(customArrayTest);
        long expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void sortIntStreamTest() {
        int[] actual = serviceIntStream.sortCustomArrayIntStream(customArrayTest);
        int[] expected = {-100, 22, 56, 300, 500, 678, 2234};
        assertEquals(actual, expected);
    }

    @Test
    public void swapNegativeElementIntStreamTest() {
        int[] actual = serviceIntStream.swapNegativeIntStream(customArrayTest, REPLACE_VALUE_TEST);
        int[] expected = {500, 300, 11111111, 2234, 678, 56, 22};
        assertEquals(actual, expected);
    }
}
