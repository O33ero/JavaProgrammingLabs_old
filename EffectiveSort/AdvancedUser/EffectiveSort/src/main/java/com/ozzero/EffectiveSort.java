package com.ozzero;

import java.util.ArrayList;
import java.util.List;


/**
 * EffectiveSort - реализация сортировок быстрой, пирамидальнеой и слиянием
 * </p> I    QuickSort
 * </p> II   HeapSort
 * </p> III  MergeSort
 * 
 * </p> 1. Сортировка для целых чисел {@link #QuickSort(int[])} {@link #HeapSort(int[])} {@link #MergeSort(int[])}
 * </p> 2. Сортировка подпоследовательности {@link #QuickSort(int[], int, int)} {@link #HeapSort(int[], int, int)} {@link #MergeSort(int[], int, int)}
 * </p> 3. Сортировка с любыми типами данных {@link #QuickSort(Comparable[])} {@link #HeapSort(Comparable[])} {@link #MergeSort(Comparable[])}
 * </p> 4. Сортировка контейнера 
 */
public class EffectiveSort {
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t; 
    }

    private static <T> void swap(List<T> lst, int i, int j) {
        T t = lst.get(i);
        lst.set(i, lst.get(j));
        lst.set(j, t);
    }


    public static void QuickSort(int[] arr) {
        QuickSort(arr, 0, arr.length - 1);
    }

    public static void QuickSort(int[] arr, int begin, int end) {

        int c = (end + begin) / 2; // Индекс опорного элемента
        int p = arr[c]; // Опорный элемент
        int i = begin; // Левая граница (отвечает за меньшее)
        int j = end; // Правая граница (отвечает за большее)
        

        while(i <= j) {
            while(arr[i] < p) i++;
            while(arr[j] > p) j--;

            if(i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if(j > begin) 
            QuickSort(arr, begin, c);
        if(i < end)
            QuickSort(arr, c, end);
    }


    public static <T extends Comparable<T>> void QuickSort(T[] arr) {
        QuickSort(arr, 0, arr.length - 1);
    }

    public static <T extends Comparable<T>> void QuickSort(T[] arr, int begin, int end) {

        int c = (end + begin) / 2; // Индекс опорного элемента
        T p = arr[c]; // Опорный элемент
        int i = begin; // Левая граница (отвечает за меньшее)
        int j = end; // Правая граница (отвечает за большее)
        

        while(i <= j) {
            while(arr[i].compareTo(p) < 0) i++;
            while(arr[j].compareTo(p) > 0) j--;

            if(i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if(j > begin) 
            QuickSort(arr, begin, c);
        if(i < end)
            QuickSort(arr, c, end);
    }


    public static void HeapSort(int[] a) {
        HeapSort(a, 0, a.length - 1);
    }


    public static void HeapSort(int arr[], int begin, int end )
    {
        for (int i = (begin + end) / 2 - 1; i >= begin; i--)
            heapify(arr, end + 1, i, begin, end);
 
        for (int i = end; i > begin; i--) {
            swap(arr, i, begin);
            heapify(arr, i, begin, begin, end);
        }
    }
 
    public static void heapify(int arr[], int n, int i, int begin, int end)
    {
        int largest = (i - begin) + begin; // Initialize largest as root
        int l = 2 * (i - begin) + 1 + begin; // left = 2*i + 1
        int r = 2 * (i - begin) + 2 + begin; // right = 2*i + 2
 
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest, begin, end);
        }
    }



    public static <T extends Comparable<T>> void HeapSort(T[] a) {
        HeapSort(a, 0, a.length - 1);
    }


    public static <T extends Comparable<T>> void HeapSort(T[] arr, int begin, int end )
    {
        for (int i = (begin + end) / 2 - 1; i >= begin; i--)
            heapify(arr, end + 1, i, begin, end);
 
        for (int i = end; i >= begin; i--) {
            swap(arr, i, begin);
            heapify(arr, i, begin, begin, end);
        }
    }
 
    public static <T extends Comparable<T>> void heapify(T[] arr, int n, int i, int begin, int end)
    {
        int largest = (i - begin) + begin; 
        int l = 2 * (i - begin) + 1 + begin; 
        int r = 2 * (i - begin) + 2 + begin; 
 
        if (l < n && arr[l].compareTo(arr[largest]) > 0)
            largest = l;
 
        if (r < n && arr[r].compareTo(arr[largest]) > 0)
            largest = r;
 
        if (largest != i) {
            swap(arr, i, largest);

            heapify(arr, n, largest, begin, end);
        }
    }




    public static void MergeSort(int arr[]) {
        MergeSort(arr, 0, arr.length - 1);
    }

    public static void MergeSort(int arr[], int begin, int end) // https://www.geeksforgeeks.org/merge-sort/
    {
        if (begin < end) {
            int m = (begin + end) / 2;
  
            MergeSort(arr, begin, m);
            MergeSort(arr, m + 1, end);
  
            merge(arr, begin, m, end);
        }
    }

    private static void merge(int arr[], int begin, int mid, int end)
    {
        int n1 = mid - begin + 1;
        int n2 = end - mid;
  
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        for (int i = 0; i < n1; ++i)
            L[i] = arr[begin + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];
  
        int i = 0, j = 0;
  
        int k = begin;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }





    public static <T extends Comparable<T>> void MergeSort(T arr[]) {
        MergeSort(arr, 0, arr.length - 1);
    }

    public static <T extends Comparable<T>> void MergeSort(T arr[], int begin, int end) // https://www.geeksforgeeks.org/merge-sort/
    {
        if (begin < end) {
            int m = (begin + end) / 2;
  
            MergeSort(arr, begin, m);
            MergeSort(arr, m + 1, end);
  
            merge(arr, begin, m, end);
        }
    }

    private static <T extends Comparable<T>> void merge(T arr[], int begin, int mid, int end)
    {
        int n1 = mid - begin + 1;
        int n2 = end - mid;
  
        List<T> L = new ArrayList<>(n1);
        List<T> R = new ArrayList<>(n2);
  
        for (int i = 0; i < n1; ++i)
            L.add(arr[begin + i]);
        for (int j = 0; j < n2; ++j)
            R.add(arr[mid + 1 + j]);
  
        int i = 0, j = 0;
  
        int k = begin;
        while (i < n1 && j < n2) {
            if (L.get(i).compareTo(R.get(j)) <= 0) {
                arr[k] = L.get(i);
                i++;
            }
            else {
                arr[k] = R.get(j);
                j++;
            }
            k++;
        }
  
        while (i < n1) {
            arr[k] = L.get(i);
            i++;
            k++;
        }
  
        while (j < n2) {
            arr[k] = R.get(j);
            j++;
            k++;
        }
    }
  
    
  
    
 
}