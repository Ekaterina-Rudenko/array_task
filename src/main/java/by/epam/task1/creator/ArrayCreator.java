package by.epam.task1.creator;

import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;

import java.util.List;

public interface ArrayCreator {
    CustomArray createCustomArray(int[] numberArray) throws CustomArrayException;
}
