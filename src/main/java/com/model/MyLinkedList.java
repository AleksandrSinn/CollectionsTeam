package com.model;

import com.service.List;

import java.util.Comparator;

public class MyLinkedList<T> implements List<T> {

    private int size;

    // головной узел листа
    private Node<T> head;

    // конечный узел листа
    private Node<T> endNode;

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
            endNode = currentNode.next;
            endNode.prev = currentNode;
        }
        size++;
    }

    @Override
    public void add(T element, int index) {
        if(index < 0 && index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<T>newNode = new Node<>(element);
        if(index == 0){
            add(element);
        }if(index == size){
            endNode.next = newNode;
            endNode = newNode;
        }
        else{
            Node<T> oldNode = head;

            for(int i = 0; i < index; i++){
                oldNode = oldNode.next;
            }

            Node<T> oldPrev = oldNode.prev;
            oldPrev.next = newNode;
            oldNode.prev = newNode;

            newNode.prev = oldPrev;
            newNode.next = oldNode;

            size++;
        }
    }

    @Override
    public void set(T element, int index) throws IndexOutOfBoundsException {
        if (index < 0 && index > size) throw new IndexOutOfBoundsException(String.valueOf(index));
        Node<T> nodeByIndex = searchNodeByIndex(index);
        nodeByIndex.item = element;
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

    @Deprecated
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
    public void delete(int index) throws IndexOutOfBoundsException {
        if (index < 0 && index > size) throw new IndexOutOfBoundsException(String.valueOf(index));
        Node<T> deletedNode = searchNodeByIndex(index);
        Node<T> prevDeletedNode = deletedNode.prev;
        Node<T> nextDeletedNode = deletedNode.next;

        if (prevDeletedNode == null) {
            head = nextDeletedNode;
        } else {
            prevDeletedNode.next = nextDeletedNode;
        }
        if (nextDeletedNode == null) {
            endNode = prevDeletedNode;
        } else {
            nextDeletedNode.prev = prevDeletedNode;
        }
        deletedNode.prev = null;
        deletedNode.next = null;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sort(Comparator<? super T> c) {
        boolean unsorted = true;
        T temp;
        while (unsorted) {
            unsorted = false;
            for (Node<T> x = head; x.next != null; x = x.next) {
                if (c.compare(x.item, x.next.item) > 0) {
                    temp = x.item;
                    x.item = x.next.item;
                    x.next.item = temp;
                    unsorted = true;
                }
            }
        }
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Метод ищет узел Node по указанному индексу
     * @param index - индекс искомого узла
     * @return - узел Node
     */
    private Node<T> searchNodeByIndex(int index) {
        if (index < (size >> 1)) {
            Node<T> x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = endNode;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<T> x = head;
        result.append(x.item.toString());
        result.append("\n");
        for (int i = 0; i < size-1; i++) {
            x = x.next;
            result.append(x.item.toString());
            result.append("\n");
        }
        return result.toString();
    }
}
