package by.epam.task1.validator.impl;

import by.epam.task1.validator.ArrayValidator;

public class ArrayValidatorImpl implements ArrayValidator {
    public static final String REGEX_IS_NUMERICAL_STRING = "^-?\\d+([,]\\s?(-?\\d+))*$";

    @Override
    public boolean validateString(String inputLine) {
        boolean isValidLine = false;
        if (inputLine != null && inputLine.matches(REGEX_IS_NUMERICAL_STRING)) {
            isValidLine = true;
        }
        return isValidLine;
    }
}
