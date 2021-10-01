package by.epam.task1.entity;

import java.util.Arrays;

public class CustomArray {
    public int[] numberArray;

    public CustomArray() {
    }

    public CustomArray(int... numberArray) {
        this.numberArray = numberArray;
    }

    public int[] getNumberArray() {
        return Arrays.copyOf(numberArray, numberArray.length);
    }

    public void setNumberArray(int[] numberArray) {
        this.numberArray = numberArray;
    }

    @Override
    public String toString() {
        return "CustomArray = " + Arrays.toString(numberArray) ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;
        return Arrays.equals(numberArray, that.numberArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(numberArray);
    }
}
