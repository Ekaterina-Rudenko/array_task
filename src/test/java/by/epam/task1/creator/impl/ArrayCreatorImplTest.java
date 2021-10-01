package by.epam.task1.creator.impl;

import by.epam.task1.creator.ArrayCreator;
import by.epam.task1.entity.CustomArray;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayCreatorImplTest {

    @Test
    public void factoryArrayTest() {
        ArrayCreator arrayCreator = new ArrayCreatorImpl();
        CustomArray actual = arrayCreator.factoryArray(new int[]{23, 35, 26});
        CustomArray expected = new CustomArray(new int[]{23, 35, 26});
        assertEquals(actual, expected);
    }

}