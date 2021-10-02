package com.ozzero;

import java.util.Iterator;



public class myList<T> implements Iterable<T> {
    private int size = 0;
    private ListNode<T> first = null;
    private ListNode<T> last = null;

    // Iterator
    /**
     * {@code myIterator} - собственная реализация {@code Iterator} для #{@link myList}. 
     * 
     * </p> 1. Ссылка на элемент списка {@link #current} 
     * </p> 2. Конструктор по умолчанию {@link #iterator()}
     * </p> 3. Методы с итераторами на начало и конец списка 🚑🚑🚑
     */
    public Iterator<T> iterator() {
        return new myIterator<T>(this);
    }
    static class myIterator<T> implements Iterator<T> {
        private ListNode<T> current;

        public myIterator(myList<T> th) {
            current = th.first;
        }
        
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;

            return value;
        }
    }

    static class ListNode<T> {
        private T value = null;
        private ListNode<T> next = null;
    
        ListNode() {
            value = null;
            next = null;
        }
    
        ListNode(T obj) {
            value = obj;
        }
    
        ListNode(ListNode<T> ln) {
            this.value = ln.value;

            ListNode<T> iter = ln.next;
            
            ListNode<T> temp = this;


            while(iter != null) {
                temp.next = new ListNode<T>(iter.value);
                temp = temp.next;
                iter = iter.next;
            }
        }
    
        ListNode(int n) { // Создает последовательность из n узлов
            ListNode<T> temp = this;
    
            for(int i = 0; i < n - 1; i++) {
                temp.next = new ListNode<T>();
                temp = temp.next;
            }
        }
    }

    // Constructors
    public myList(int n) {
        this.size = n;
        this.first = new ListNode<T>(n);
        this.last = getNode(size - 1);
    }

    public myList() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    public myList(myList<T> other) { 
        this.size = other.size;
        this.first = new ListNode<T>(other.first);
        this.last = getNode(size - 1);
    }

    // Overrides

    // Private methods
    private ListNode<T> getNode(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        
        ListNode<T> temp = this.first;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }


    // Public non-static methods
    public T get(int index) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        
        ListNode<T> temp = this.first;
        for(int i = 1; i <= index; i++) {
            temp = temp.next;
        }

        return temp.value;
    }
    

    public void set(int index, T obj) {
        ListNode<T> temp = getNode(index);
        temp.value = obj;
    }

    /**
     * Вставка в начало
     */
    public void pushFront(T obj) {
        ListNode<T> node = new ListNode<>(obj);
        node.next = this.first;
        this.first = node;
        size++;
    }

    /**
     * Вставка в конец
     */
    public void pushBack(T obj) {
        ListNode<T> node = new ListNode<>(obj);
        this.last.next = node;
        this.last = node;
        size++;
    }

    /**
     * Возвращает и удаляет последний элемент
     * @return T
     */
    public T popBack() {
        if(this.size == 0) 
            throw new IndexOutOfBoundsException("Size of list equal 0");

        if(size > 1) {
            ListNode<T> node = this.last;
            this.last = getNode(size - 2);
            this.last.next = null;

            size--;
            return node.value;
        }
        else {
            ListNode<T> node = this.last;
            this.last = null;
            this.first = null;
            size--;

            return node.value;
        }
    }

    /**
     * Возвращает и удаляет первый элемент
     * @return T
     */
    public T popFront() {
        if(this.size == 0) 
            throw new IndexOutOfBoundsException("Size of list equal 0");

        if(size > 1) {
            ListNode<T> node = this.first;
            this.first = getNode(1);
            
            size--;
            return node.value;
        }
        else {
            ListNode<T> node = this.first;
            this.first = null;
            this.last = null;
            size--;

            return node.value;
        }
    }

    /**
     * Удаляет первое вхождение и возвращает его индекс, или -1 в случае отсутсвия элемента
     * @param obj
     */
    public int erase(T obj) {
        ListNode<T> prevNode = null;
        ListNode<T> nowNode = this.first;

        for(int i = 0; i < size; i++) {
            if(nowNode.value.equals(obj)) {
                if(prevNode != null)
                    prevNode.next = nowNode.next;
                size--;

                if(i == 0) {
                    this.first = nowNode.next;
                }

                if(i == size) {
                    this.last = getNode(size - 1);
                }

                return i;
            }
            else {
                prevNode = nowNode;
                nowNode = nowNode.next;
            }
        }

        return -1;
    }

    public void clear() {
        size = 0;
        this.first = null;
        this.last = null;
        System.gc(); // Просим систему собрать мусор (ну пожалуйста 🥺)
    }

    // Getters and Setters
    public int size() {
        return size;
    }
    
}