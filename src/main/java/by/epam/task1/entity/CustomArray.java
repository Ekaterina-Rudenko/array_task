package by.epam.task1.entity;

import by.epam.task1.exception.CustomArrayException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class CustomArray {
    static final Logger logger = LogManager.getLogger();
    public int[] array;

    public CustomArray() {
    }

    public CustomArray(int... array) {
        this.array = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
    }
    public CustomArray(int size) throws CustomArrayException {
        if(size < 0){
            logger.log(Level.ERROR, size + " is incorrect array size");
            throw new CustomArrayException(size + " is incorrect array size");

        }
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public int getArraySize() {
        return array.length;

    }

    public int getElement(int index) throws CustomArrayException {
        if (checkIndex(index)) {
            return array[index];
        } else {
            logger.log(Level.ERROR, "Index " + index + " is out of bounds");
            throw new CustomArrayException("Index " + index + " is out of bounds");
        }
    }

    public void setElement(int index, int value) throws CustomArrayException {
        if (checkIndex(index)) {
            array[index] = value;
        } else {
            logger.log(Level.ERROR, "Index " + index + " is out of bounds");
            throw new CustomArrayException("Index " + index + " is out of bounds");
        }
    }

    @Override
    public String toString() {
        return "CustomArray = " + Arrays.toString(array);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    private boolean checkIndex(int i) {
        return (i >= 0 && i < array.length);
    }
}
