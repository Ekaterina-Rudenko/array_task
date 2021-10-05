package by.epam.task1.main;


import by.epam.task1.creator.ArrayCreator;
import by.epam.task1.creator.impl.ArrayCreatorImpl;
import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;
import by.epam.task1.parser.ArrayParser;
import by.epam.task1.parser.impl.ArrayParserImpl;
import by.epam.task1.reader.InfoReader;
import by.epam.task1.reader.impl.InfoReaderImpl;
import by.epam.task1.service.ArrayService;
import by.epam.task1.service.ArrayServiceIntStream;
import by.epam.task1.service.impl.ArrayServiceImpl;
import by.epam.task1.service.impl.ArrayServiceImplIntStream;
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
        ArrayServiceIntStream serviceIntStream = new ArrayServiceImplIntStream();
        String fileName = "data\\info.txt";

        try {
            String correctLine = reader.readLine(fileName);
            int[] numberArray = parser.parseStringToIntegerArray(correctLine);
            CustomArray customArray = creator.createCustomArray(numberArray);
            logger.log(Level.INFO, customArray);
            service.findMax(customArray);
            service.findMin(customArray);
            service.findSumOfElements(customArray);
            service.findAverage(customArray);
            service.swapNegative(customArray);
            service.countPositive(customArray);
            service.countNegative(customArray);
            service.shellSort(customArray);
            service.insertionSort(customArray);
            service.quickSort(customArray);
            serviceIntStream.findMinIntStream(customArray);
            serviceIntStream.findMaxIntStream(customArray);
            serviceIntStream.findSumIntStream(customArray);
            serviceIntStream.findAverageIntStream(customArray);
            serviceIntStream.countPositiveIntStream(customArray);
            serviceIntStream.countNegativeIntStream(customArray);
            serviceIntStream.swapNegativeIntStream(customArray);

        } catch (CustomArrayException e) {
            logger.log(Level.ERROR, e);
        }

    }

}

