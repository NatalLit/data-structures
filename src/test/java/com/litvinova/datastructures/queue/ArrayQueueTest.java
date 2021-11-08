package com.litvinova.datastructures.queue;
//    void enqueue (Object value);
//    Object dequeue();
//    Object peek();
//    int size();
//    boolean isEmpty();
//    boolean contains (Object value);
//    void clear();
//    //[A,B,C] if size =3
//    String toString();

import com.litvinova.datastructures.stack.ArrayStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayQueueTest {

    @Test
    public void testEnqueueAndDequeueWorkCorrectlyAndChangeSize() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        Assertions.assertEquals(2, arrayQueue.size());
        Assertions.assertEquals("A", arrayQueue.dequeue());
        Assertions.assertEquals("B", arrayQueue.dequeue());
        Assertions.assertEquals(0, arrayQueue.size());

        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testPeekWorkCorrectly() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        Assertions.assertEquals(2, arrayQueue.size());
        Assertions.assertEquals("A", arrayQueue.peek());
        Assertions.assertEquals("A", arrayQueue.peek());
        Assertions.assertEquals(2, arrayQueue.size());

    }

    @Test
    public void testIsEmptyReturnTrueOnNewQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnFalseOnQueueWithData() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        assertFalse(arrayQueue.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnQueueAfterClear() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        arrayQueue.clear();

        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void testContainsReturnTrue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        assertTrue(arrayQueue.contains("A"));
    }

    @Test
    public void testContainsReturnFalse() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        assertFalse(arrayQueue.contains("C"));
    }

    @Test
    public void testContainsReturnFalseOnEmptyStack() {
        ArrayQueue arrayQueue = new ArrayQueue();

        assertFalse(arrayQueue.contains("A"));
    }

    @Test
    public void testThrowIllegalStateExceptionWhenDequeueOnEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            arrayQueue.dequeue();
        });
    }

    @Test
    public void testToStringWorkCorrectly() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");

        Assertions.assertEquals("[A, B, C]", arrayQueue.toString());
    }




}
