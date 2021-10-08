package by.epam.task1.reader;

import by.epam.task1.exception.CustomArrayException;

public interface InfoReader {
    String readLine(String path) throws CustomArrayException;
}
