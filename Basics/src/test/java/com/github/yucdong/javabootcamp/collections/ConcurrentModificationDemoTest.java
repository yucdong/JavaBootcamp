package com.github.yucdong.javabootcamp.collections;

import org.junit.Test;

import java.util.ConcurrentModificationException;

import static org.junit.Assert.*;

public class ConcurrentModificationDemoTest {

    @Test(expected = ConcurrentModificationException.class)
    public void testConcurrentModification() {
        ConcurrentModificationDemo demo = new ConcurrentModificationDemo();
        demo.throwsConcurrent();
    }
}