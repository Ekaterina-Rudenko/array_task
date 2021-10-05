package by.epam.task1.reader.impl;

import by.epam.task1.exception.CustomArrayException;
import by.epam.task1.reader.InfoReader;
import by.epam.task1.validator.ArrayValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class InfoReaderImpl implements InfoReader {
    static Logger logger = LogManager.getLogger();

    @Override
    public String readLine(String input) throws CustomArrayException {
        ArrayValidator validator = new ArrayValidator();
        String currentLine = "";

        try (Scanner scanner = new Scanner(new FileReader(input))) {
            do {
                currentLine = scanner.nextLine();
                currentLine.trim();
            } while (scanner.hasNextLine() && (!validator.isValidString(currentLine)));
            if (currentLine == null) {
                logger.log(Level.ERROR, "There is no correct line in the source " + input);
                throw new CustomArrayException("There is no correct line in the source" + input);
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.ERROR, "The data source " + input + " was not found", e);
            throw new CustomArrayException("The data source " + input + "was not found", e);
        }
        return currentLine;
    }
}

