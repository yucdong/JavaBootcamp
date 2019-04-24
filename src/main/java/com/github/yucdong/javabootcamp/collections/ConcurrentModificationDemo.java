package com.github.yucdong.javabootcamp.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationDemo {
    public void throwsConcurrent() {
        // Some collections do not allow to modify it
        // during iteration
        List<String> list = new ArrayList<String>();
        list.add("123");
        list.add("456");
        list.add("789");

        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String value = iter.next();

            System.out.println(value);
            if (value.equals("456")) {
                list.add("hey");
            }
        }
    }
}
