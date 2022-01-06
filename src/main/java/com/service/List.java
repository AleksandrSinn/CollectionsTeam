package com.service;

import java.util.Comparator;

public interface List<T> {
    void add(T element);
    void add(T element, int index);
    void set(T element, int index);
    T get(int index);
    int getIndex(T object);
    void delete(int index);
    int size();
    void sort(Comparator<? super T> comparator);
}
