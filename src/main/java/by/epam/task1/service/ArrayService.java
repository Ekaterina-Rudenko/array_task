package by.epam.task1.service;

import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;

public interface ArrayService  {
    int findMax(CustomArray customArray);
    int findMin(CustomArray customArray);
    int findSumOfElements(CustomArray customArray) throws CustomArrayException;
    double findAverage(CustomArray customArray) throws CustomArrayException;
    void swapNegative(CustomArray customArray);
    int countPositive(CustomArray customArray);
    int countNegative(CustomArray customArray);
    int[] quickSort(CustomArray customArray);
    int[] insertionSort(CustomArray customArray);
    int[] shellSort(CustomArray customArray);
}
