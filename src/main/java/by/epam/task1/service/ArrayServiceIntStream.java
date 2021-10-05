package by.epam.task1.service;

import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;

public interface ArrayServiceIntStream {
    public int findMaxIntStream(CustomArray customArray);
    public int findMinIntStream(CustomArray customArray);
    public int findSumIntStream(CustomArray customArray) throws CustomArrayException;
    public double findAverageIntStream(CustomArray customArray) throws CustomArrayException;
    public void swapNegativeIntStream(CustomArray customArray);
    public long countPositiveIntStream(CustomArray customArray);
    public long countNegativeIntStream(CustomArray customArray);
}
