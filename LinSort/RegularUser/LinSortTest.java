package com.ozzero;

import java.util.Arrays;

public class LinSortTest {
    public static void main(String[] args) {
        int counter = 1;
        try {
            long[] arr = {100, 123, 124, 252, 400, 404, 505, 512, 800, 991, 999};
            LinSort.MSD(arr);
            assert Arrays.equals(new long[] {100, 123, 124, 252, 400, 404, 505, 512, 800, 991, 999}, arr) : "Failed test #" + Integer.toString(counter++);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            long[] arr = {124, 123, 999, 252, 100, 404, 991, 505, 800, 512, 400};
            LinSort.MSD(arr);
            assert Arrays.equals(new long[] {100, 123, 124, 252, 400, 404, 505, 512, 800, 991, 999}, arr) : "Failed test #" + Integer.toString(counter++);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            long[] arr = {124, 123, 999, 252, 100, 404, 991, 505, 800, 512, 400};
            LinSort.MSD(arr, 3, 7);
            assert Arrays.equals(new long[] {124, 123, 999, 100, 252, 404, 505, 991, 800, 512, 400}, arr) : "Failed test #" + Integer.toString(counter++);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }



        try {
            long[] arr = {100, 123, 124, 252, 400, 404, 505, 512, 800, 991, 999};
            LinSort.LSD(arr);
            assert Arrays.equals(new long[] {100, 123, 124, 252, 400, 404, 505, 512, 800, 991, 999}, arr) : "Failed test #" + Integer.toString(counter++);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            long[] arr = {124, 123, 999, 252, 100, 404, 991, 505, 800, 512, 400};
            LinSort.LSD(arr);
            assert Arrays.equals(new long[] {100, 123, 124, 252, 400, 404, 505, 512, 800, 991, 999}, arr) : "Failed test #" + Integer.toString(counter++);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            long[] arr = {124, 123, 999, 252, 100, 404, 991, 505, 800, 512, 400};
            LinSort.LSD(arr, 3, 7);
            assert Arrays.equals(new long[] {124, 123, 999, 100, 252, 404, 505, 991, 800, 512, 400}, arr) : "Failed test #" + Integer.toString(counter++);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }








        try {
            long[] arr = {100, 123, 124, 252, 400, 404, 505, 512, 800, 991, 999};
            LinSort.CountingSort(arr);
            assert Arrays.equals(new long[] {100, 123, 124, 252, 400, 404, 505, 512, 800, 991, 999}, arr) : "Failed test #" + Integer.toString(counter++);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            long[] arr = {124, 123, 999, 252, 100, 404, 991, 505, 800, 512, 400};
            LinSort.CountingSort(arr);
            assert Arrays.equals(new long[] {100, 123, 124, 252, 400, 404, 505, 512, 800, 991, 999}, arr) : "Failed test #" + Integer.toString(counter++);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            long[] arr = {124, 123, 999, 252, 100, 404, 991, 505, 800, 512, 400};
            LinSort.CountingSort(arr, 3, 7);
            assert Arrays.equals(new long[] {124, 123, 999, 100, 252, 404, 505, 991, 800, 512, 400}, arr) : "Failed test #" + Integer.toString(counter++);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
