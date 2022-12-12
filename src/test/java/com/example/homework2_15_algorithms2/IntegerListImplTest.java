package com.example.homework2_15_algorithms2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {

    private IntegerListImpl integerList1;

    private IntegerListImpl integerList2;

    @BeforeEach
    public void setUP(){
        integerList1 = new IntegerListImpl(5);
        integerList1.add(77);
        integerList1.add(7);
        integerList1.add(777);
        integerList1.add(99);
        integerList1.add(9);
        integerList2 = new IntegerListImpl(5);
        integerList2.add(77);
        integerList2.add(7);
        integerList2.add(777);
        integerList2.add(99);
        integerList2.add(9);
    }

    @Test
    void add() {
        Assertions.assertTrue(integerList1.equals(integerList2));
    }

    @Test
    void testAddIndex() {
        integerList1.add(1, 7);
        integerList2.add(1, 7);
        Assertions.assertTrue(integerList1.equals(integerList2));
    }

    @Test
    void set() {
        integerList1.set(3, 99);
        integerList2.set(3, 99);
        Assertions.assertTrue(integerList1.equals(integerList2));
    }

    @Test
    void remove() {
        integerList1.remove(2);
        integerList2.remove(2);
        Assertions.assertTrue(integerList1.equals(integerList2));
    }

    @Test
    void testRemoveIndex() {
        integerList1.remove(1);
        integerList2.remove(1);
        Assertions.assertTrue(integerList1.equals(integerList2));
    }

    @Test
    void contains() {
        Assertions.assertTrue(integerList1.equals(integerList2));
    }

    @Test
    void indexOf() {
        integerList1.indexOf(4);
        integerList2.indexOf(4);
        Assertions.assertTrue(integerList1.equals(integerList2));
    }

    @Test
    void lastIndexOf() {
        integerList1.lastIndexOf(3);
        integerList2.lastIndexOf(3);
        Assertions.assertTrue(integerList1.equals(integerList2));
    }

    @Test
    void get() {
        integerList1.get(1);
        integerList2.get(1);
        Assertions.assertTrue(integerList1.equals(integerList2));
    }

    @Test
    void testEquals() {
        integerList1.equals(2);
        integerList1.equals(2);
        Assertions.assertTrue(integerList1.equals(integerList2));
    }

    @Test
    void size() {
        integerList1.size();
        integerList2.size();
        Assertions.assertTrue(integerList1.equals(integerList2));
    }

    @Test
    void isEmpty() {
        integerList1.isEmpty();
        integerList2.isEmpty();
        Assertions.assertTrue(integerList1.equals(integerList2));
    }

    @Test
    void clear() {
        integerList1.clear();
        integerList2.clear();
        Assertions.assertTrue(integerList1.equals(integerList2));
    }

    @Test
    void toArray() {
        integerList1.toArray();
        integerList2.toArray();
        Assertions.assertTrue(integerList1.equals(integerList2));
    }
}