package com;

import com.model.MyArrayList;
import com.model.Song;
import com.service.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyArrayListTest {
    List<Song> myList;

    @BeforeEach
    void init() {
        myList = new MyArrayList<>();
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
    }

    @Test
    void add() {
        Song song = new Song(1977, "We Are the Champions");
        myList.add(song);
        assertEquals(song, myList.get(5));
        assertEquals(6, myList.size());
    }

    @Test
    void testAdd() {
        Song song = new Song(1975, "Bohemian Rhapsody");
        myList.add(song, 3);
        assertEquals(song, myList.get(3));
        assertEquals(6, myList.size());
    }

    @Test
    void set() {
        Song song = new Song(1977, "We Will Rock You");
        myList.set(song, 3);
        assertEquals(song, myList.get(3));
        assertEquals(5, myList.size());
    }

    @Test
    void get() {
        assertEquals("Nights", myList.get(3).name);
    }

    @Test
    void getIndex() {
        Song song = new Song(1984, "I Want to Break Free");
        myList.add(song, 2);
        assertEquals(2, myList.getIndex(song));
    }

    @Test
    void delete() {
        myList.delete(2);
        assertEquals("Nights in White Satin", myList.get(3).name);
        assertEquals(4, myList.size());
    }

    @Test
    void size() {
        assertEquals(5, myList.size());
    }

    @Test
    void sort() {
        myList.sort(Comparator.comparingInt(Song::getReleaseYear));

        Assertions.assertTrue(myList.get(0).getReleaseYear() < myList.get(1).getReleaseYear());
        Assertions.assertTrue(myList.get(1).getReleaseYear() < myList.get(2).getReleaseYear());
        Assertions.assertTrue(myList.get(2).getReleaseYear() < myList.get(3).getReleaseYear());
        Assertions.assertTrue(myList.get(3).getReleaseYear() < myList.get(4).getReleaseYear());
    }
}