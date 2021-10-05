package by.epam.task1.parser;

import by.epam.task1.exception.CustomArrayException;

public interface ArrayParser {
    public int[] parseStringToIntegerArray(String correctLine) throws CustomArrayException;
}
