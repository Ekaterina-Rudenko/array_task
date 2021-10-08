package test.by.epam.task1.parser;

import by.epam.task1.exception.CustomArrayException;
import by.epam.task1.parser.ArrayParser;
import by.epam.task1.parser.impl.ArrayParserImpl;
import by.epam.task1.reader.impl.InfoReaderImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayParserImplTest {
    ArrayParser parser;
    @BeforeMethod
    public void setUp() {
        parser = new ArrayParserImpl();
    }
    @Test
    public void parseToInt() throws CustomArrayException {
        int[] actual = parser.parseToIntegerArray("2, -5, 4, 3, 8");
        int[] expected = {2, -5, 4, 3, 8};
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class)
    public void parseToIntegerArrayExceptionTest() throws CustomArrayException {
        int[] actual = parser.parseToIntegerArray("2.3, 4.5, 6.7");
    }
    @Test (expectedExceptions = CustomArrayException.class)
    public void parseToIntegerArrayNegativeTest() throws CustomArrayException {
        int[] actual = parser.parseToIntegerArray("2 -5 4 3 8");
    }
    @Test (expectedExceptions = CustomArrayException.class)
    public void parseToIntegerArrayEmptyTest() throws CustomArrayException {
        String toParse = null;
        int[] actual = parser.parseToIntegerArray(toParse);
    }
}