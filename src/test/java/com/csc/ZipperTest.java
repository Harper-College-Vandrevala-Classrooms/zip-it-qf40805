package com.csc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ZipperTest {

    Zipper zipper;

    @BeforeEach
    void setUp() {
        zipper = new Zipper();
    }

    @Test
    void itWorks() {
        assertEquals(true, true);
    }

    @Test
    public void testZipEqualLength() {
        List<Integer> list1 = Arrays.asList(1, 3, 5);
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, zipper.zip(list1, list2));
    }

    @Test
    public void testZipUnequalLength() {
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> list2 = Arrays.asList(2, 4);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 7);
        assertEquals(expected, zipper.zip(list1, list2));
    }

    @Test
    public void testZipFirstListLonger() {
        List<String> list1 = Arrays.asList("A", "B", "C", "D");
        List<String> list2 = Arrays.asList("1", "2");
        List<String> expected = Arrays.asList("A", "1", "B", "2", "C", "D");
        assertEquals(expected, zipper.zip(list1, list2));
    }

    @Test
    public void testZipSecondListLonger() {
        List<String> list1 = Arrays.asList("X", "Y");
        List<String> list2 = Arrays.asList("1", "2", "3", "4");
        List<String> expected = Arrays.asList("X", "1", "Y", "2", "3", "4");
        assertEquals(expected, zipper.zip(list1, list2));
    }

    @Test
    public void testZipBothListsEmpty() {
        List<Integer> list1 = Arrays.asList();
        List<Integer> list2 = Arrays.asList();
        List<Integer> expected = Arrays.asList();
        assertEquals(expected, zipper.zip(list1, list2));
    }

    @Test
    public void testZipFirstListEmpty() {
        List<Integer> list1 = Arrays.asList();
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        List<Integer> expected = Arrays.asList(2, 4, 6);
        assertEquals(expected, zipper.zip(list1, list2));
    }

    @Test
    public void testZipSecondListEmpty() {
        List<Integer> list1 = Arrays.asList(1, 3, 5);
        List<Integer> list2 = Arrays.asList();
        List<Integer> expected = Arrays.asList(1, 3, 5);
        assertEquals(expected, zipper.zip(list1, list2));
    }

    @Test
    public void testHashmapifyEqualSize() {
        List<String> keys = Arrays.asList("key1", "key2", "key3");
        List<Integer> values = Arrays.asList(1, 2, 3);
        HashMap<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("key1", 1);
        expectedMap.put("key2", 2);
        expectedMap.put("key3", 3);
        assertEquals(expectedMap, zipper.hashmapify(keys, values));
    }

    @Test
    public void testHashmapifyUnequalSize() {
        List<String> keys = Arrays.asList("key1", "key2");
        List<Integer> values = Arrays.asList(1);
        assertThrows(IllegalArgumentException.class, () -> {
            zipper.hashmapify(keys, values);
        });
    }
}
