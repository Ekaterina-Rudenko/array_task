package by.epam.task1.reader.impl;

import by.epam.task1.exception.CustomArrayException;
import by.epam.task1.reader.InfoReader;
import by.epam.task1.validator.ArrayValidator;
import by.epam.task1.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;


public class InfoReaderImpl implements InfoReader {
    static Logger logger = LogManager.getLogger();

    public Optional<String> readLine(String filePath) throws CustomArrayException {
        ArrayValidator validator = new ArrayValidatorImpl();
        URL resource = getClass().getClassLoader().getResource(filePath);
        if (resource == null) {
            logger.log(Level.ERROR, "The source " + filePath + " was not found");
            throw new CustomArrayException("The source " + filePath + " was not found");
        }
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            logger.log(Level.ERROR, "The source " + filePath + "is a directory");
            throw new CustomArrayException("The source " + filePath + "is a directory");
        }
        try {
            Path path = Path.of(file.getPath());
            Optional<String> firstValidLine = Files.lines(path)
                    .filter(validator::validateString)
                    .findFirst();
            return firstValidLine;
        } catch (IOException e) {
            logger.log(Level.ERROR, "Reading of " + filePath + " is failed or interrupted", e);
            throw new CustomArrayException("Reading of " + filePath + " is failed or interrupted", e);
        }
    }
}

