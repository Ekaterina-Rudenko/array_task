package test.by.epam.task1.service;

import by.epam.task1.creator.ArrayCreator;
import by.epam.task1.creator.impl.ArrayCreatorImpl;
import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;
import by.epam.task1.service.ArrayService;
import by.epam.task1.service.impl.ArrayServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayServiceImplTest {
    ArrayService service;
    ArrayCreator creator;
    CustomArray customArray;
    CustomArray customArrayOverflow;
    @BeforeClass
    public void setUp() throws CustomArrayException {
        service = new ArrayServiceImpl();
        creator = new ArrayCreatorImpl();
        customArray = creator.createCustomArray(new int[]{-100 , 878, 88, 9, 23, 59, -222, 678});
        customArrayOverflow = creator.createCustomArray(new int[]{5, 2147483646, 1});
    }
    @Test
    public void findMinTest() {
        int actual = service.findMin(customArray);
        int expected = -222;
        assertEquals(actual, expected);
    }
    @Test
    public void findMaxTest()  {
        int actual = service.findMax(customArray);
        int expected = 878;
        assertEquals(actual, expected);
    }
    @Test
    public void findAverageTest() throws CustomArrayException {
        double actual = service.findAverage(customArray);
        double expected = 176.625;
        assertEquals(actual, expected);
    }
    @Test
    public void findSumTest() throws CustomArrayException {
        int actual = service.findSumOfElements(customArray);
        int expected = 1413;
        assertEquals(actual, expected);
    }
    @Test(expectedExceptions = CustomArrayException.class)
    public void findSumOverflowTest() throws CustomArrayException {
        int actual = service.findSumOfElements(customArrayOverflow);
    }
    @Test
    public void countPositiveTest() {
        int actual = service.countPositive(customArray);
        int expected = 6;
        assertEquals(actual, expected);
    }
    @Test
    public void countNegativeTest()  {
        int actual = service.countNegative(customArray);
        int expected = 2;
        assertEquals(actual, expected);
    }
}
