package by.epam.task1.service.impl;

import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;
import by.epam.task1.service.ArrayService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayServiceImpl implements ArrayService {
    public static Logger logger = LogManager.getLogger();

    @Override
    public int findMax(CustomArray customArray) {
        int[] array = customArray.getArray();
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        logger.log(Level.INFO, "The maximum elements is " + max);
        return max;
    }

    @Override
    public int findMin(CustomArray customArray) {
        int[] array = customArray.getArray();
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        logger.log(Level.INFO, "The minimum elements is " + min);
        return min;
    }

    @Override
    public int findSumOfElements(CustomArray customArray) throws CustomArrayException {
        int sum = 0;
        int[] array = customArray.getArray();
        for (int i = 0; i < array.length; i++) {
            int delta;
            if (sum >= 0) {
                delta = Integer.MAX_VALUE - sum;
            } else {
                delta = Integer.MIN_VALUE - sum;
            }
            if ((delta > 0 && delta > array[i]) || (delta < 0 && delta < array[i])){
            sum += array[i];
        } else{
            logger.error("There is integer overflow while counting the sum of elements of " + customArray);
            throw new CustomArrayException("There is integer overflow while counting the sum of elements of " + customArray);
        }}
        logger.log(Level.INFO, "The sum of elements is " + sum);
        return sum;
    }

    @Override
    public double findAverage(CustomArray customArray) throws CustomArrayException {
        int arraySize = customArray.getArray().length;
        double average = (double)findSumOfElements(customArray) / arraySize;
        logger.log(Level.INFO, "The average of elements is " + average);
        return average;
    }

    @Override
    public void swapNegative(CustomArray customArray) {
        final int REPLACE_NEGATIVE_VALUE = 9999;
        int[] array = customArray.getArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = REPLACE_NEGATIVE_VALUE;
            }
        }
        logger.log(Level.INFO, "The array after swapping negative elements to 100 is " + Arrays.toString(array));
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
        reqursiveQuickSort(array, 0, array.length-1);
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
        int gap = array.length / 2;
        while (gap > 0) {
            for (int i = 0; i < (array.length - gap); i++) {
                int j = i;
                while (j >= 0 && (array[j] > array[i + gap])) {
                    int temp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = temp;
                    j = j - gap;
                }
            }
            gap = gap / 2;
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
