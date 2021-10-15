package by.epam.task1.service;

import by.epam.task1.entity.CustomArray;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface ArrayServiceIntStream {
    OptionalInt findMaxIntStream(CustomArray customArray);

    OptionalInt findMinIntStream(CustomArray customArray);

    int findSumIntStream(CustomArray customArray);

    OptionalDouble findAverageIntStream(CustomArray customArray);

    int[] swapNegativeIntStream(CustomArray customArray, int replaceValue);

    long countPositiveIntStream(CustomArray customArray);

    long countNegativeIntStream(CustomArray customArray);

    int[] sortCustomArrayIntStream(CustomArray customArray);
}
