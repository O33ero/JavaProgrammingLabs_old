package com.ozzero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

public class myListTest {
    
    @Test
    public void testGet_1() {
        myList<Integer> lst = new myList<>(5);
        lst.set(0, 1);
        lst.set(1, 2);
        lst.set(2, 3);
        lst.set(3, 4);
        lst.set(4, 5);

        assertEquals(1, lst.get(0).intValue());
        assertEquals(2, lst.get(1).intValue());
        assertEquals(3, lst.get(2).intValue());
        assertEquals(4, lst.get(3).intValue());
        assertEquals(5, lst.get(4).intValue());
    }

    @Test
    public void testSet_1() {
        myList<Integer> lst = new myList<>(5);
        lst.set(0, 1);
        lst.set(1, 2);
        lst.set(2, 3);
        lst.set(3, 4);
        lst.set(4, 5);
    }

    @Test
    public void testMyList_1() {
        myList<Integer> lst = new myList<>(5);
        lst.set(0, 1);
        lst.set(1, 2);
        lst.set(2, 3);
        lst.set(3, 4);
        lst.set(4, 5);

        myList<Integer> other = new myList<>(lst);
        assertEquals(1, other.get(0).intValue());
        assertEquals(2, other.get(1).intValue());
        assertEquals(3, other.get(2).intValue());
        assertEquals(4, other.get(3).intValue());
        assertEquals(5, other.get(4).intValue());
    }

    @Test
    public void testPushFront_1() {
        myList<Integer> lst = new myList<>(5);
        lst.set(0, 1);
        lst.set(1, 2);
        lst.set(2, 3);
        lst.set(3, 4);
        lst.set(4, 5);
        assertEquals(1, lst.get(0).intValue());
        assertEquals(2, lst.get(1).intValue());
        assertEquals(3, lst.get(2).intValue());

        lst.pushFront(0);
        assertEquals(0, lst.get(0).intValue());
        assertEquals(1, lst.get(1).intValue());
        assertEquals(2, lst.get(2).intValue());
    }

    @Test
    public void testPushBack_1() {
        myList<Integer> lst = new myList<>(5);
        lst.set(0, 1);
        lst.set(1, 2);
        lst.set(2, 3);
        lst.set(3, 4);
        lst.set(4, 5);
        assertEquals(1, lst.get(0).intValue());
        assertEquals(2, lst.get(1).intValue());
        assertEquals(3, lst.get(2).intValue());

        lst.pushBack(6);
        assertEquals(4, lst.get(3).intValue());
        assertEquals(5, lst.get(4).intValue());
        assertEquals(6, lst.get(5).intValue());
    }

    @Test
    public void testPopFront_1() {
        myList<Integer> lst = new myList<>(5);
        lst.set(0, 1);
        lst.set(1, 2);
        lst.set(2, 3);
        lst.set(3, 4);
        lst.set(4, 5);
        assertEquals(1, lst.get(0).intValue());
        assertEquals(2, lst.get(1).intValue());
        assertEquals(3, lst.get(2).intValue());

        Integer t = lst.popFront();
        assertEquals(1, t.intValue());
        assertEquals(4, lst.size());

        t = lst.popFront();
        assertEquals(2, t.intValue());
        assertEquals(3, lst.size());

        t = lst.popFront();
        assertEquals(3, t.intValue());
        assertEquals(2, lst.size());
    }

    @Test
    public void testPopBack_1() {
        myList<Integer> lst = new myList<>(5);
        lst.set(0, 1);
        lst.set(1, 2);
        lst.set(2, 3);
        lst.set(3, 4);
        lst.set(4, 5);
        assertEquals(1, lst.get(0).intValue());
        assertEquals(2, lst.get(1).intValue());
        assertEquals(3, lst.get(2).intValue());

        Integer t = lst.popBack();
        assertEquals(5, t.intValue());
        assertEquals(4, lst.size());

        t = lst.popBack();
        assertEquals(4, t.intValue());
        assertEquals(3, lst.size());

        t = lst.popBack();
        assertEquals(3, t.intValue());
        assertEquals(2, lst.size());
    }

    @Test
    public void testErase_1() {
        myList<Integer> lst = new myList<>(5);
        lst.set(0, 1);
        lst.set(1, 2);
        lst.set(2, 3);
        lst.set(3, 4);
        lst.set(4, 5);
        assertEquals(1, lst.get(0).intValue());
        assertEquals(2, lst.get(1).intValue());
        assertEquals(3, lst.get(2).intValue());

        int t = lst.erase(2);
        assertEquals(1, t);
        assertEquals(4, lst.size());

        t = lst.erase(5);
        assertEquals(3, t);
        assertEquals(3, lst.size());

        t = lst.erase(2);
        assertEquals(-1, t);
        assertEquals(3, lst.size());
    }

    @Test
    public void testErase_2() {
        myList<Integer> lst = new myList<>(5);
        lst.set(0, 1);
        lst.set(1, 2);
        lst.set(2, 3);
        lst.set(3, 4);
        lst.set(4, 5);

        int t = lst.erase(1);
        assertEquals(0, t);
        assertEquals(4, lst.size());

        t = lst.erase(5);
        assertEquals(3, t);
        assertEquals(3, lst.size());

        t = lst.erase(2);
        assertEquals(0, t);
        assertEquals(2, lst.size());
    }

    @Test
    public void testClear_1() {
        myList<Integer> lst = new myList<>(5);
        lst.set(0, 1);
        lst.set(1, 2);
        lst.set(2, 3);
        lst.set(3, 4);
        lst.set(4, 5);

        lst.clear();
        assertEquals(0, lst.size());

    }

    @Test
    public void testIterator_1() {
        myList<Integer> lst = new myList<>(5);
        lst.set(0, 1);
        lst.set(1, 2);
        lst.set(2, 3);
        lst.set(3, 4);
        lst.set(4, 5);

        Iterator<Integer> iter = lst.iterator();

        Integer a = iter.next(); // 1
        assertTrue(a.equals(1)); 

        Integer b = iter.next(); // 2
        b = iter.next(); // 3
        b = iter.next(); // 4
        assertTrue(b.equals(4));

        b = iter.next(); // 5

        assertFalse(iter.hasNext());
    }


    @Test
    public void testIterator_2() {
        myList<Integer> lst = new myList<>(5);
        lst.set(0, 1);
        lst.set(1, 2);
        lst.set(2, 3);
        lst.set(3, 4);
        lst.set(4, 5);

        int i = 0;
        for(Integer now : lst) {
            assertTrue(now.equals(lst.get(i)));
            i++;
        }
    }
}
