package com.ozzero;

import java.security.InvalidAlgorithmParameterException;
import java.util.List;

/**
 * {@link #SimpleSort} - реализация сортировок пузырек, вставкой и выбором 
 * I.   BubbleSort
 * II.  InsertionSort
 * III. SelectionSort
 * 
 * </p> 1. Сортировка для целых чисел {@link #BubbleSort(int[])} {@link #SelectionSort(int[])} {@link #InsertionSort(int[])}  
 * </p> 2. Сортировка подпоследовательности {@link #BubbleSort(int[], int, int)} {@link #SelectionSort(int[], int, int)} {@link #InsertionSort(int[])}  
 * </p> 3. Сортировка с любыми типами данных {@link #BubbleSort(Comparable[])} {@link #SelectionSort(Comparable[])} {@link #InsertionSort(Comparable[])}  
 * </p> 4. Сортировка контейнера  {@link #BubbleSort(List)} {@link #SelectionSort(List)} {@link #InsertionSort(List)}  
 */
public class SimpleSort {

    public static void BubbleSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void BubbleSort(T[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - 1; j++) {
                if(arr[j].compareTo(arr[j + 1])  > 0) {
                    T t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    public static void BubbleSort(int[] arr, int begin, int end) throws InvalidAlgorithmParameterException {
        if(begin < 0 || begin > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        if(end < 0 || begin > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        if(begin > end) {
            throw new InvalidAlgorithmParameterException("Index \"Begin\" should be less then index \"End\"");
        }
        for(int i = begin; i < end; i++) {
            for(int j = begin; j < end - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void BubbleSort(T[] arr, int begin, int end) throws InvalidAlgorithmParameterException {
        if(begin < 0 || begin > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        if(end < 0 || begin > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        if(begin > end) {
            throw new InvalidAlgorithmParameterException("Index \"Begin\" should be less then index \"End\"");
        }

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - 1; j++) {
                if(arr[j].compareTo(arr[j + 1])  > 0) {
                    T t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    public static <T extends Comparable<? super T>> void BubbleSort(List<T> list) {
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.size() - 1; j++) {
                if(list.get(j).compareTo(list.get(j + 1))  > 0) {
                    T t = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, t);
                }
            }
        }
    }

    public static void InsertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int j = i;
            while(arr[j] < arr[Math.max(0, j - 1)] && j > 0) {
                int t = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = t;
                j--;
            }
        }
    }

    public static <T extends Comparable<T>>void InsertionSort(T[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int j = i;
            while(arr[j].compareTo(arr[Math.max(0, j - 1)]) < 0 && j > 0) {
                T t = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = t;
                j--;
            }
        }
    }


    public static void InsertionSort(int[] arr, int begin, int end) throws InvalidAlgorithmParameterException {
        if(begin < 0 || begin > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        if(end < 0 || begin > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        if(begin > end) {
            throw new InvalidAlgorithmParameterException("Index \"Begin\" should be less then index \"End\"");
        }

        for(int i = 1; i < arr.length; i++) {
            int j = i;
            while(arr[j] < arr[Math.max(0, j - 1)] && j > 0) {
                int t = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = t;
                j--;
            }
        }
    }

    public static <T extends Comparable<T>> void InsertionSort(T[] arr, int begin, int end) throws InvalidAlgorithmParameterException {
        if(begin < 0 || begin > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        if(end < 0 || begin > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        if(begin > end) {
            throw new InvalidAlgorithmParameterException("Index \"Begin\" should be less then index \"End\"");
        }

        for(int i = 1; i < arr.length; i++) {
            int j = i;
            while(arr[j].compareTo(arr[Math.max(0, j - 1)]) < 0 && j > 0) {
                T t = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = t;
                j--;
            }
        }
    }

    public static <T extends Comparable<? super T>> void InsertionSort(List<T> list) {
        for(int i = 1; i < list.size(); i++) {
            int j = i;
            while(list.get(j).compareTo(list.get(Math.max(0, j - 1))) < 0 && j > 0) {
                T t = list.get(j);
                list.set(j, list.get(j - 1));
                list.set(j - 1, t);
                j--;
            }
        }
    }
    



    public static void SelectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int min_index = i;
            int min_value = arr[i];
            for(int j = i; j < arr.length; j++) {
                if(arr[j] < min_value) {
                    min_index = j;
                    min_value = arr[j];
                } 
            }
            int t = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = t;
        }
    }

    public static <T extends Comparable<T>> void SelectionSort(T[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int min_index = i;
            T min_value = arr[i];
            for(int j = i; j < arr.length; j++) {
                if(arr[j].compareTo(min_value) < 0) {
                    min_index = j;
                    min_value = arr[j];
                } 
            }
            T t = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = t;
        }
    }

    public static void SelectionSort(int[] arr, int begin, int end) throws InvalidAlgorithmParameterException {
        if(begin < 0 || begin > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        if(end < 0 || begin > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        if(begin > end) {
            throw new InvalidAlgorithmParameterException("Index \"Begin\" should be less then index \"End\"");
        }

        for(int i = begin; i < end; i++) {
            int min_index = i;
            int min_value = arr[i];
            for(int j = i; j < end; j++) {
                if(arr[j] < min_value) {
                    min_index = j;
                    min_value = arr[j];
                } 
            }
            int t = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = t;
        }
    }

    public static <T extends Comparable<T>> void SelectionSort(T[] arr, int begin, int end) throws InvalidAlgorithmParameterException {
        if(begin < 0 || begin > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        if(end < 0 || begin > arr.length) {
            throw new IndexOutOfBoundsException();
        }
        if(begin > end) {
            throw new InvalidAlgorithmParameterException("Index \"Begin\" should be less then index \"End\"");
        }
        
        for(int i = begin; i < end; i++) {
            int min_index = i;
            T min_value = arr[i];
            for(int j = i; j < end; j++) {
                if(arr[j].compareTo(min_value) < 0) {
                    min_index = j;
                    min_value = arr[j];
                } 
            }
            T t = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = t;
        }
    }

    public static <T extends Comparable<? super T>> void SelectionSort(List<T> list) {
        for(int i = 0; i < list.size(); i++) {
            int min_index = i;
            T min_value = list.get(i);
            for(int j = i; j < list.size(); j++) {
                if(list.get(j).compareTo(min_value) < 0) {
                    min_index = j;
                    min_value = list.get(j);
                } 
            }
            T t = list.get(min_index);
            list.set(min_index, list.get(i));
            list.set(i, t);
        }
    }

    
    
}