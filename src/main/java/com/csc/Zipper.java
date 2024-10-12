package com.csc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Zipper {
    public static <T> List<T> zip(List<T> list1, List<T> list2) {
        // Null checks for input lists
        if (list1 == null || list2 == null) {
            return new ArrayList<>(); // Return an empty list if any list is null
        }

        List<T> zippedList = new ArrayList<>();
        int minLength = Math.min(list1.size(), list2.size());

        for (int i = 0; i < minLength; i++) {
            zippedList.add(list1.get(i));
            zippedList.add(list2.get(i));
        }

        // Add remaining elements from the longer list
        if (list1.size() > minLength) {
            zippedList.addAll(list1.subList(minLength, list1.size()));
        } else if (list2.size() > minLength) {
            zippedList.addAll(list2.subList(minLength, list2.size()));
        }

        return zippedList;
    }

    public static <K, V> HashMap<K, V> hashmapify(List<K> keys, List<V> values) {
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException("Keys and values lists must be of the same size.");
        }

        HashMap<K, V> map = new HashMap<>();
        for (int i = 0; i < keys.size(); i++) {
            map.put(keys.get(i), values.get(i));
        }
        return map;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);

        List<Integer> result = zip(list1, list2);
        System.out.println(result); // Output: [1, 4, 2, 5, 3]
        
        // Testing with null lists
        System.out.println(zip(null, list2)); // Output: []
        System.out.println(zip(list1, null)); // Output: []
        System.out.println(zip(null, null)); // Output: []
    }
}
