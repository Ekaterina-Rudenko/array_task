package by.epam.task1.reader;

import by.epam.task1.exception.CustomException;

public interface InfoReader {
    public String readLine(String input) throws CustomException;
}
