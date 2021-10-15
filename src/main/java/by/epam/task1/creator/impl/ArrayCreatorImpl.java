package by.epam.task1.creator.impl;

import by.epam.task1.creator.ArrayCreator;
import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ArrayCreatorImpl implements ArrayCreator {
    static final Logger logger = LogManager.getLogger();

    @Override
    public CustomArray createCustomArray(List<Integer> numberList) throws CustomArrayException {
        if (numberList == null || numberList.isEmpty()) {
            logger.log(Level.ERROR, "The number list is empty, new object can't be created");
            throw new CustomArrayException("The number list is empty, new object can't be created");
        }
        int[] numberArray = new int[numberList.size()];
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = numberList.get(i);
        }
        CustomArray customArray = new CustomArray(numberArray);
        return customArray;
    }
}
