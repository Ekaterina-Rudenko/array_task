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
    public int[] parseToIntegerArray(String stringToParse) throws CustomArrayException {
        if (stringToParse == null) {
            logger.log(Level.ERROR, "String for parsing is empty");
            throw new CustomArrayException("Input string is null");
        }
        String[] stringArray = stringToParse.split(REGEX_DELIMITER_COMMA);
        int[] numberArray = new int[stringArray.length];
        try {
            for (int i = 0; i < numberArray.length; i++) {
                numberArray[i] = Integer.parseInt(stringArray[i]);
            }
        } catch (NumberFormatException e) {
            logger.log(Level.ERROR, "The String " + stringToParse + " cannot be parsed", e);
            throw new CustomArrayException("The String " + stringToParse + " cannot be parsed", e);
        }
        return numberArray;
    }
}
