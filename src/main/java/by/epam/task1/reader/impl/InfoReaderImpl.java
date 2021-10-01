package by.epam.task1.reader.impl;

import by.epam.task1.exception.CustomException;
import by.epam.task1.reader.InfoReader;
import by.epam.task1.validator.StringValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class InfoReaderImpl implements InfoReader {
    static Logger logger = LogManager.getLogger();

    @Override
    public String readLine(String input) throws CustomException {
        StringValidator validator = new StringValidator();
        String currentLine = "";

        try (Scanner scanner = new Scanner(new FileReader(input))) {
            do {
                currentLine = scanner.nextLine();
                currentLine.trim();
            } while (scanner.hasNextLine() && (!validator.validateString(currentLine)));
            if (currentLine == null) {
                logger.log(Level.ERROR, "There is no correct line in the source " + input);
                throw new CustomException("There is no correct line in the source" + input);
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.ERROR, "The data source " + input + " was not found", e);
            throw new CustomException();
        }
        return currentLine;
    }
}

