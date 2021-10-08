package by.epam.task1.reader.impl;

import by.epam.task1.exception.CustomArrayException;
import by.epam.task1.reader.InfoReader;
import by.epam.task1.validator.ArrayValidator;
import by.epam.task1.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class InfoReaderImpl implements InfoReader {
    static Logger logger = LogManager.getLogger();

    @Override
    public String readLine(String path) throws CustomArrayException {
        ClassLoader loader = getClass().getClassLoader();
        URL resource = loader.getResource(path);
        if(resource == null){
            logger.log(Level.ERROR, "The source " + path + " was not found");
            throw new CustomArrayException("The source " + path + " was not found");
        }
        String filePath = new File(resource.getFile()).getAbsolutePath();
        ArrayValidator validator = new ArrayValidatorImpl();

        String currentLine = "";

        try (Scanner scanner = new Scanner(new FileReader(filePath))) {
            boolean isCorrect = false;
            while(scanner.hasNextLine() && !isCorrect){
                currentLine = scanner.nextLine();
                if(validator.isValidString(currentLine)){
                    isCorrect = true;
                }
            }
            if (!isCorrect || currentLine == null) {
                logger.log(Level.ERROR, "The file " + path + " is empty or does not contain valid lines");
                throw new CustomArrayException("The file " + path + " is empty or does not contain valid lines");
            }
        } catch (IOException e) {
            logger.log(Level.ERROR, "Reading of " + path + " is failed or interrupted", e);
            throw new CustomArrayException("Reading of " + path + " is failed or interrupted", e);
        }
        return currentLine;
    }
}

