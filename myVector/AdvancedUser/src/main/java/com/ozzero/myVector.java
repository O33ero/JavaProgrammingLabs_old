package com.ozzero;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * {@link #myVector} - собственная реализация {@link ArrayList}
 * </p> 1.   Ссылка на массив ✔️ {@link #arr} 
 * </p> 2.   Максимальное число элементов ✔️ {@link #maxSize}
 * </p> 3.   Текущее число элементов ✔️ {@link #nowSize}
 * </p> 4.   Конструктор с размером ✔️ {@link #myVector(int)}
 * </p> 5.   Конструктор копирования ✔️ {@link #myVector(myVector)}
 * </p> 6.   Добавления элемента в конец ✔️ {@link #pushBack(Object)}
 * </p> 7.   Удаление последнего элемента ✔️ {@link #popBack()}
 * </p> 8.   Вставка элемента по индексу ✔️ {@link #popBack()}
 * </p> 9.   Изменение размера массива ✔️ {@link #newSize(int)}
 * </p> 10.  Отчистка массива ✔️ {@link #clear()}
 * </p> 11.  Получение текущего и максимального размера массива ✔️ {@link #size()} {@link #maxSize()}
 * </p> 12.  Генерировать исключения ✔️
 */

public class myVector<T> {
    private Object[] arr;
    private int maxSize; // Максимальный размер
    private int nowSize; // Сколько сейчас используется

    // Constructors
    myVector(int size) {
        if(size < 0) {
            throw new NegativeArraySizeException("Negative size of array");
        }
        maxSize = (int) (size * 1.5);
        nowSize = 0;
        arr = new Object[maxSize];
    }

    myVector(myVector<T> other) {
        maxSize = other.maxSize;
        nowSize = other.nowSize;
        arr = other.arr.clone();
    }

    // Overrides

    // Private methods
    private void relocateArr() { // Увеличивает размер массива и копирует данные 
        maxSize = (int) (maxSize * 1.5);
        Object[] t = arr.clone();
        arr = new Object[maxSize];
        for(int i = 0; i < t.length; i++) {
            arr[i] = t[i];
        }
    }

    private void relocateArr(int nsize) {
        maxSize = (int) (nsize * 1.5);
        Object[] t = arr.clone();
        arr = new Object[maxSize];
        for(int i = 0; i < Math.min(t.length, nsize); i++) {
            arr[i] = t[i];
        }
    }

    // Public non-static methods
    public void pushBack(T elm) {
        if(nowSize == maxSize)
            relocateArr();
        arr[nowSize] = elm;
        nowSize += 1;
    } 

    @SuppressWarnings("unchecked")
    public T popBack() {
        if(nowSize == 0) {
            throw new NoSuchElementException("No elements in array.");
        }
        Object t = arr[nowSize - 1];
        arr[nowSize - 1] = null;
        nowSize -= 1;
        return (T) t;
    }

    public void insert(int index, T elm) {
        if (index >= nowSize) {
            throw new IndexOutOfBoundsException("Index out of bounds. Index should be less then result of size() function.");
        }
        arr[index] = elm;
    }
    
    public void newSize(int newSize) {
        relocateArr(newSize);
        nowSize = newSize;
    }

    public void clear() {
        for(int i = 0; i < nowSize; i++) {
            arr[i] = null;
        }
        nowSize = 0;
    }
    
    // Getters and Setters
    public int size() {
        return nowSize;
    }

    public int maxSize() {
        return maxSize;
    }


}