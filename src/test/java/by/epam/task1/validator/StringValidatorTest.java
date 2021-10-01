package by.epam.task1.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringValidatorTest {

    @Test
    public void validateStringTest(){
        StringValidator validator= new StringValidator();
        boolean actual = validator.validateString("45,-6,54,32,");
        assertEquals(actual, true);
    }
    @Test
    public void validateStringTestNegative(){
        StringValidator validator= new StringValidator();
        boolean actual = validator.validateString("45,dfr,-6,54,32,");
        assertNotEquals(actual, true);
}}