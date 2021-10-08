package by.epam.task1.service;

import by.epam.task1.entity.CustomArray;
import by.epam.task1.exception.CustomArrayException;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface ArrayServiceIntStream {
    OptionalInt findMaxIntStream(CustomArray customArray);
    OptionalInt findMinIntStream(CustomArray customArray);
    int findSumIntStream(CustomArray customArray) throws CustomArrayException;
    OptionalDouble findAverageIntStream(CustomArray customArray) throws CustomArrayException;
    void swapNegativeIntStream(CustomArray customArray);
    long countPositiveIntStream(CustomArray customArray);
    long countNegativeIntStream(CustomArray customArray);
    void sortCustomArrayIntStream(CustomArray customArray);
}
