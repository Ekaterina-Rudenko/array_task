package test.by.epam.task1.creator;

import by.epam.task1.creator.ArrayCreator;
import by.epam.task1.creator.impl.ArrayCreatorImpl;
import by.epam.task1.entity.CustomArray;

import by.epam.task1.exception.CustomArrayException;
import by.epam.task1.parser.ArrayParser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayCreatorImplTest {
    ArrayCreator creator;

    @BeforeMethod
    public void setUp() {
        creator = new ArrayCreatorImpl();
    }
    @Test
    public void createCustomArrayTest() throws CustomArrayException {
        CustomArray actual = creator.createCustomArray(new int[]{23, 35, 26});
        CustomArray expected = new CustomArray(new int[]{23, 35, 26});
        assertEquals(actual, expected, "Test failed, CustomArray was not created");
    }
    @Test(expectedExceptions = CustomArrayException.class)
    public void createCustomArrayNegativeTest() throws CustomArrayException {
        int[] array = null;
        CustomArray actual = creator.createCustomArray(array);
    }

}