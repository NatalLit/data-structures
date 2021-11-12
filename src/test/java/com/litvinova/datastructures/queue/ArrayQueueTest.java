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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayQueueTest {
@DisplayName("test enqueue ans dequeue work correctly")
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
    @DisplayName("test peek work correctly")
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
    @DisplayName("test isEmpty work correctly with new Queue")
    @Test
    public void testIsEmptyReturnTrueOnNewQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertTrue(arrayQueue.isEmpty());
    }
    @DisplayName("test isEmpty work correctly when Queue has data")
    @Test
    public void testIsEmptyReturnFalseOnQueueWithData() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        assertFalse(arrayQueue.isEmpty());
    }
    @DisplayName("test isEmpty return true after clear")
    @Test
    public void testIsEmptyReturnTrueOnQueueAfterClear() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        arrayQueue.clear();

        assertTrue(arrayQueue.isEmpty());
    }
    @DisplayName("test contains return true when element exist")
    @Test
    public void testContainsReturnTrue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        assertTrue(arrayQueue.contains("A"));
    }
    @DisplayName("test contains return false on non-existent element")
    @Test
    public void testContainsReturnFalse() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");

        assertFalse(arrayQueue.contains("C"));
    }
    @DisplayName("test contains return false on queue without data")
    @Test
    public void testContainsReturnFalseOnEmptyQueue() {
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
    @DisplayName("test to String work correctly ")
    @Test
    public void testToStringWorkCorrectly() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        arrayQueue.enqueue("C");

        Assertions.assertEquals("[A, B, C]", arrayQueue.toString());
    }




}
