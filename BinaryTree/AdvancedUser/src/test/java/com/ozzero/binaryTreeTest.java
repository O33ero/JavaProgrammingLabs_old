package com.ozzero;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class binaryTreeTest {

    @Test 
    public void testGetLevel_1() {
        binaryTree<Integer> b = new binaryTree<>();

        b.insert(15);
        b.insert(7);
        b.insert(3);
        b.insert(14);
        b.insert(8);
        b.insert(4);
        b.insert(9);
        b.insert(11);

        assertEquals(5, b.getMaxLevel());
    }

    @Test
    public void testInsert_1() {
        binaryTree<Integer> b = new binaryTree<>();
        b.insert(5);
        b.insert(6);
        b.insert(3);
        b.insert(1);
        b.insert(0);
        b.insert(4);
        b.insert(8);

        assertEquals(7, b.size());
    }

    @Test
    public void testBinaryTree_1() {
        binaryTree<Integer> b = new binaryTree<>();
        b.insert(5);
        b.insert(6);
        b.insert(3);
        b.insert(1);
        b.insert(0);
        b.insert(4);
        b.insert(8);

        binaryTree<Integer> c = new binaryTree<>(b);
        assertEquals(7, c.size());
    }

    @Test
    public void testContain_1() {
        binaryTree<Integer> b = new binaryTree<>();
        b.insert(5);
        b.insert(6);
        b.insert(3);
        b.insert(1);
        b.insert(0);
        b.insert(4);
        b.insert(8);

        assertEquals(true, b.contain(6));
        assertEquals(true, b.contain(0));
        assertEquals(true, b.contain(8));
        assertEquals(false, b.contain(9));
    }

    @Test
    public void testClear_1() {
        binaryTree<Integer> b = new binaryTree<>();
        b.insert(5);
        b.insert(6);
        b.insert(3);
        b.insert(1);
        b.insert(0);
        b.insert(4);
        b.insert(8);

        b.clear();
        assertEquals(0, b.size());
    }
}
