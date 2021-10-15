package by.epam.task1.reader;

import by.epam.task1.exception.CustomArrayException;

import java.util.Optional;

public interface InfoReader {
    Optional<String> readLine(String filePath) throws CustomArrayException;
}
