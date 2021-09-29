package com.ozzero;

import static org.junit.Assert.assertArrayEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class SimpleSortTest {

    @Test
    public void testBubbleSort_1() {
        int[] arr = {1, 5, 3, 2, 4};
        SimpleSort.BubbleSort(arr);   

        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testBubbleSort_2() {
        Integer[] arr = {1, 5, 3, 2, 4};
        SimpleSort.BubbleSort(arr);   

        assertArrayEquals(new Integer[] {1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testBubbleSort_3() {
        Character[] arr = {'a', 'c', 'b', 'f', 'e'};
        SimpleSort.BubbleSort(arr);   

        assertArrayEquals(new Character[] {'a', 'b', 'c', 'e', 'f'}, arr);
    }

    @Test
    public void testBubbleSort_4() {
        String[] arr = {"abb", "aba", "abc", "baa", "acc"};
        SimpleSort.BubbleSort(arr);   

        assertArrayEquals(new String[] {"aba", "abb", "abc", "acc", "baa"}, arr);
    }

    @Test
    public void testBubbleSort_5() {

        List<String> lst = new LinkedList<>();
        lst.add("abb");
        lst.add("aba");
        lst.add("abc");
        lst.add("baa");
        lst.add("acc");
        SimpleSort.BubbleSort(lst);
        assertArrayEquals(new Object[] {"aba", "abb", "abc", "acc", "baa"}, lst.toArray());
    }


    @Test
    public void testSelectionSort_1() {
        int[] arr = {1, 5, 3, 2, 4};
        SimpleSort.SelectionSort(arr);   

        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testSelectionSort_2() {
        Integer[] arr = {1, 5, 3, 2, 4};
        SimpleSort.SelectionSort(arr);   

        assertArrayEquals(new Integer[] {1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testSelectionSort_3() {
        Character[] arr = {'a', 'c', 'b', 'f', 'e'};
        SimpleSort.SelectionSort(arr);   

        assertArrayEquals(new Character[] {'a', 'b', 'c', 'e', 'f'}, arr);
    }

    @Test
    public void tesSelectionSort_4() {
        String[] arr = {"abb", "aba", "abc", "baa", "acc"};
        SimpleSort.SelectionSort(arr);   

        assertArrayEquals(new String[] {"aba", "abb", "abc", "acc", "baa"}, arr);
    }

    @Test
    public void testSelectionSort_5() {

        List<String> lst = new LinkedList<>();
        lst.add("abb");
        lst.add("aba");
        lst.add("abc");
        lst.add("baa");
        lst.add("acc");
        SimpleSort.SelectionSort(lst);
        assertArrayEquals(new Object[] {"aba", "abb", "abc", "acc", "baa"}, lst.toArray());
    }

    @Test
    public void testInsertionSort_1() {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        SimpleSort.InsertionSort(arr);   

        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, arr);
    }

    @Test
    public void testInsertionSort_2() {
        Integer[] arr = {1, 5, 3, 2, 4};
        SimpleSort.SelectionSort(arr);   

        assertArrayEquals(new Integer[] {1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testInsertionSort_3() {
        Character[] arr = {'a', 'c', 'b', 'f', 'e'};
        SimpleSort.SelectionSort(arr);   

        assertArrayEquals(new Character[] {'a', 'b', 'c', 'e', 'f'}, arr);
    }

    @Test
    public void testInsertionSort_4() {
        String[] arr = {"abb", "aba", "abc", "baa", "acc"};
        SimpleSort.SelectionSort(arr);   

        assertArrayEquals(new String[] {"aba", "abb", "abc", "acc", "baa"}, arr);
    }

    @Test
    public void testInsertionSort_5() {

        List<String> lst = new LinkedList<>();
        lst.add("abb");
        lst.add("aba");
        lst.add("abc");
        lst.add("baa");
        lst.add("acc");
        SimpleSort.SelectionSort(lst);
        assertArrayEquals(new Object[] {"aba", "abb", "abc", "acc", "baa"}, lst.toArray());
    }

}
