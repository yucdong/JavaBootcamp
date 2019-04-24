package com.github.yucdong.javabootcamp.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardDemo {

    /**
     * Read Guidelines for using wildcard:
     * https://docs.oracle.com/javase/tutorial/java/generics/wildcardGuidelines.html
     */

    // Upperbound wildcard
    // List<? extends Integer> is a subtype of List<? extends Number>
    public static void process(List<? extends Number> ln) {
        for (Number elem : ln) {
            System.out.println(elem);
        }
    }

    // Use ? to represent all types
    // because List<String> is not a subtype of List<Object>
    // List<String> and List<Number> are both subtype of List<?>
    public static void printAllTypes(List<?> lst) {
        for (Object elem : lst) {
            System.out.println(elem);
        }
    }

    // Lowerbound wildcard
    public static void processLower(List<? super Integer> lin) {
        lin.add(1);
    }

    public static void main(String[] args) {
        List<Double> ld = new ArrayList<>();
        ld.add(2.2);
        process(ld);

        List<String> ls = Arrays.asList("good", "bad", "terrible");
        printAllTypes(ls);

        List<Number> ln = new ArrayList<>();
        processLower(ln);
        System.out.println(ln);
    }
}
