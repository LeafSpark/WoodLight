package com.woodlight.datasets;

import java.util.Set;
import java.util.TreeSet;
import java.util.*;

public class FindNumber {
    public void setFindNumber() {
        Set<Integer> set = new TreeSet<>();
        Set<Integer> setOne = new TreeSet<>();
        int[] numbers = {1, 3, 5, 7, 9, 11, 13, 15};
        int[] numbersOne = {2, 3, 5, 7, 11, 13, 17};
        for (int i = 0; i <= numbers.length - 1; i++) {
            set.add(numbers[i]);
        }
        for (int i = 0; i <= numbersOne.length - 1; i++) {
            setOne.add(numbersOne[i]);
        }

        Set<Integer> setres = new TreeSet<>();

        for (int temp : set) {
            // find the temp in setOne
//            for (int temp1 : setOne) {
//                if (temp == temp1) {
//                     setres.add(temp);
//                }
//            }

            if (setOne.contains(temp)) {
                setres.add(temp);
            }
        }
        for (int temp : setres) {
            System.out.println(temp);
        }
    }

    public void hashMapsTest() {
        Map<String, Integer> hashMap = new HashMap<>();

        hashMap.put("John", 14);
        hashMap.put("Alice", 18);
        hashMap.put("Ryan", 24);
        hashMap.put("Jess", 7);

        System.out.println(hashMap.get("Jess"));

        hashMap.put("Jess", 15);

        System.out.println(hashMap.get("Jess"));

//
//        for (Map.Entry<String, Integer> thisEntry : hashMap.entrySet()) {
//            System.out.println(thisEntry.getKey() + ": " + thisEntry.getValue());
//        }
//

        hashMap.remove("Ryan");

        System.out.println("\nAfter removing...");
        for (Map.Entry<String, Integer> thisEntry : hashMap.entrySet()) {
            System.out.println(thisEntry.getKey() + ": " + thisEntry.getValue());
        }
    }
}
