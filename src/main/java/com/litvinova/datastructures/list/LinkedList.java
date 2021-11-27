package com.litvinova.datastructures.list;

import java.util.StringJoiner;

public class LinkedList implements List {
    Node head;
    Node tail;
    int size;


    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        Node newNode = new Node(value);
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("invalid index");
        } else if (size == 0) {//
            head = tail = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else if (index == 0) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            Node current = getNode(index);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev = newNode;

        }
        size++;
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);
        Node removedNode;
        if (size == 1) {
            removedNode = head;
            head = tail = null;

        } else if (index == 0) {
            removedNode = head;
            head = head.next;
            head.prev = null;

        } else if (index == size - 1) {
            removedNode = tail;
            tail = tail.prev;
            tail.next = null;

        } else {
            removedNode = getNode(index);
            Node beforeRemovedNode = getNode(index - 1);
            Node afterRemovedNode = getNode(index + 1);
            beforeRemovedNode.next = removedNode.next;
            afterRemovedNode.prev = removedNode.prev;
        }

        size--;
        return removedNode;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return getNode(index).value;
    }

    @Override
    public Object set(Object value, int index) {
        checkIndex(index);
        Node oldValue = getNode(index);
        Node newNode = new Node(value);
        if (index == 0) {
            head = newNode;
            newNode.next = oldValue.next;
            getNode(index + 1).prev = newNode;

        }
        if (index == size - 1) {
            tail = newNode;
            newNode.prev = oldValue.prev;
            getNode(index - 1).next = newNode;

        }
        if (index < size - 1) {
            newNode.next = oldValue.next;
            newNode.prev = oldValue.prev;
            getNode(index + 1).prev = newNode;
            getNode(index - 1).next = newNode;

        }
        return oldValue;
    }

    @Override
    public void clear() {
        Node current = head;
        for (int i = 0; i < size - 1; i++) {
            current.value = null;
            current = current.next;
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
        Node current = head;
        for (int i = 0; i < size - 1; i++) {
            if (current == null) {
                throw new NullPointerException();
            }
            if (value.equals(current.value)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node current = tail;
        for (int i = size - 1; i > 0; i--) {
            if (current == null) {
                throw new NullPointerException();
            }
            if (value.equals(current.value)) {
                return i;
            }
            current = current.prev;
        }
        return -1;
    }


    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        Node current = head;
        for (int i = 0; i < size; i++) {
            stringJoiner.add(current.value.toString());
            current = current.next;
        }
        return stringJoiner.toString();

    }

    private Node getNode(int index) {
        checkIndex(index);
        Node current = null;
        if (index == 0) {
            current = head;
        } else if (index < size && index <= size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

        } else if (index < size && index > size / 2) {
            current = tail;
            for (int i = size - 1; i > index + 1; i--) {
                current = current.prev;
            }

        }
        return current;
    }


    private void checkIndex(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("invalid index");
        }
    }


    public class Node {
        Node next;
        Node prev;
        Object value;

        public Node(Object value) {
            this.value = value;
        }
    }
}