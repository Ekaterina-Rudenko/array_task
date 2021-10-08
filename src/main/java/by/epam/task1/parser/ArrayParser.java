package by.epam.task1.parser;

import by.epam.task1.exception.CustomArrayException;

public interface ArrayParser {
    int[] parseToIntegerArray(String stringToParse) throws CustomArrayException;
}
