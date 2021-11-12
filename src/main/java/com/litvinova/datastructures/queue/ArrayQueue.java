package com.litvinova.datastructures.queue;

import java.util.Arrays;

public class ArrayQueue implements Queue {
    private int size;
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
        Object result = array[0];
        for (int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;

        return result;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return array[0];
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
            if (array[i] == null){
                throw new NullPointerException();
            }
            Object valueInQueue = array[i];
            if (value.equals(valueInQueue)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;

    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < size; i++) {

            if (array[i] != null && i!= size-1) {
                stringBuilder.append(array[i] + ", ");

            } else {
                stringBuilder.append(array[i]);
            }

        }
        return  "[" + stringBuilder.toString() + "]" ;

    }
}






