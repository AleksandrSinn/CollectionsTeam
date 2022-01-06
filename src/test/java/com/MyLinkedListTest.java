package com;

import com.model.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    public static MyLinkedList<Integer> myLinkedList;

    @BeforeEach
    void init() {
        myLinkedList = new MyLinkedList<>();
        myLinkedList.add(18);
        myLinkedList.add(4);
        myLinkedList.add(1);
        myLinkedList.add(80);
        myLinkedList.add(4);
        myLinkedList.add(32);
        myLinkedList.add(80);
    }

    @Test
    void add() {
    }

    @Test
    void testAdd() {
    }

    @Test
    void set() {
        myLinkedList.set(50, 2);
        //System.out.println(myLinkedList);
        assertEquals(50, myLinkedList.get(2));
        assertEquals(7, myLinkedList.size());
    }

    @Test
    void get() {
    }

    @Test
    void getIndex() {
    }

    @Test
    void delete() {
        myLinkedList.delete(3);
        //System.out.println(myLinkedList);
        assertEquals(4, myLinkedList.get(3));
        assertEquals(6, myLinkedList.size());
    }

    @Test
    void size() {
    }

    @Test
    void sort() {
    }

    @Test
    void clear() {
    }

    @Test
    void isEmpty() {
    }
}