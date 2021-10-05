package by.epam.task1.creator.impl;

import by.epam.task1.creator.ArrayCreator;
import by.epam.task1.entity.CustomArray;

import by.epam.task1.exception.CustomArrayException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayCreatorImplTest {

    @Test
    public void factoryArrayTest() throws CustomArrayException {
        ArrayCreator arrayCreator = new ArrayCreatorImpl();
        int[] array = new int[0];
        CustomArray actual = arrayCreator.createCustomArray(array);
        CustomArray expected = new CustomArray(new int[]{23, 35, 26});
        assertEquals(actual, expected);
    }

}