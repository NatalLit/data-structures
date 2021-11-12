package com.litvinova.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayListTest {

    @DisplayName("test add value to the end of the list")
    @Test
    public void testAddValueAndChangeSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        Assertions.assertEquals(2, arrayList.size());
    }

    @DisplayName("test add value by index")
    @Test
    public void testAddValueByIndexAndChangeSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C", 1);


       Assertions.assertEquals("B", arrayList.get(2));
        Assertions.assertEquals(3, arrayList.size());

    }

    @DisplayName("test throw exception when add by invalid index ")
    @Test
    public void testThrowIndexOutOfBoundExceptionWhenAddByInvalidIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("C", 3);
        });
    }

    @DisplayName("test remove value by index")
    @Test
    public void testRemoveValueByIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.remove(0);

        Assertions.assertEquals("B", arrayList.get(0));
    }


    @DisplayName("test throw exception when remove by invalid index ")
    @Test
    public void testThrowIndexOutOfBoundExceptionWhenRemoveByInvalidIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(2);
        });
    }

    @DisplayName("test get value by index")
    @Test
    public void testGetValueByIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        Assertions.assertEquals("A", arrayList.get(0));
    }

    @DisplayName("test throw exception when get by invalid index ")
    @Test
    public void testThrowIndexOutOfBoundExceptionWhenGetByInvalidIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(2);
        });
    }

    @DisplayName("test set value by index")
    @Test
    public void testSetValueByIndexWithoutChangeSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.set("C", 1);

        Assertions.assertEquals("C", arrayList.get(1));
    }

    @DisplayName("test throw exception when set by invalid index ")
    @Test
    public void testThrowIndexOutOfBoundExceptionWhenSetByInvalidIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.set("C", 2);
        });
    }

    @DisplayName("test isEmpty work correctly with new List")
    @Test
    public void testIsEmptyReturnTrueOnNewList() {
        ArrayList arrayList = new ArrayList();
        assertTrue(arrayList.isEmpty());
    }

    @DisplayName("test isEmpty work correctly when List has data")
    @Test
    public void testIsEmptyReturnFalseOnListWithData() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        assertFalse(arrayList.isEmpty());
    }

    @DisplayName("test isEmpty return true after clear")
    @Test
    public void testIsEmptyReturnTrueOnListAfterClear() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        arrayList.clear();

        assertTrue(arrayList.isEmpty());
    }

    @DisplayName("test contains return true when element exist")
    @Test
    public void testContainsReturnTrue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        assertTrue(arrayList.contains("A"));
    }

    @DisplayName("test contains return false on non-existent element")
    @Test
    public void testContainsReturnFalse() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");

        assertFalse(arrayList.contains("С"));
    }

    @DisplayName("test contains return false on list without data")
    @Test
    public void testContainsReturnFalseOnEmptyList() {
        ArrayList arrayList = new ArrayList();

        assertFalse(arrayList.contains("A"));
    }

    @DisplayName("test indexOf return correct index")
    @Test
    public void testIndexOfReturnCorrectIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");

        Assertions.assertEquals(0,   arrayList.indexOf("A"));
          }

    @DisplayName("test lastIndexOf return correct index")
    @Test
    public void testLastIndexOfReturnCorrectIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");

        Assertions.assertEquals(-1,   arrayList.lastIndexOf("C"));
    }

    @DisplayName("test to String work correctly ")
    @Test
    public void testToStringWorkCorrectly() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");

        Assertions.assertEquals("[A,B,A]", arrayList.toString());
    }





}






