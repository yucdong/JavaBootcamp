package com.github.yucdong.javabootcamp.generics;

public class BoundedParamDemo {
    public static <T extends Number> void inspect(T t) {
        System.out.println("Class is " + t.getClass().getName());
    }

    // Restrict T to inherit from some interface
    public static <T extends Comparable<T>> int lessCount(T[] arr, T elem) {
        int cnt = 0;
        for (T t : arr) {
            if (t.compareTo(elem) < 0) {
                cnt++;
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        inspect(new Integer(1));
        inspect(new Float(2.0));
        // compile error: inspect(new String("haha"));

        String[] arr = new String[] {"good", "bad"};
        int cnt = lessCount(arr, "dsa");
        System.out.println(cnt);

    }
}
