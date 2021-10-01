package by.epam.task1.service.impl;

import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomException;
import by.epam.task1.service.ArrayService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayServiceImpl implements ArrayService {
    public static Logger logger = LogManager.getLogger();
    @Override
    public int findMax(CustomArray customArray){
        int[] array = customArray.getNumberArray();
        int max = array[0];
        for(int i =1; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
        }
        logger.log(Level.INFO, "The maximum elements is " + max);
        return max;
    }
    @Override
    public int findMin(CustomArray customArray){
        int[] array = customArray.getNumberArray();
        int min = array[0];
        for(int i =1; i < array.length; i++){
            if (array[i] < min){
                min = array[i];
            }
        }
        logger.log(Level.INFO, "The minimum elements is " + min);
        return min;
    }
    @Override
    public int findSumOfElements(CustomArray customArray) throws CustomException{
        int sum = 0;
        int[] array = customArray.getNumberArray();
        for(int i = 0; i < array.length; i++){
            sum += array[i];
            if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE){
                logger.error("There is integer overflow while counting the sum");
                throw new CustomException("There is integer overflow while counting the sum");
            }
        }
        logger.log(Level.INFO, "The sum of elements is " + sum);
        return sum;
    }
    @Override
    public int findAverage(CustomArray customArray) throws CustomException {
        int arraySize = customArray.getNumberArray().length;
        int average = findSumOfElements(customArray)/arraySize;
        return average;
    }
    @Override
    public void swapNegative(CustomArray customArray){
        final int REPLACE = 100;
        int[] array = customArray.getNumberArray();
        for(int i = 0; i < array.length; i++){
            if(array[i] < 0){
                array[i] = REPLACE;
            }
        }
        logger.log(Level.INFO, "The array after swapping negative elements to 100 is " + Arrays.toString(array));
    }
    @Override
    public int countPositive(CustomArray customArray){
        int[] array = customArray.getNumberArray();
        int counter = 0;
        for(int x: array){
            if (x > 0){
                counter++;
            }
        }
        logger.log(Level.INFO, "There are " + counter + " positive elements");
        return counter;
    }
    @Override
    public int countNegative(CustomArray customArray){
        int[] array = customArray.getNumberArray();
        int counter = 0;
        for(int x: array){
            if (x < 0){
                counter++;
            }
        }
        logger.log(Level.INFO, "There are " + counter + " negative elements");
        return counter;
    }

  /*  @Override
    public CustomArray bubbleSort(CustomArray customArray){

        return sortedArray;
    }*/
    @Override
    public CustomArray shellSort(CustomArray customArray) {
        int[] array = customArray.getNumberArray();
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
        customArray.setNumberArray(array);
        logger.log(Level.INFO, customArray);
        return customArray;
    }

    /*@Override
    public  CustomArray insertionSort(CustomArray customArray){
        return sortedArray;
    }*/
}
