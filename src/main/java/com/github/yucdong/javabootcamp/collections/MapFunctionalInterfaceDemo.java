package com.github.yucdong.javabootcamp.collections;

import java.util.HashMap;
import java.util.Map;

public class MapFunctionalInterfaceDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("123", "abc");

        map.computeIfAbsent("456", (key) -> key + "789");
        System.out.println(map.get("456"));

        map.computeIfPresent("123", (key, value) -> key + value);
        System.out.println(map.get("123"));

        map.merge("789", "gaga", (oldvalue, newvalue) -> oldvalue + newvalue);
        System.out.println(map.get("789"));

        map.merge("123", "gaga", (oldvalue, newvalue) -> oldvalue + newvalue);
        System.out.println(map.get("123"));
    }
}
