package com.service;

public interface List<T> {
    void add(T element);
    void add(T element, int index);
    void set(T element, int index);
    T get(int index);
    int getIndex(T object) throws RuntimeException;
    void delete(int index);
    int size();
    void sort();
}
