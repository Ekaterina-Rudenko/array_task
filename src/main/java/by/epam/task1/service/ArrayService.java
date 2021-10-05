package by.epam.task1.service;

import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;

public interface ArrayService  {
    public int findMax(CustomArray customArray);
    public int findMin(CustomArray customArray);
    public int findSumOfElements(CustomArray customArray) throws CustomArrayException;
    public double findAverage(CustomArray customArray) throws CustomArrayException;
    public void swapNegative(CustomArray customArray);
    public int countPositive(CustomArray customArray);
    public int countNegative(CustomArray customArray);
    public int[] quickSort(CustomArray customArray);
    public int[] insertionSort(CustomArray customArray);
    public int[] shellSort(CustomArray customArray);
}
