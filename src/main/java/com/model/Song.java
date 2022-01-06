package com.model;

public class Song {
    public int releaseYear;
    public String name;

    public Song(int releaseYear, String name) {
        this.releaseYear = releaseYear;
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "com.Song{" +
                "releaseYear=" + releaseYear +
                ", name='" + name +
                '}';
    }
}
