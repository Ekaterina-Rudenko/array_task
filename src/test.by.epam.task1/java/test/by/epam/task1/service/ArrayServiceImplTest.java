package test.by.epam.task1.service;

import by.epam.task1.creator.ArrayCreator;
import by.epam.task1.creator.impl.ArrayCreatorImpl;
import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;
import by.epam.task1.service.ArrayService;
import by.epam.task1.service.impl.ArrayServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import static org.testng.Assert.assertEquals;

public class ArrayServiceImplTest {
    ArrayService service;
    ArrayCreator creator;
    CustomArray customArrayTest;
    CustomArray customArrayOverflow;
    final int REPLACE_VALUE_TEST = 999999;

    @BeforeClass
    public void setUp() throws CustomArrayException {
        service = new ArrayServiceImpl();
        creator = new ArrayCreatorImpl();
        customArrayTest = creator.createCustomArray(List.of(100, -170, 878, 88, 9, 23, 59, -222, 678));
        customArrayOverflow = creator.createCustomArray(List.of(5, 2147483646, 1));
    }

    @Test
    public void findMinTest() throws CustomArrayException {
        OptionalInt actual = service.findMin(customArrayTest);
        OptionalInt expected = OptionalInt.of(-222);
        assertEquals(actual, expected);
    }

    @Test
    public void findMinNullTest() throws CustomArrayException {
        OptionalInt actual = service.findMin(null);
        OptionalInt expected = OptionalInt.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void findMinEmptyArrayTest() throws CustomArrayException {
        OptionalInt actual = service.findMin(new CustomArray(new int[]{}));
        OptionalInt expected = OptionalInt.empty();
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void findMinEmptyListTest() throws CustomArrayException {
        OptionalInt actual = service.findMin(creator.createCustomArray(List.of()));
    }

    @Test
    public void findMaxTest() throws CustomArrayException {
        OptionalInt actual = service.findMax(customArrayTest);
        OptionalInt expected = OptionalInt.of(878);
        assertEquals(actual, expected);
    }

    @Test
    public void findMaxNullTest() throws CustomArrayException {
        OptionalInt actual = service.findMax(null);
        OptionalInt expected = OptionalInt.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void findMaxEmptyArrayTest() throws CustomArrayException {
        OptionalInt actual = service.findMax(new CustomArray(new int[]{}));
        OptionalInt expected = OptionalInt.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void findAverageTest() throws CustomArrayException {
        double actual = service.findAverage(customArrayTest).getAsDouble();
        double expected = OptionalDouble.of(160.333).getAsDouble();
        assertEquals(actual, expected, 0.001);
    }

    @Test
    public void findAverageEmptyArrayTest() throws CustomArrayException {
        OptionalDouble actual = service.findAverage(new CustomArray(new int[]{}));
        OptionalDouble expected = OptionalDouble.of(Double.NaN);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void findAverageNullTest() throws CustomArrayException {
        OptionalDouble actual = service.findAverage(null);
    }

    @Test
    public void findSumTest() throws CustomArrayException {
        int actual = service.findSumOfElements(customArrayTest);
        int expected = 1443;
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void findSumOverflowTest() throws CustomArrayException {
        service.findSumOfElements(customArrayOverflow);
    }

    @Test
    public void countPositiveTest() {
        int actual = service.countPositive(customArrayTest);
        int expected = 7;
        assertEquals(actual, expected);
    }

    @Test
    public void countPositiveEmptyArrayTest() {
        int actual = service.countPositive(new CustomArray(new int[]{}));
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void countNegativeTest() {
        int actual = service.countNegative(customArrayTest);
        int expected = 2;
        assertEquals(actual, expected);
    }

    @Test
    public void swapNegativeElementTest() {
        int[] actual = service.swapNegativeElement(customArrayTest, REPLACE_VALUE_TEST);
        int[] expected = {100, 999999, 878, 88, 9, 23, 59, 999999, 678};
        assertEquals(actual, expected);
    }

    @Test
    public void shellSortTest() {
        int[] actual = service.shellSort(customArrayTest);
        int[] expected = {-222, -170, 9, 23, 59, 88, 100, 678, 878};
        assertEquals(actual, expected);
    }

    @Test
    public void quickSortTest() {
        int[] actual = service.quickSort(customArrayTest);
        int[] expected = {-222, -170, 9, 23, 59, 88, 100, 678, 878};
        assertEquals(actual, expected);
    }

    @Test
    public void insertionSortTest() {
        int[] actual = service.insertionSort(customArrayTest);
        int[] expected = {-222, -170, 9, 23, 59, 88, 100, 678, 878};
        assertEquals(actual, expected);
    }

    @Test
    public void insertionSortEmptyArrayTest() {
        int[] actual = service.insertionSort(new CustomArray(new int[]{}));
        int[] expected = {};
        assertEquals(actual, expected);
    }

}
