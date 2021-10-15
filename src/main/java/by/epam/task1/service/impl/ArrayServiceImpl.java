package by.epam.task1.service.impl;

import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;
import by.epam.task1.service.ArrayService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class ArrayServiceImpl implements ArrayService {
    public static Logger logger = LogManager.getLogger();

    @Override
    public OptionalInt findMax(CustomArray customArray) throws CustomArrayException {
        OptionalInt maxElement = OptionalInt.empty();
        if (customArray != null && customArray.getArraySize() != 0) {
            int max = customArray.getElement(0);
            for (int i = 1; i < customArray.getArraySize(); i++) {
                if (customArray.getElement(i) > max) {
                    max = customArray.getElement(i);
                }
            }
            maxElement = OptionalInt.of(max);
        }
        logger.log(Level.INFO, "The maximum elements is " + maxElement);
        return maxElement;
    }

    @Override
    public OptionalInt findMin(CustomArray customArray) throws CustomArrayException {
        OptionalInt minElement = OptionalInt.empty();
        if (customArray != null && customArray.getArraySize() != 0) {
        int min = customArray.getElement(0);
        for (int i = 1; i < customArray.getArraySize(); i++) {
            if (customArray.getElement(i) < min) {
                min = customArray.getElement(i);
            }
        } minElement = OptionalInt.of(min);
        }
        logger.log(Level.INFO, "The minimum elements is " + minElement);
        return minElement;
    }

    @Override
    public int findSumOfElements(CustomArray customArray) throws CustomArrayException {
        if(customArray == null){
            logger.log(Level.ERROR, "Can't find sum of null array");
            throw new CustomArrayException("Can't find sum of null array");
        }
        int sum = 0;
        for (int i = 0; i < customArray.getArraySize(); i++) {
            int delta;
            if (sum >= 0) {
                delta = Integer.MAX_VALUE - sum;
            } else {
                delta = Integer.MIN_VALUE - sum;
            }
            if ((delta > 0 && delta > customArray.getElement(i)) || (delta < 0 && delta < customArray.getElement(i))) {
                sum += customArray.getElement(i);
            } else {
                logger.error("There is integer overflow while counting the sum of elements of " + customArray);
                throw new CustomArrayException("There is integer overflow while counting the sum of elements of " + customArray);
            }
        }
        logger.log(Level.INFO, "The sum of elements is " + sum);
        return sum;
    }

    @Override
    public OptionalDouble findAverage(CustomArray customArray) throws CustomArrayException {
        OptionalDouble average = OptionalDouble.of((double) findSumOfElements(customArray) / customArray.getArraySize());
        logger.log(Level.INFO, "The average of elements is " + average);
        return average;
    }

    @Override
    public int[] swapNegativeElement(CustomArray customArray, int replaceValue) {
        int[] array = customArray.getArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = replaceValue;
            }
        }
        logger.log(Level.INFO, "The array after swapping negative elements to 100 is " + Arrays.toString(array));
        return array;
    }

    @Override
    public int countPositive(CustomArray customArray) {
        int[] array = customArray.getArray();
        int counter = 0;
        for (int x : array) {
            if (x > 0) {
                counter++;
            }
        }
        logger.log(Level.INFO, "There are " + counter + " positive elements");
        return counter;
    }

    @Override
    public int countNegative(CustomArray customArray) {
        int[] array = customArray.getArray();
        int counter = 0;
        for (int x : array) {
            if (x < 0) {
                counter++;
            }
        }
        logger.log(Level.INFO, "There are " + counter + " negative elements");
        return counter;
    }

    @Override
    public int[] quickSort(CustomArray customArray) {
        int[] array = customArray.getArray();
        reqursiveQuickSort(array, 0, array.length - 1);
        logger.log(Level.INFO, "Quick sort: " + Arrays.toString(array));
        return array;
    }

    private int[] reqursiveQuickSort(int[] array, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = array[(leftMarker + rightMarker) / 2];
        do {
            while (array[leftMarker] < pivot) {
                leftMarker++;
            }
            while (array[rightMarker] > pivot) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int temp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = temp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightBorder) {
            reqursiveQuickSort(array, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            reqursiveQuickSort(array, leftBorder, rightMarker);
        }
        return array;
    }

    @Override
    public int[] shellSort(CustomArray customArray) {

        int[] array = customArray.getArray();
        int h = array.length/2;
        while(h > 0) {
            for(int i =0; i < (array.length - h); i++ ) {
                int j = i;
                while(j >= 0 && (array[j] > array[j + h])) {
                    int temp = array[j];
                    array[j] = array[j +h];
                    array[j + h]= temp;
                    j = j - h;
                }
            }
            h = h/2;
        }
        logger.log(Level.INFO, "Shell sort: " + Arrays.toString(array));
        return array;
    }

    @Override
    public int[] insertionSort(CustomArray customArray) {
        int[] array = customArray.getArray();
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > current) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = current;
        }
        logger.log(Level.INFO, "Insertion sort: " + Arrays.toString(array));
        return array;
    }
}
