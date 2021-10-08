package test.by.epam.task1.reader;

import by.epam.task1.exception.CustomArrayException;
import by.epam.task1.reader.InfoReader;
import by.epam.task1.reader.impl.InfoReaderImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class InfoReaderTest {

    InfoReader reader;

    @BeforeMethod
    public void setUp() {
        reader = new InfoReaderImpl();
    }

    @Test
    public void readLineTest() throws CustomArrayException {
        String path = "testdata/test.txt";
        String actual = reader.readLine(path);
        String expected = "45,-3,34,56,22,56,-100,35";
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class, expectedExceptionsMessageRegExp = "The source tesdata/noFile.txt was not found")
    public void readNoFileTest() throws CustomArrayException {
        reader.readLine("tesdata/noFile.txt");
    }

    @Test(expectedExceptions = CustomArrayException.class, expectedExceptionsMessageRegExp = "The file testdata/empty.txt is empty or does not contain valid lines")
    public void readEmptyFileTest() throws CustomArrayException {
        reader.readLine("testdata/empty.txt");
    }

    @Test(expectedExceptions = CustomArrayException.class, expectedExceptionsMessageRegExp = "The file testdata/wrong.txt is empty or does not contain valid lines")
    public void readWrongLineTest() throws CustomArrayException {
        String pathEmptyFile = "testdata/wrong.txt";
        String actual = reader.readLine(pathEmptyFile);
    }

}
