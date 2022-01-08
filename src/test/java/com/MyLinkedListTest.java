package com;

import com.model.MyArrayList;
import com.model.MyLinkedList;
import com.model.Song;
import com.service.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    List<Song> myList;
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
    void addShouldGetLast() {
        myLinkedList.add(1000);
        assertEquals(myLinkedList.get(myLinkedList.size() - 1), 1000);
    }

    @Test
    void addShouldGetToIndex() {
        myLinkedList.add(1111, 1);
        for(int i = 0; i < myLinkedList.size(); i++){
            System.out.println(myLinkedList.get(i));
        }
        assertEquals(myLinkedList.get(1), 1111);
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
        assertEquals(myLinkedList.get(0), 18);
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
        assertEquals(myLinkedList.size(), 7);
    }

    @Test
    void sort() {
        myList = new MyLinkedList<>();
        Song song1 = new Song(111, "Smooth Criminal");
        Song song2 = new Song(222, "In The Air Tonight");
        Song song3 = new Song(333, "Nights in White Satin");
        Song song4 = new Song(444, "Nights");
        Song song5 = new Song(555, "Satin");
        myList.add(song5);
        myList.add(song1);
        myList.add(song2);
        myList.add(song4);
        myList.add(song3);

        myList.sort(Comparator.comparingInt(Song::getReleaseYear));

        Assertions.assertTrue(myList.get(0).getReleaseYear() < myList.get(1).getReleaseYear());
        Assertions.assertTrue(myList.get(1).getReleaseYear() < myList.get(2).getReleaseYear());
        Assertions.assertTrue(myList.get(2).getReleaseYear() < myList.get(3).getReleaseYear());
        Assertions.assertTrue(myList.get(3).getReleaseYear() < myList.get(4).getReleaseYear());
    }

    @Test
    void clear() {
        myLinkedList.clear();
        assertEquals(myLinkedList.size(), 0);
    }

    @Test
    void isEmpty() {
        Assertions.assertTrue(myLinkedList.size() != 0);
        myLinkedList.clear();
        Assertions.assertTrue(myLinkedList.size() == 0);

    }
}