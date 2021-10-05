package by.epam.task1.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayValidatorTest {

    @Test
    public void validateStringTest(){
        ArrayValidator validator= new ArrayValidator();
        boolean actual = validator.isValidString("45,-6,54,32,");
        assertEquals(actual, true);
    }
    @Test
    public void validateStringTestNegative(){
        ArrayValidator validator= new ArrayValidator();
        boolean actual = validator.isValidString("45,dfr,-6,54,32,");
        assertNotEquals(actual, true);
}}