package com.ozzero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ComplexNumberTest {
    @Test
    public void testAdd_1() {
        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(2, 2);

        a.add(b);
        assertEquals(new ComplexNumber(3, 3), a);
    }

    @Test
    public void testAdd_2() {
        ComplexNumber a = new ComplexNumber(-1, -1);
        ComplexNumber b = new ComplexNumber(2, 2);

        a.add(b);
        assertEquals(new ComplexNumber(1, 1), a);
    }

    @Test
    public void testAdd_3() {
        ComplexNumber a = new ComplexNumber(-1, -1);
        ComplexNumber b = new ComplexNumber(-2, -2);

        a.add(b);
        assertEquals(new ComplexNumber(-3, -3), a);
    }


    @Test
    public void testMinus_1() {
        ComplexNumber a = new ComplexNumber(-1, -1);
        ComplexNumber b = new ComplexNumber(-2, -2);

        a.minus(b);
        assertEquals(new ComplexNumber(1, 1), a);
    }

    @Test
    public void testMinus_2() {
        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(2, 2);

        a.minus(b);
        assertEquals(new ComplexNumber(-1, -1), a);
    }

    @Test
    public void testMinus_3() {
        ComplexNumber a = new ComplexNumber(0, 1);
        ComplexNumber b = new ComplexNumber(-1, 0);

        a.minus(b);
        assertEquals(new ComplexNumber(1, 1), a);
    }

    @Test
    public void testEquals_1() {
        ComplexNumber a = new ComplexNumber(0, 1);
        ComplexNumber b = new ComplexNumber(1, 2);

        assertFalse(a.equals(b));
    }
    @Test
    public void testEquals_2() {
        
        ComplexNumber a = new ComplexNumber(0, 1);
        ComplexNumber b = new ComplexNumber(0, 1);

        assertTrue(a.equals(b));
    }
    @Test
    public void testEquals_3() {
        ComplexNumber a = new ComplexNumber();
        ComplexNumber b = new ComplexNumber();

        assertTrue(a.equals(b));
    }

    @Test
    public void testGetAbs_1() {
        ComplexNumber a = new ComplexNumber(1, 1);
        assertTrue(Math.sqrt(2) == a.getAbs());
    }

    @Test
    public void testGetAbs_2() {
        ComplexNumber a = new ComplexNumber(0, 0);
        assertTrue(0 == a.getAbs());
    }

    @Test
    public void testGetArg_1() {
        ComplexNumber a = new ComplexNumber(1, 1);
        assertTrue(Math.PI / 4 == a.getArg());
    }


    @Test
    public void testGetArg_2() {
        ComplexNumber a = new ComplexNumber(0, 1);
        assertTrue(Math.PI / 2 == a.getArg());
    }

    @Test
    public void testGetArg_3() {
        ComplexNumber a = new ComplexNumber(0, -1);
        assertTrue(3 * Math.PI / 2  == a.getArg());
    }

    @Test
    public void testGetImage_1() {
        ComplexNumber a = new ComplexNumber(0, 1);
        assertTrue(1 == a.getImage());
    }

    @Test
    public void testGetReal_1() {
        ComplexNumber a = new ComplexNumber(0, 1);
        assertTrue(0 == a.getReal());
    }

    @Test
    public void testSetImage_1() {
        ComplexNumber a = new ComplexNumber(0, 1);
        a.setImage(2);
        assertTrue(2 == a.getImage());
        a.setImage(3);
        assertTrue(3 == a.getImage());
        a.setImage(4);
        assertTrue(4 == a.getImage());
    }

    @Test
    public void testSetReal_1() {
        ComplexNumber a = new ComplexNumber(0, 1);
        a.setReal(2);
        assertTrue(2 == a.getReal());
        a.setReal(3);
        assertTrue(3 == a.getReal());
        a.setReal(4);
        assertTrue(4 == a.getReal());
    }


}
