package com.litvinova.datastructures.list;

import java.util.Arrays;
import java.util.StringJoiner;

public class ArrayList implements List {
    private Object[] array;
    private int size;

    public ArrayList() {
        array = new Object[10];
    }

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        if (array.length == size) {
            grow();
        }
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("invalid index");
        } else if (index == size) {
            array[size] = value;
            size++;
        } else {
            for (int i = size - 1; i >= index; i--) {
                array[i + 1] = array[i];
            }
            size++;
        }
        array[index] = value;
    }


    private void grow() {
        Object[] newArray = new Object[(int) (array.length * 1.5)];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }


    @Override
    public Object remove(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("invalid index");
        } else {
            Object removedValue = array[index];
            if (size - index >= 0) System.arraycopy(array, index + 1, array, index, size - index);
            size--;
            return removedValue;
        }

    }

    @Override
    public Object get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("invalid index");
        } else {
            return array[index];
        }
    }

    @Override
    public Object set(Object value, int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("invalid index");
        } else {
            Object previousValue = array[index];
            array[index] = value;
            return previousValue;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == null) {
                throw new NullPointerException();
            }
            Object checkedValue = array[i];
            if (value.equals(checkedValue)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i] == null) {
                throw new NullPointerException();
            }
            Object checkedValue = array[i];
            if (value.equals(checkedValue)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",","[","]");

        for (int i = 0; i < size; i++) {
            stringJoiner.add(array[i].toString());
        }
        return stringJoiner.toString();

    }


}

