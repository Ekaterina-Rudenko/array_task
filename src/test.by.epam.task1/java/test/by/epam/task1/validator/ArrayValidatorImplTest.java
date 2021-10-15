package test.by.epam.task1.validator;

import by.epam.task1.validator.ArrayValidator;
import by.epam.task1.validator.impl.ArrayValidatorImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayValidatorImplTest {
    ArrayValidator validator;

    @BeforeMethod
    public void setUp() {
        validator = new ArrayValidatorImpl();
    }

    @Test
    public void validateStringTest() {
        boolean actual = validator.validateString("12, -6, 59, 37");
        assertEquals(actual, true);
    }

    @Test
    public void validateStringTestNegative() {
        boolean actual = validator.validateString("45,dfr,-6,54,32,");
        assertNotEquals(actual, true);
    }

    @Test
    public void validateStringWithoutSpacesTest() {
        boolean actual = validator.validateString("45,-6,54,32");
        assertEquals(actual, true);
    }

    @Test
    public void validateStringNegativeWithoutCommaTest() {
        boolean actual = validator.validateString("45 -6 54 32");
        assertNotEquals(actual, true);
    }

    @Test
    public void validateStringEmptyTest() {
        boolean actual = validator.validateString(null);
        assertEquals(actual, false);
    }

}