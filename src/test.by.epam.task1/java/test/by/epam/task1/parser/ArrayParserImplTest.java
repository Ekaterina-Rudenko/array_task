package test.by.epam.task1.parser;

import by.epam.task1.parser.ArrayParser;
import by.epam.task1.parser.impl.ArrayParserImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.*;

public class ArrayParserImplTest {
    ArrayParser parser;

    @BeforeMethod
    public void setUp() {
        parser = new ArrayParserImpl();
    }

    @Test
    public void parseToInt() {
        List<Integer> actual = parser.parseStringToIntegerList(Optional.of("2, -5, 4, 3, 8"));
        List<Integer> expected = List.of(2, -5, 4, 3, 8);
        assertEquals(actual, expected);
    }

    @Test
    public void parseToIntegerArrayExceptionTest() {
        List<Integer> actual = parser.parseStringToIntegerList(Optional.of("2.3, 4.5, 6.7"));
        List<Integer> expected = List.of();
        assertEquals(actual, expected);
    }

    @Test
    public void parseToIntArrayWrongFormatTest() {
        List<Integer> actual = parser.parseStringToIntegerList(Optional.of("2 -5 4 3 8"));
        List<Integer> expected = List.of();
        assertEquals(actual, expected);
    }

    @Test
    public void parseToIntegerArrayEmptyTest() {
        List<Integer> actual = parser.parseStringToIntegerList(Optional.empty());
        List<Integer> expected = new ArrayList<>();
        assertEquals(actual, expected);
    }
}