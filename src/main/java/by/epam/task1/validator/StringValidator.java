package by.epam.task1.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {
    public static final String REGEX_IS_NUMERICAL_STRING = "(-?\\d+\\,)+";

    public boolean validateString(String inputLine) {
        boolean isValidLine = false;
        Pattern pattern = Pattern.compile(REGEX_IS_NUMERICAL_STRING);
        Matcher matcher = pattern.matcher(inputLine);
        if (matcher.matches()) {
            isValidLine = true;
        }
        return isValidLine;
    }
}
