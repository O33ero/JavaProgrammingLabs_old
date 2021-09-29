package com.ozzero;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class myVectorTest {

    @Test
    public void testPopBack_1() {
        myVector<Integer> arr = new myVector<>(5);
        arr.pushBack(1);
        arr.pushBack(2);
        arr.pushBack(3);
        arr.pushBack(4);
        arr.pushBack(5);

        assertEquals(5, arr.popBack().intValue());
        assertEquals(4, arr.popBack().intValue());
        assertEquals(3, arr.popBack().intValue());
        assertEquals(2, arr.popBack().intValue());
        assertEquals(1, arr.popBack().intValue());
    }

    @Test
    public void testPushBack_1() {
        myVector<Integer> arr = new myVector<>(5);
        arr.pushBack(1);
        arr.pushBack(2);
        arr.pushBack(3);
        arr.pushBack(4);
        arr.pushBack(5);

        assertEquals(5, arr.size());
    }

    @Test
    public void testNewSize_1() {
        myVector<Integer> arr = new myVector<>(5);
        arr.pushBack(1);
        arr.pushBack(2);
        arr.pushBack(3);
        arr.pushBack(4);
        arr.pushBack(5);

        arr.newSize(10);
        assertEquals(10, arr.size());

        arr.newSize(2);
        assertEquals(2, arr.size());
        assertEquals(2, arr.popBack().intValue());
        assertEquals(1, arr.popBack().intValue());
    }

    @Test
    public void testClear_1() {
        myVector<Integer> arr = new myVector<>(5);
        arr.pushBack(1);
        arr.pushBack(2);
        arr.pushBack(3);
        arr.pushBack(4);
        arr.pushBack(5);

        arr.clear();
        assertEquals(0, arr.size());
    }

}
