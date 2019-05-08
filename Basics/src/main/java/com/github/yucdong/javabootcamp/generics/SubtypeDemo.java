package com.github.yucdong.javabootcamp.generics;

import java.util.ArrayList;
import java.util.List;

public class SubtypeDemo {
    public static void test(List<Number> ln) {
        System.out.println(ln.size());
    }

    public static void main(String[] args) {
        List<Float> lf = new ArrayList<>();
        lf.add(2.2f);
        // test(lf); Error: List<Float> is not subtype of List<Number>
        List<Number> ln = new ArrayList<>();
        ln.add(2.2f);
        test(ln);

        ArrayList<Number> aln = new ArrayList<>();
        aln.add(2.2f);
        test(aln); // OK, ArrayList<Number> is subtype of List<Number>
    }
}
