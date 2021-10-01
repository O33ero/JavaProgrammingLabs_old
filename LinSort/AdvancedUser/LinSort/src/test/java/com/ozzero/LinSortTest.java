package com.ozzero;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LinSortTest {
    @Test
    public void testMSD_1() {
        long[] arr = {100, 404, 512, 521, 613, 124, 333, 800, 222};
        
        LinSort.MSD(arr);

        assertArrayEquals(new long[] {100, 124, 222, 333, 404, 512, 521, 613, 800}, arr);
    }

    @Test
    public void testMSD_2() {
        long[] arr = {100, 404, 512, 521, 613, 124, 333, 800, 222};
        
        LinSort.MSD(arr, 3, 7);

        assertArrayEquals(new long[] {100, 404, 512, 124, 333, 521, 613, 800, 222}, arr);
    }

    @Test
    public void testLSD_1() {
        long[] arr = {100, 404, 512, 521, 613, 124, 333, 800, 222};
        
        LinSort.LSD(arr);

        assertArrayEquals(new long[] {100, 124, 222, 333, 404, 512, 521, 613, 800}, arr);
    }

    @Test
    public void testLSD_2() {
        long[] arr = {100, 404, 512, 521, 61, 124, 333, 8000, 222};
        
        LinSort.LSD(arr, 3, 7);

        assertArrayEquals(new long[] {100, 404, 512, 61, 124, 333, 521, 8000, 222}, arr);
    }

    @Test
    public void testLSD_3() {
        long[] arr = {100, 40, 512, 521, 613, 124, 333, 800, 222};
        
        LinSort.LSD(arr);

        assertArrayEquals(new long[] {40, 100, 124, 222, 333, 512, 521, 613, 800}, arr);
    }

    @Test
    public void testCountingSort_1() {
        long[] arr = {1, 1, 2, 3, 6, 5, 3, 5, 9, 1};
        
        LinSort.CountingSort(arr);

        assertArrayEquals(new long[] {1, 1, 1, 2, 3, 3, 5, 5, 6, 9}, arr);
    }

    @Test
    public void testCountingSort_2() {
        long[] arr = {1, 1, 2, 3, 6, 5, 3, 5, 9, 1};
        
        LinSort.CountingSort(arr, 3, 7);

        assertArrayEquals(new long[] {1, 1, 2, 3, 3, 5, 5, 6, 9, 1}, arr);
    }

    @Test
    public void testCountingSort_3() {
        long[] arr = {1, 1, 2, 3, 6, 5, 3, 5, 9, 1, 11, 2, 4, 7, 11, 10, 9, 1, 2, 3, 4};
        
        LinSort.CountingSort(arr);

        assertArrayEquals(new long[] {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7, 9, 9, 10, 11, 11}, arr);
    }

}
