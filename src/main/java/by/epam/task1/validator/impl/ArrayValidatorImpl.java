package by.epam.task1.validator.impl;

import by.epam.task1.validator.ArrayValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayValidatorImpl implements ArrayValidator {
    public static final String REGEX_IS_NUMERICAL_STRING = "^-?\\d+([,]\\s?(-?\\d+))*$";
    @Override
    public boolean isValidString(String inputLine) {
        boolean isValidLine = false;
        Pattern pattern = Pattern.compile(REGEX_IS_NUMERICAL_STRING);
        Matcher matcher = pattern.matcher(inputLine);
        if (matcher.matches()) {
            isValidLine = true;
        }
        return isValidLine;
    }
}
