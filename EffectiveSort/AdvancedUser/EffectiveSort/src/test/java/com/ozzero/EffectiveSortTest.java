package com.ozzero;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class EffectiveSortTest {
    @Test
    public void testQuickSort_1() {
        int[] arr = {5, 4, 2, 1, 3};
        EffectiveSort.QuickSort(arr);

        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testQuickSort_2() {
        int[] arr = {5, 4, 2, 1, 3};
        EffectiveSort.QuickSort(arr, 1, 3);

        assertArrayEquals(new int[] {5, 1, 2, 4, 3}, arr);
    }

    @Test
    public void testQuickSort_3() {
        String[] arr = {"abc", "abb", "aba", "acc", "baa"};
        EffectiveSort.QuickSort(arr);

        assertArrayEquals(new String[] {"aba", "abb", "abc", "acc", "baa"}, arr);
    }

    @Test
    public void testQuickSort_4() {
        String[] arr = {"abc", "abb", "aba", "acc", "baa"};
        EffectiveSort.QuickSort(arr, 1, 3);

        assertArrayEquals(new String[] {"abc", "aba", "abb", "acc", "baa"}, arr);
    }

    @Test
    public void testHeapSort_1() {
        int[] arr = {2, 1, 0, 3, 4};
        EffectiveSort.HeapSort(arr);

        assertArrayEquals(new int[] {0, 1, 2, 3, 4}, arr);
    }

    @Test
    public void testHeapSort_2() {
        int[] arr = {2, 1, 0, 3, 4};
        EffectiveSort.HeapSort(arr, 1, 3);

        assertArrayEquals(new int[] {2, 0, 1, 3, 4}, arr);
    }

    @Test
    public void testHeapSort_3() {
        String[] arr = {"abc", "abb", "aba", "acc", "baa"};
        EffectiveSort.HeapSort(arr);

        assertArrayEquals(new String[] {"aba", "abb", "abc", "acc", "baa"}, arr);
    }

    @Test
    public void testHeapSort_4() {
        String[] arr = {"abc", "abb", "aba", "acc", "baa"};
        EffectiveSort.HeapSort(arr, 1, 3);

        assertArrayEquals(new String[] {"abc", "aba", "abb", "acc", "baa"}, arr);
    }

    @Test
    public void testMergeSort_1() {
        int[] arr = {3, 4, 8, 6, 2, 1, 5, 7};

        EffectiveSort.MergeSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, arr);
    }


    @Test
    public void testMergeSort_2() {
        int[] arr = {2, 1, 0, 3, 4};
        EffectiveSort.MergeSort(arr, 1, 3);

        assertArrayEquals(new int[] {2, 0, 1, 3, 4}, arr);
    }

    @Test
    public void testMergeSort_3() {
        String[] arr = {"abc", "abb", "aba", "acc", "baa"};
        EffectiveSort.MergeSort(arr);

        assertArrayEquals(new String[] {"aba", "abb", "abc", "acc", "baa"}, arr);
    }

    @Test
    public void testMergeSort_4() {
        String[] arr = {"abc", "abb", "aba", "acc", "baa"};
        EffectiveSort.MergeSort(arr, 1, 3);

        assertArrayEquals(new String[] {"abc", "aba", "abb", "acc", "baa"}, arr);
    }
}
