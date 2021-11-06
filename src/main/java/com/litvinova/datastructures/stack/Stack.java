package com.litvinova.datastructures.stack;

public interface Stack {
    void push (Object value);

    Object pop ();

    //возращает значение, но не достает его из стека
    Object peek();

    boolean contains (Object value);

    int size();

    boolean isEmpty();

    void clear();


}
