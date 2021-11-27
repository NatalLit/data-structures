package com.litvinova.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractListTest {

    private List list;

    @BeforeEach
    public void before(){
        list = getList();
    }

    protected abstract List getList();

    @DisplayName("test add value to the end of the list")
    @Test
    public void testAddValueAndChangeSize() {
        
        list.add("A");
        list.add("B");

        Assertions.assertEquals(2, list.size());
    }

    @DisplayName("test add value by index")
    @Test
    public void testAddValueByIndexAndChangeSize() {
        
        list.add("A");
        list.add("B");
        list.add("C", 1);


        Assertions.assertEquals("B", list.get(2));
        Assertions.assertEquals(3, list.size());

    }

    @DisplayName("test throw exception when add by invalid index ")
    @Test
    public void testThrowIndexOutOfBoundExceptionWhenAddByInvalidIndex() {
        
        list.add("A");
        list.add("B");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add("C", 3);
        });
    }

    @DisplayName("test remove value by zero index")
    @Test
    public void testRemoveValueByZeroIndex() {
        
        list.add("A");
        list.add("B");
        list.remove(0);

        Assertions.assertEquals("B", list.get(0));
    }

    @DisplayName("test remove last value of thr list")
    @Test
    public void testRemoveLastValue() {

        list.add("A");
        list.add("B");
        list.add("C");
        list.remove(2);

        Assertions.assertEquals(2, list.size());
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(2);
        });
    }


    @DisplayName("test throw exception when remove by invalid index ")
    @Test
    public void testThrowIndexOutOfBoundExceptionWhenRemoveByInvalidIndex() {
        
        list.add("A");
        list.add("B");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(-1);
        });
    }

    @DisplayName("test get value by index")
    @Test
    public void testGetValueByIndex() {
        
        list.add("A");
        list.add("B");

        Assertions.assertEquals("A", list.get(0));
    }

    @DisplayName("test throw exception when get by invalid index ")
    @Test
    public void testThrowIndexOutOfBoundExceptionWhenGetByInvalidIndex() {
        
        list.add("A");
        list.add("B");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(2);
        });
    }

    @DisplayName("test set value by index")
    @Test
    public void testSetValueByIndexWithoutChangeSize() {
        
        list.add("A");
        list.add("B");
        list.set("C", 1);

        Assertions.assertEquals("C", list.get(1));
    }

    @DisplayName("test throw exception when set by invalid index ")
    @Test
    public void testThrowIndexOutOfBoundExceptionWhenSetByInvalidIndex() {
        
        list.add("A");
        list.add("B");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set("C", 2);
        });
    }

    @DisplayName("test isEmpty work correctly with new List")
    @Test
    public void testIsEmptyReturnTrueOnNewList() {
        
        assertTrue(list.isEmpty());
    }

    @DisplayName("test isEmpty work correctly when List has data")
    @Test
    public void testIsEmptyReturnFalseOnListWithData() {
        
        list.add("A");
        assertFalse(list.isEmpty());
    }

    @DisplayName("test isEmpty return true after clear")
    @Test
    public void testIsEmptyReturnTrueOnListAfterClear() {
        
        list.add("A");
        list.add("B");

        list.clear();

        assertTrue(list.isEmpty());
    }

    @DisplayName("test contains return true when element exist")
    @Test
    public void testContainsReturnTrue() {
        
        list.add("A");
        list.add("B");

        assertTrue(list.contains("A"));
    }

    @DisplayName("test contains return false on non-existent element")
    @Test
    public void testContainsReturnFalse() {
        
        list.add("A");
        list.add("B");

        assertFalse(list.contains("С"));
    }

    @DisplayName("test contains return false on list without data")
    @Test
    public void testContainsReturnFalseOnEmptyList() {

        assertFalse(list.contains("A"));
    }

    @DisplayName("test indexOf return correct index")
    @Test
    public void testIndexOfReturnCorrectIndex() {
        
        list.add("A");
        list.add("B");
        list.add("A");

        Assertions.assertEquals(0,   list.indexOf("A"));
    }

    @DisplayName("test lastIndexOf return correct index")
    @Test
    public void testLastIndexOfReturnCorrectIndex() {
        
        list.add("A");
        list.add("B");
        list.add("A");

        Assertions.assertEquals(-1,   list.lastIndexOf("C"));
    }

    @DisplayName("test to String work correctly ")
    @Test
    public void testToStringWorkCorrectly() {
        
        list.add("A");
        list.add("B");
        list.add("A");

        Assertions.assertEquals("[A,B,A]", list.toString());
    }








}
