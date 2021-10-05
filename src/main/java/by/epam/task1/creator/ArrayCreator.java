package by.epam.task1.creator;

import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;

public interface ArrayCreator {
    public CustomArray createCustomArray(int[] numberArray) throws CustomArrayException;
}
