package com.ozzero;

import java.util.Iterator;


public class myList<T> implements Iterable<T> {
    private T value = null;
    private int size = 0;
    private myList<T> next = null;

    // Iterator
    /**
     * {@code myIterator} - собственная реализация {@code Iterator} для #{@link myList}. 
     * 
     * </p> 1. Ссылка на элемент списка {@link #current} 
     * </p> 2. Конструктор по умолчанию {@link #iterator()}
     * </p> 3. Методы с итераторами на начало и конец списка
     */
    public Iterator<T> iterator() {
        return new myIterator<T>(this);
    }
    static class myIterator<T> implements Iterator<T> {
        private myList<T> current;

        public myIterator(myList<T> th) {
            current = th;
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

    // Constructors
    public myList(int n) {
        this.size = n;
        this.next = new myList<T>(n, 1);
    }

    public myList() {
        this.size = 0;
        this.next = null;
    }

    public myList(myList<T> other) { 
        this.value = other.value;
        this.size = other.size;
        this.next = (other.next == null) ? null : new myList<>(other.next);
    }

    private myList(int n, int c) {
        this.size = -1;
        this.next = (c == n - 1) ? null : new myList<T>(n, c + 1);
    }

    // Overrides

    // Private methods
    private myList<T> getNode(int index) {
        if(index < 0) {
            throw new IndexOutOfBoundsException();
        }
        
        myList<T> t = this;
        for(int i = 1; i <= index; i++) {
            t = t.next;

            if(t == null) 
                break;
        }

        return t;
    }

    // Public non-static methods
    public T get(int index) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        
        myList<T> t = this;
        for(int i = 1; i <= index; i++) {
            t = t.next;
        }

        return t.value;
    }
    

    public void set(int index, T obj) {
        myList<T> t = getNode(index);
        t.value = obj;
    }

    /**
     * Вставка в начало
     */
    public void pushFront(T obj) {
        myList<T> node = new myList<>();
        node.value = this.value;        // Почему именно так, я оставлю как копирайт
        node.next = this.next;
        node.size = this.size;

        this.value = obj;
        this.next = node;

        this.size += 1;
    }

    /**
     * Вставка в конец
     */
    public void pushBack(T obj) {
        myList<T> node = new myList<>();
        node.value = obj;
        myList<T> t = getNode(this.size - 1); 

        this.size += 1;
        t.next = node; // Добавление в конец
    }

    /**
     * Возвращает и удаляет последний элемент
     * @return T
     */
    public T popBack() {
        if(this.size == 0) 
            throw new IndexOutOfBoundsException("Size of list equal 0");
        if(this.size > 1) {
            myList<T> t = getNode(this.size - 2);
            T r = t.next.value;
            t.next = null;
            this.size -= 1;
            return r;
        }
        else {
            T r = this.value;
            this.value = null;
            this.size = 0;
            return r;
        }
    }

    /**
     * Возвращает и удаляет первый элемент
     * @return T
     */
    public T popFront() {
        if(this.size == 0) 
            throw new IndexOutOfBoundsException("Size of list equal 0");
        if(this.size > 1) {
            myList<T> scnd = getNode(1);
            T r = this.value;
            this.value = scnd.value;
            this.next = getNode(2);
            this.size -= 1;
            return r;
        }
        else {
            T r = this.value;
            this.value = null;
            this.size = 0;
            return r;
        }
    }

    /**
     * Удаляет первое вхождение и возвращает его индекс, или -1 в случае отсутсвия элемента
     * @param obj
     */
    public int erase(T obj) {
        myList<T> t = this;

        if(this.size <= 1) { // Только 1 элемент
            if(this.value.equals(obj)) {
                this.value = null;
                this.size = 0;
                return 0;
            }
            return -1;
        }

        for(int i = 0; i < this.size; i++) {
            if(t.value.equals(obj)) {
                this.size -= 1;
                myList<T> target = getNode(i);
                myList<T> from = getNode(Math.max(i - 1, 0));
                myList<T> to = getNode(Math.min(i + 1, this.size - 1));

                if(i == 0) {
                    this.value = to.value;
                    target = to;
                    to = getNode(i + 2);
                }

                target.value = null; // Обнуление элемента
                target.next = null;
                
                from.next = to; // Перекидка связи

                return i;
            }

            t = t.next;
        }

        return -1;
    }

    public void clear() {
        myList<T> t = this;
        for(int i = 0; i < this.size; i++) {
            t.value = null; // Отцепляем все объекты
            t = t.next;
        }
        this.next = null; // Отцепляем весь хвост
        this.size = 0;
        System.gc(); // Просим систему собрать мусор (ну пожалуйста 🥺)
    }

    // Getters and Setters
    public int size() {
        return size;
    }
    
}