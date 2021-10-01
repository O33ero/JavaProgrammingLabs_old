package com.ozzero;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

public class myListTest {
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
