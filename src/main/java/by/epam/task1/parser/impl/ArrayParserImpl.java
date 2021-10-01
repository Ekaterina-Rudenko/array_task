package by.epam.task1.parser.impl;

import by.epam.task1.parser.ArrayParser;

public class ArrayParserImpl implements ArrayParser {
    public static final String REGEX_DELIMETR_COMMA = ",";
    @Override
    public int[] parseStringToIntegerArray(String correctLine) {
        String[] stringArray = correctLine.split(REGEX_DELIMETR_COMMA);
        int[] numberArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            numberArray[i] = Integer.parseInt(stringArray[i]);
        }
        return numberArray;
    }
}
