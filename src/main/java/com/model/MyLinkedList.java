package com.model;

import com.service.List;

public class MyLinkedList<T extends Comparable<T>> implements List<T> {

    private int size;
    private Node<T> head;

    private static class Node<T>{
        T item;
        Node<T>next;
        Node<T>prev;

        public Node(T element) {
            this.item = element;
        }
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if(head == null){
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
        }else{
            Node<T>currentNode = head;
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = new Node<>(element); // add elem in tail
        }
        size++;
    }

    @Override
    public void add(T element, int index) {
        if(index < 0 && index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(index == 0){
            add(element);
        }else{
            Node<T> currentNode = head;
            for(int i = 0; i < index; i++){
                currentNode = currentNode.next;
            }
            currentNode = new Node<>(element);
            size++;
        }
    }

    @Override
    public void set(T element, int index) {

    }

    @Override
    public T get(int index) {
        if(index < 0 && index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<T>tmpNode = head;
        for(int i = 0; i < index; i++){
            tmpNode = tmpNode.next;
        }
        return tmpNode.item;
    }

    @Override
    public int getIndex(T object){
        Node<T>tmpNode = head;
        for(int i = 0; i < size; i++){
            if(tmpNode.equals(object)){
                return i;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public void delete(int index) {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sort() {

    }

    public void clear(){
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
