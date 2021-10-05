package by.epam.task1.creator.impl;

import by.epam.task1.creator.ArrayCreator;
import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;
import by.epam.task1.validator.ArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayCreatorImpl implements ArrayCreator {
    static final Logger logger = LogManager.getLogger();
    ArrayValidator validator = new ArrayValidator();

    @Override
    public CustomArray createCustomArray(int[] numberArray) throws CustomArrayException {
        if (validator.isNonEmpty(numberArray)) {
            return new CustomArray(numberArray);
      } else {
            logger.log(Level.ERROR, "The argument array is empty");
            throw new CustomArrayException("The array is empty");
        }
    }
}
