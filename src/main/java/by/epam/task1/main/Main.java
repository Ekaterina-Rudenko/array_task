package by.epam.task1.main;


import by.epam.task1.creator.ArrayCreator;
import by.epam.task1.creator.impl.ArrayCreatorImpl;
import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomException;
import by.epam.task1.parser.ArrayParser;
import by.epam.task1.parser.impl.ArrayParserImpl;
import by.epam.task1.reader.InfoReader;
import by.epam.task1.reader.impl.InfoReaderImpl;
import by.epam.task1.service.ArrayService;
import by.epam.task1.service.impl.ArrayServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        InfoReader reader = new InfoReaderImpl();
        ArrayParser parser = new ArrayParserImpl();
        ArrayCreator creator = new ArrayCreatorImpl();
        ArrayService service = new ArrayServiceImpl();
        String fileName = "data\\info.txt";

        try {
            String correctLine = reader.readLine(fileName);
            int[] numberArray = parser.parseStringToIntegerArray(correctLine);
            CustomArray customArray = creator.factoryArray(numberArray);
            logger.log(Level.INFO, customArray);
            service.findMax(customArray);
            service.findMin(customArray);
            service.findSumOfElements(customArray);
            service.findAverage(customArray);
            service.swapNegative(customArray);
            service.countPositive(customArray);
            service.countNegative(customArray);
            service.shellSort(customArray);
        } catch (CustomException e) {
            logger.log(Level.ERROR, e);
        }

    }

}

