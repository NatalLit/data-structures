package com.litvinova.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedQueueTest {
    LinkedQueue linkedQueue = new LinkedQueue();

    @DisplayName("test enqueue ans dequeue work correctly")
    @Test
    public void testEnqueueAndDequeueWorkCorrectlyAndChangeSize() {

        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");

        Assertions.assertEquals(2, linkedQueue.size());
        Assertions.assertEquals("A", linkedQueue.dequeue());
        Assertions.assertEquals("B", linkedQueue.dequeue());
        Assertions.assertEquals(0, linkedQueue.size());

        assertTrue(linkedQueue.isEmpty());
    }

    @DisplayName("test peek work correctly")
    @Test
    public void testPeekWorkCorrectly() {

        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");

        Assertions.assertEquals(2, linkedQueue.size());
        Assertions.assertEquals("A", linkedQueue.peek());
        Assertions.assertEquals("A", linkedQueue.peek());
        Assertions.assertEquals(2, linkedQueue.size());

    }

    @DisplayName("test isEmpty work correctly with new Queue")
    @Test
    public void testIsEmptyReturnTrueOnNewQueue() {
        assertTrue(linkedQueue.isEmpty());
    }

    @DisplayName("test isEmpty work correctly when Queue has data")
    @Test
    public void testIsEmptyReturnFalseOnQueueWithData() {
        linkedQueue.enqueue("A");
        assertFalse(linkedQueue.isEmpty());
    }

    @DisplayName("test isEmpty return true after clear")
    @Test
    public void testIsEmptyReturnTrueOnQueueAfterClear() {
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");

        linkedQueue.clear();

        assertTrue(linkedQueue.isEmpty());
    }

    @DisplayName("test contains return true when element exist")
    @Test
    public void testContainsReturnTrue() {
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");

        assertTrue(linkedQueue.contains("A"));
    }

    @DisplayName("test contains return false on non-existent element")
    @Test
    public void testContainsReturnFalse() {
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");

        assertFalse(linkedQueue.contains("C"));
    }

    @DisplayName("test contains return false on queue without data")
    @Test
    public void testContainsReturnFalseOnEmptyQueue() {
        assertFalse(linkedQueue.contains("A"));
    }

    @Test
    public void testThrowIllegalStateExceptionWhenDequeueOnEmptyQueue() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            linkedQueue.dequeue();
        });
    }

    @DisplayName("test to String work correctly ")
    @Test
    public void testToStringWorkCorrectly() {
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        linkedQueue.enqueue("C");

        Assertions.assertEquals("[A,B,C]", linkedQueue.toString());
    }


}
