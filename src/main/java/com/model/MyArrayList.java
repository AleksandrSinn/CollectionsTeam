package com.model;

import com.service.List;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<T> implements List<T> {
    private static int INIT_CAPACITY = 16;
    private int size;
    private T[] objects;
    private int capacity;

    public MyArrayList() {
        objects = (T[]) new Object[INIT_CAPACITY];
        capacity = INIT_CAPACITY;
        size = 0;
    }

    public MyArrayList(int capacity) {
        objects = (T[]) new Object[capacity];
        this.capacity = capacity;
        size = 0;
    }

    public T[] getObjects() {
        return objects;
    }

    @Override
    public void add(T element) {
        if(size < capacity - 1){
            objects[size] = element;
        }
        else{
            expand(capacity + capacity / 2);
        }
        objects[size] = element;
        size++;
    }

    @Override
    public void add(T element, int index) {
        if (index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size == capacity - 1) {
            expand(size + size / 2);
        }
        System.arraycopy(objects, index, objects, index + 1, size - index);
        this.objects[index] = element;
        size++;
    }

    @Override
    public void set(T element, int index) {
        if(objects[index] != null){
            objects[index] = element;
        }else throw new IndexOutOfBoundsException(String.valueOf(index));
    }

    private void expand(int newLength) {
        capacity = newLength;
        Arrays.copyOf(objects, capacity);
    }

    @Override
    public T get(int index) {
        return objects[index];
    }

    @Override
    public int getIndex(T object) {
        for (int i = 0; i < size; i++) {
            if(objects[i] == object){
                return i;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void delete(int index) {
        if (size - index >= 0) {
            System.arraycopy(objects, index + 1, objects, index, size - index);
            objects[size] = null;
            size--;
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        boolean unsorted = true;
        T temp;
        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < size-1; i++) {
                if (comparator.compare((T) objects[i], (T) objects[i + 1]) > 0) {
                    temp = (T) objects[i];
                    objects[i] = objects[i + 1];
                    objects[i + 1] = temp;
                    unsorted = true;
                }
            }
        }
    }

}
