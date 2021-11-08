package com.litvinova.datastructures.queue;

import java.util.Arrays;

public class ArrayQueue implements Queue {
    private int size;
    private int count;
    private Object[] array;

    ArrayQueue() {
        array = new Object[5];
    }

    @Override
    public void enqueue(Object value) {
        if (array.length == size) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = value;
        size++;

    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        Object result = array[count];
        count++;
        size--;

        return result;
    }

    @Override
    public Object peek() {
        return array[count];
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
        for (int i = 0; i < size; i++) {
            Object valueInQueue = array[i];
            if (value.equals(valueInQueue)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;

    }

    @Override
    public String toString() {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                count++;
            }
        }
        Object[] newArray = new Object[count];
        count = 0;
        for (int i = 0; i < array.length; i++) {

            if (array[i] != null) {
                newArray[count] = array[i];
                count++;
            }
        }
        return Arrays.toString(newArray);
    }
}






