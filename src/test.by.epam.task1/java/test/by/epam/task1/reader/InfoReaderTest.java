package test.by.epam.task1.reader;

import by.epam.task1.exception.CustomArrayException;
import by.epam.task1.reader.InfoReader;
import by.epam.task1.reader.impl.InfoReaderImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class InfoReaderTest {

    InfoReader reader;

    @BeforeMethod
    public void setUp() {
        reader = new InfoReaderImpl();
    }

    @Test
    public void readLineTest() throws CustomArrayException {
        String path = "testdata/test.txt";
        Optional<String> actual = reader.readLine(path);
        Optional<String> expected = Optional.of("45,-3,34,56,22,56,-100,35");
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = CustomArrayException.class, expectedExceptionsMessageRegExp = "The source tesdata/noFile.txt was not found")
    public void readLineNoFileTest() throws CustomArrayException {
        reader.readLine("tesdata/noFile.txt");
    }

    @Test
    public void readLineEmptyFileTest() throws CustomArrayException {
        Optional<String> actual = reader.readLine("testdata/empty.txt");
        Optional<String> expected = Optional.empty();
        assertEquals(actual, expected);
    }

    @Test
    public void readLineAllWrongLinesTest() throws CustomArrayException {
        Optional<String> actual = reader.readLine("testdata/wrong.txt");
        Optional<String> expected = Optional.empty();
        assertEquals(actual, expected);
    }
}
