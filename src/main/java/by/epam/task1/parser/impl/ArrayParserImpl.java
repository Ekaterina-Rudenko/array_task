package by.epam.task1.parser.impl;

import by.epam.task1.parser.ArrayParser;
import by.epam.task1.validator.ArrayValidator;
import by.epam.task1.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArrayParserImpl implements ArrayParser {
    static final Logger logger = LogManager.getLogger();
    public static final String REGEX_DELIMITER_COMMA = "[,]\\s*";

    @Override
    public List<Integer> parseStringToIntegerList(Optional<String> stringToParse) {
        ArrayValidator validator = new ArrayValidatorImpl();
        List<Integer> numberList = new ArrayList<>();
        if (stringToParse.isPresent() && validator.validateString(stringToParse.get())) {
            String[] stringArray = stringToParse.get().split(REGEX_DELIMITER_COMMA);
            for (String number : stringArray) {
                numberList.add(Integer.parseInt(number));
            }
            logger.log(Level.INFO, "Parsing is completed");
        }
        return numberList;
    }
}


