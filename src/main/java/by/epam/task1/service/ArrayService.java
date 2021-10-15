package by.epam.task1.service;

import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface ArrayService {
    OptionalInt findMax(CustomArray customArray) throws CustomArrayException;
    OptionalInt findMin(CustomArray customArray) throws CustomArrayException;
    int findSumOfElements(CustomArray customArray) throws CustomArrayException;
    OptionalDouble findAverage(CustomArray customArray) throws CustomArrayException;
    int[] swapNegativeElement(CustomArray customArray, int replaceValue);
    int countPositive(CustomArray customArray);
    int countNegative(CustomArray customArray);
    int[] quickSort(CustomArray customArray);
    int[] insertionSort(CustomArray customArray);
    int[] shellSort(CustomArray customArray);
}
