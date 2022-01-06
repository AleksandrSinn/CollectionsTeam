package com;

import com.model.MyArrayList;
import com.model.Song;
import com.service.List;

import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        Song song1 = new Song(111, "Smooth Criminal");
        Song song2 = new Song(222, "In The Air Tonight");
        Song song3 = new Song(333, "Nights in White Satin");
        Song song4 = new Song(444, "Nights ");
        Song song5 = new Song(555, "Satin");

        List<Song> myList = new MyArrayList<>();
        myList.add(song4);
        myList.add(song2);
        myList.add(song5);
        myList.add(song1);
        myList.add(song3);

        for(int i = 0; i < myList.size(); i++){
            System.out.println(myList.get(i));
        }

        System.out.println("======================");


        myList.sort(Comparator.comparingInt(Song::getReleaseYear));

        for(int i = 0; i < myList.size(); i++){
            System.out.println(myList.get(i));
        }

    }
}
