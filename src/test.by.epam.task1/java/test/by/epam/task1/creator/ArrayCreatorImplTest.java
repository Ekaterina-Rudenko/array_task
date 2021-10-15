package test.by.epam.task1.creator;

import by.epam.task1.creator.ArrayCreator;
import by.epam.task1.creator.impl.ArrayCreatorImpl;
import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ArrayCreatorImplTest {
    ArrayCreator creator;

    @BeforeMethod
    public void setUp() {
        creator = new ArrayCreatorImpl();
    }

    @Test
    public void createCustomArrayTest() throws CustomArrayException {
        CustomArray actual = creator.createCustomArray(List.of(23, 35, 26));
        CustomArray expected = new CustomArray(new int[]{23, 35, 26});
        assertEquals(actual, expected);
    }

    @Test
    public void createCustomArrayNegativeTest() throws CustomArrayException {
        CustomArray actual = creator.createCustomArray(List.of(0, 0, 0, 0, 23, 12));
        CustomArray expected = new CustomArray(new int[]{23, 12});
        assertNotEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void createCustomArrayExceptionTest() throws CustomArrayException {
        List<Integer> numberListTest = null;
        CustomArray actual = creator.createCustomArray(numberListTest);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void createCustomArrayEmptyExceptionTest() throws CustomArrayException {
        CustomArray actual = creator.createCustomArray(List.of());
    }
}