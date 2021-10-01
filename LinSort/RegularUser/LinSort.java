package com.ozzero;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
/**
 * LinSort - собственна реализация MSD, LSD и сортировки подсчетом
 * I    MSD
 * II   LSD
 * III  CountingSort
 * 
 * 1. Сортировка для целых чисел {@link #MSD(long[])} {@link #LSD(long[])} {@link #CountingSort(long[])}
 * 2. Сортировка для подпоследовательности {@link #MSD(long[], int, int)} {@link #LSD(long[], int, int)} {@link #CountingSort(long[], int, int)}
 * 3. Поддержка чисел разной длины 
 */
public class LinSort {

    private static long getMax(long[] arr) {
        long max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static long getMax(long[] arr, int begin, int end) {
        long max = arr[0];
        for(int i = begin; i <= end; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static int digitAt(long c, int i) {
        long a = (long)(Math.pow(10, i - 1));
        long b = c / a;
        int d = (int)(b % 10);
        return d;
    }

    private static int revertDigitAt(long c, int i) {
        int r = 0;
        while(i > 0) {
            r = (int)c % 10;
            c = c / 10;
            i--;
        }

        return r;
    }


    


    public static void MSD(long[] arr) {
        long m = getMax(arr);
        int d = (int)(Math.log10(m) + 1);

        MSD(arr, 0, arr.length - 1, d);
    }

    public static void MSD(long[] arr, int begin, int end) {
        long m = getMax(arr, begin, end);
        int d = (int)(Math.log10(m) + 1);
        MSD(arr, begin, end, d);
    }

    private static void MSD(long[] arr, int begin, int end, int d) {
        
        if (end <= begin || d < 1) {
            return;
        }
        List<ArrayDeque<Long>> lst = new ArrayList<>();
        
        for(int i = 0; i < 10; i++) {
            lst.add(new ArrayDeque<Long>());
        }

        for(int i = begin; i <= end; i++) {
            int c = digitAt(arr[i], d);
            lst.get(c).add(arr[i]);
        }

        int index = begin;
        for(int i = 0; i < 10; i++) {
            ArrayDeque<Long> dq = lst.get(i);
            long[] temp = new long[dq.size()];

            for(int j = 0; !dq.isEmpty(); j++) {
                temp[j] = dq.remove();
            }

            if(temp.length > 1) {
                MSD(temp, 0, temp.length - 1, d - 1);
            }

            for(long now : temp) {
                arr[index] = now;
                index++;
            }
        }
        
    }


    public static void LSD(long[] arr) {
        long m = getMax(arr);
        int d = (int)(Math.log10(m) + 1);
        for(int i = 1; i <= d; i++)
            LSD(arr, 0, arr.length - 1, i);
    }

    public static void LSD(long[] arr, int begin, int end) {
        long m = getMax(arr, begin, end);
        int d = (int)(Math.log10(m) + 1);

        for(int i = 1; i <= d; i++)
            LSD(arr, begin, end, i);
    }


    private static void LSD(long[] arr, int begin, int end, int d) {

        if (end <= begin || d < 1) {
            return;
        }
        int M = (int)(Math.log10(getMax(arr, begin, end)) + 1);

        List<ArrayList<Long>> lst = new ArrayList<>();
        
        for(int i = 0; i < 10; i++) {
            lst.add(new ArrayList<Long>());
        }

        for(int i = begin; i <= end; i++) {
            int c = revertDigitAt(arr[i], d);
            lst.get(c).add(arr[i]);
        }

        int index = begin;
        for(int i = 0; i < 10; i++) {
            ArrayList<Long> dq = lst.get(i);

            for(int j = 0; j < dq.size(); j++) {
                arr[index] = dq.get(j);
                index++;
            }
        }
        
    }


    public static void CountingSort(long[] arr) {
        CountingSort(arr, 0, arr.length - 1);
    }

    public static void CountingSort(long[] arr, int begin, int end) {
        int max = (int)(getMax(arr, begin, end));

        int[] frq = new int[max + 1];
        long[] sorted = new long[end - begin + 1];


        for(int i = begin; i <= end; i++) {
            frq[(int)arr[i]]++;
        }
        
        for(int i = 1; i < max + 1; i++) {
            frq[i] += frq[i - 1];
        }

        for(int i = begin; i <= end; i++) {
            sorted[frq[(int)arr[i]] - 1 ] = arr[i];
            frq[(int)arr[i]]--;
        }

        System.arraycopy(sorted, 0, arr, begin, end - begin + 1);

    }

    
    
}