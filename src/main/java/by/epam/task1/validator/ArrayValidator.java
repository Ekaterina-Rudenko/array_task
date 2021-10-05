package by.epam.task1.validator;

import by.epam.task1.entity.CustomArray;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayValidator {
    public static final String REGEX_IS_NUMERICAL_STRING = "^-?\\d+([,](-?\\d+))*$";

    public boolean isValidString(String inputLine) {
        boolean isValidLine = false;
        Pattern pattern = Pattern.compile(REGEX_IS_NUMERICAL_STRING);
        Matcher matcher = pattern.matcher(inputLine);
        if (matcher.matches()) {
            isValidLine = true;
        }
        return isValidLine;
    }
    public boolean isNonEmpty(int[] arrayToValidate){
        boolean isNonEmptyArray = false;
        if(arrayToValidate != null || arrayToValidate.length != 0){
            isNonEmptyArray = true;
        }
        return isNonEmptyArray;
    }
}
