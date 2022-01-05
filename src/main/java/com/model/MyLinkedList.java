package com.model;

import com.service.List;

public class MyLinkedList<T extends Comparable<T>> implements List<T> {

    private int size;
    private Node<T> next;
    private Node<T> prev;

    private static class Node<T>{
        T item;
        Node<T>next;
        Node<T>prev;

        public Node(Node<T> prev, T item, Node<T> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void add(T element) {

    }

    @Override
    public void add(T element, int index) {

    }

    @Override
    public void set(T element, int index) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int getIndex(T object) throws RuntimeException {
        return 0;
    }

    @Override
    public void delete(int index) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void sort() {

    }
    public void ArrSort(){

    }
}
