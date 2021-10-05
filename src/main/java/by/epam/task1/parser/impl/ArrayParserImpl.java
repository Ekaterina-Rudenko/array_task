package by.epam.task1.parser.impl;

import by.epam.task1.exception.CustomArrayException;
import by.epam.task1.parser.ArrayParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayParserImpl implements ArrayParser {
    static final Logger logger = LogManager.getLogger();
    public static final String REGEX_DELIMITER_COMMA = "[,]\\s*";

    @Override
    public int[] parseStringToIntegerArray(String parseString) throws CustomArrayException {
        if (parseString == null) {
            logger.log(Level.ERROR, "Input string for parsing is null");
            throw new CustomArrayException("Input string is null");
        }
        String[] stringArray = parseString.split(REGEX_DELIMITER_COMMA);
        int[] numberArray = new int[stringArray.length];
        try {
            for (int i = 0; i < stringArray.length; i++) {
                numberArray[i] = Integer.parseInt(stringArray[i]);
            }
        } catch (NumberFormatException e) {
            logger.log(Level.ERROR, "The String " + parseString + " cannot be parsed", e);
            throw new SecurityException("The String " + parseString + " cannot be parsed", e);
        }
        return numberArray;
    }
}
