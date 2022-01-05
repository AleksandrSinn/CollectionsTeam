package com.model;

public class Song implements Comparable<Song> {
    public int releaseYear;
    public String name;

    public Song(int releaseYear, String name) {
        this.releaseYear = releaseYear;
        this.name = name;
    }

    @Override
    public int compareTo(Song o) {
        return Integer.compare(this.releaseYear, o.releaseYear);
    }

    @Override
    public String toString() {
        return "com.Song{" +
                "releaseYear=" + releaseYear +
                ", name='" + name +
                '}';
    }
}
