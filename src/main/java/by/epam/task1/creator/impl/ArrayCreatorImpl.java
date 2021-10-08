package by.epam.task1.creator.impl;

import by.epam.task1.creator.ArrayCreator;
import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayCreatorImpl implements ArrayCreator {
    static final Logger logger = LogManager.getLogger();

    @Override
    public CustomArray createCustomArray(int[] numberArray) throws CustomArrayException {
        if (numberArray != null) {
            return new CustomArray(numberArray);
        } else {
            logger.log(Level.ERROR, "The argument array is empty, new object will not be created");
            throw new CustomArrayException("The array is empty, new object will not be created");
        }
    }
}
