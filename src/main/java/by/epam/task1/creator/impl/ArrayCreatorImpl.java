package by.epam.task1.creator.impl;

import by.epam.task1.creator.ArrayCreator;
import by.epam.task1.entity.CustomArray;

public class ArrayCreatorImpl implements ArrayCreator {
    @Override
    public CustomArray factoryArray(int[] numberArray) {
        return new CustomArray(numberArray);
    }
}
